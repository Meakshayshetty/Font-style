package com.akshay.textstyle.notification

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.akshay.textstyle.R
import com.akshay.textstyle.activity.Quotes
import com.akshay.textstyle.model.Quote
import com.akshay.textstyle.network.ApiClient
import com.akshay.textstyle.network.QuoteApi
import com.akshay.textstyle.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class QuoteNotificationWorker(private val context: Context, params: WorkerParameters) :
    CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        try {
            if (!isNotificationSentToday(context)) {

                val apiService =
                    ApiClient.retrofit(Constants.BASE_URL_ZEN_QUOTES).create(QuoteApi::class.java)
                val call = apiService.getRandomQuotes()

                call.enqueue(object : Callback<List<Quote>> {
                    override fun onResponse(
                        call: Call<List<Quote>>,
                        response: Response<List<Quote>>
                    ) {
                        if (response.isSuccessful) {
                            val quoteList = response.body()

                            if (!quoteList.isNullOrEmpty()) {
                                val quote = quoteList[0].q
                                val author = quoteList[0].a

                                createNotification(quote, author)

                                saveNotificationTimestamp(context)

                            }
                        }
                    }

                    override fun onFailure(call: Call<List<Quote>>, t: Throwable) {
                        // Handle failure here
                    }
                })

            }
            return Result.success()
        } catch (e: Exception) {
            // Handle exceptions here if needed
            return Result.failure()
        }
    }

    @SuppressLint("UnspecifiedImmutableFlag")
    private fun createNotification(quote: String, author: String) {
        val notificationManager = NotificationManagerCompat.from(context)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }

        val intent = Intent(context, Quotes::class.java)
        val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)

        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setContentTitle("Daily Quote")
            .setContentText("\"$quote\" - $author")

            //TODO: notification icon
            .setSmallIcon(R.drawable.app_logo)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)  // Set the intent here
            .setStyle(NotificationCompat.BigTextStyle().bigText("\"$quote\" - $author"))
            .build()

        notificationManager.notify(NOTIFICATION_ID, notification)
    }

    private fun isNotificationSentToday(context: Context): Boolean {
        val sharedPreferences =
            context.getSharedPreferences("notification_prefs", Context.MODE_PRIVATE)
        val lastNotificationTime = sharedPreferences.getLong("last_notification_time", 0)
        val currentTime = System.currentTimeMillis()
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = currentTime
        val today = calendar.get(Calendar.DAY_OF_YEAR)

        calendar.timeInMillis = lastNotificationTime
        val lastNotificationDay = calendar.get(Calendar.DAY_OF_YEAR)

        return today == lastNotificationDay
    }

    private fun saveNotificationTimestamp(context: Context) {
        val sharedPreferences =
            context.getSharedPreferences("notification_prefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putLong("last_notification_time", System.currentTimeMillis())
        editor.apply()
    }

    companion object {
        private const val CHANNEL_ID = "quote_channel"
        private const val CHANNEL_NAME = "Quote Channel"
        private const val NOTIFICATION_ID = 1
    }
}