package com.akshay.textstyle.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.akshay.textstyle.R
import com.akshay.textstyle.adapter.CustomDrawerListAdapter
import com.akshay.textstyle.databinding.ActivityMainScreenBinding
import com.akshay.textstyle.model.CustomListItem
import com.akshay.textstyle.model.Quote
import com.akshay.textstyle.network.ApiClient
import com.akshay.textstyle.network.QuoteApi
import com.akshay.textstyle.notification.QuoteNotificationWorker
import com.akshay.textstyle.utils.Constants
import com.akshay.textstyle.utils.Network
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.TimeUnit

class MainScreen : AppCompatActivity() {

    var binding :ActivityMainScreenBinding? = null
    private lateinit var drawerLayout: DrawerLayout
    val drawerItem = listOf(
        CustomListItem(R.drawable.share_icon, "share"),
        CustomListItem(R.drawable.ic_heart_red, "saved"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainScreenBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        MobileAds.initialize(this)
        val request = AdRequest.Builder().build()
        binding!!.adViewMainscreen.loadAd(request)
        drawerLayout = binding!!.drawerLayout

        val navListView: ListView = binding!!.navListView
        val drawerAdapter = CustomDrawerListAdapter(this,drawerItem)
        navListView.adapter = drawerAdapter

        navListView.setOnItemClickListener { _, _, position, _ ->
            when (position) {
                0 -> {
                    // Share item is clicked, handle accordingly
                    val sharingIntent = Intent(Intent.ACTION_SEND)
                    sharingIntent.type = "text/plain"
                    val shareBody = "https://play.google.com/store/apps/details?id=com.akshay.textstyle"
                    val shareSubject =
                        "App for fonts, big text, text repetition, and text encrypting and decrypting."
                    sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
                    sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject)
                    startActivity(Intent.createChooser(sharingIntent, "Share using"))
                    openShareDrawer()
                }
                1 -> {
                    val i = Intent(this@MainScreen, Saved::class.java)
                    startActivity(i)
                }
                // Add more cases for other items
            }
            // Close the drawer after handling the click
            drawerLayout.closeDrawer(GravityCompat.START)
        }

        // Set up the Share button click listener to open the drawer
        binding!!.btnShare.setOnClickListener {
            openShareDrawer()
        }
        scheduleDailyQuoteNotification()
        checkAndShowSnackbar()

        binding!!.quotesBtn.setOnClickListener {
            val i = Intent(this@MainScreen, Quotes::class.java)
            startActivity(i)
        }

        binding!!.quickStylesBtn.setOnClickListener {
            val i = Intent(this@MainScreen, QuickStyles::class.java)
            startActivity(i)
        }

        binding!!.bigTextBtn.setOnClickListener {
            val i = Intent(this@MainScreen, BigtextActivity::class.java)
            startActivity(i)
        }

        binding!!.createTextBtn.setOnClickListener {
            val i = Intent(this@MainScreen, MainActivity::class.java)
            startActivity(i)
        }

        binding!!.encryptAndDecryptBtn.setOnClickListener {
            val i = Intent(this@MainScreen, EncryptAndDecrypt::class.java)
            startActivity(i)
        }

        binding!!.textRepeaterBtn.setOnClickListener {
            val i = Intent(this@MainScreen, TextRepeater::class.java)
            startActivity(i)
        }
/*
        binding!!.btnShare.setOnClickListener {
            val sharingIntent = Intent(Intent.ACTION_SEND)

            sharingIntent.type = "text/plain"

            val shareBody = "https://play.google.com/store/apps/details?id=com.akshay.textstyle"

            val shareSubject =
                "App for fonts, big text, text repetition, and text encrypting and decrypting."

            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)

            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject)
            startActivity(Intent.createChooser(sharingIntent, "Share using"))
        }
*/

        binding!!.cvQuote.setOnClickListener {
            val textData = "${binding!!.tvQuotes.text}      \n \n ${binding!!.tvAuthor.text}"
            val intent = Intent(this, DoneScreen::class.java)
            intent.putExtra("textDataKey", textData)
            startActivity(intent)
        }

        randomQuote()
    }
    private fun scheduleDailyQuoteNotification() {

        val uniqueWorkName = "QuoteNotification"
        val request = PeriodicWorkRequestBuilder<QuoteNotificationWorker>(
            1, TimeUnit.DAYS
        )
            .build()

        val workManager = WorkManager.getInstance(applicationContext)
        val workInfo = workManager.getWorkInfosForUniqueWork(uniqueWorkName).get()

        if (workInfo.isNullOrEmpty()) {

            workManager.enqueueUniquePeriodicWork(
                uniqueWorkName,
                ExistingPeriodicWorkPolicy.KEEP,
                request
            )
        }
    }

    private fun randomQuote(){
        val apiService = ApiClient.retrofit(Constants.BASE_URL_ZEN_QUOTES).create(QuoteApi::class.java)
        val call = apiService.getRandomQuotes()
        call.enqueue(object : Callback<List<Quote>> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<List<Quote>>, response: Response<List<Quote>>) {
                if (response.isSuccessful) {
                    val quotes = response.body()
                    if (!quotes.isNullOrEmpty()) {
                        binding!!.tvQuotes.text = quotes[0].q
                        binding!!.tvAuthor.text = "- ${quotes[0].a}"
                        binding!!.pbMainQuote.visibility = View.INVISIBLE

                        // Use the quoteText and author in your app
                    }
                } else {
                    // Handle unsuccessful response
                }
            }

            override fun onFailure(call: Call<List<Quote>>, t: Throwable) {
                // Handle network failure
            }
        })
    }

    private fun checkAndShowSnackbar() {
        if (!Network.isNetworkAvailable(this)) {
            Network.showNoInternetSnackbar(
                binding!!.mainScreenRoot, // Replace with your root layout ID
                this
            )
        }
    }

    private fun openShareDrawer() {
        // Open the drawer when the Share button is clicked
        drawerLayout.openDrawer(GravityCompat.START)
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

}