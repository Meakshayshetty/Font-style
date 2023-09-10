package com.akshay.textstyle.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.view.View
import androidx.core.content.ContextCompat
import com.akshay.textstyle.R
import com.google.android.material.snackbar.Snackbar

object Network {

    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val networkCapabilities = connectivityManager.activeNetwork ?: return false
            val activeNetwork =
                connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false

            return activeNetwork.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        } else {
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnected
        }
    }

    fun showNoInternetSnackbar(view: View, context: Context) {
        val snackbar = Snackbar.make(
            view,
            "No network? Connect and restart the app.",
            Snackbar.LENGTH_LONG
        )
        snackbar.view.setBackgroundColor(ContextCompat.getColor(context, R.color.snackbar_background))
        snackbar.show()
    }
}