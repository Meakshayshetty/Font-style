package com.akshay.textstyle.activity

import android.content.ClipData
import android.content.ClipboardManager
import android.content.ContentValues
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.akshay.textstyle.R
import com.akshay.textstyle.databinding.ActivityEncryptAndDecryptBinding
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback


class EncryptAndDecrypt : AppCompatActivity() {

    private var editTextMain :EditText?=null
    private var mainText:TextView?=null


    private var mInterstitialAd: InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityEncryptAndDecryptBinding.inflate(layoutInflater)
        setContentView(binding.root)

        editTextMain = binding.editTextEncryptAndDecrypt
        mainText = binding.mainTextEncrypt



        MobileAds.initialize(this)

        val adRequest = AdRequest.Builder().build()
        binding.adViewEncrypt.loadAd(adRequest)


        InterstitialAd.load(this,getString(R.string.encrypt_screen_interstitial_uniid),adRequest, object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                adError.toString().let { Log.d(ContentValues.TAG, it) }
                Log.d("not load", "error loading.")

                mInterstitialAd = null
            }

            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                Log.d("load", "ad loaded.")
                mInterstitialAd = interstitialAd

                mInterstitialAd?.fullScreenContentCallback = object: FullScreenContentCallback() {
                    override fun onAdClicked() {
                        // Called when a click is recorded for an ad.
                        Log.d(ContentValues.TAG, "Ad was clicked.")
                    }

                    override fun onAdDismissedFullScreenContent() {
                        // Called when ad is dismissed.
                        Log.d(ContentValues.TAG, "Ad dismissed fullscreen content.")
                        mInterstitialAd = null
                    }

                    override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                        // Called when ad fails to show.
                        Log.e(ContentValues.TAG, "Ad failed to show fullscreen content.")
                        mInterstitialAd = null
                    }

                    override fun onAdImpression() {
                        // Called when an impression is recorded for an ad.
                        Log.d(ContentValues.TAG, "Ad recorded an impression.")
                    }

                    override fun onAdShowedFullScreenContent() {
                        // Called when ad is shown.
                        Log.d(ContentValues.TAG, "Ad showed fullscreen content.")
                    }
                }
            }
        })
        /*Handler().postDelayed({
            if(mInterstitialAd !=null){
                mInterstitialAd?.show(this)
            }else Log.e("error","ad null")
        },8000)*/

        //showInterstitialAdDelayed()


        binding.encryptBtn.setOnClickListener {
            val string = with(editTextMain){this?.text.toString()}
            val encryptString = encrypt(string)
            with(mainText){this?.text= encryptString}
        }

        binding.decryptBtn.setOnClickListener {
            val string = with(editTextMain){this?.text.toString()}
            val decryptString = decrypt(string)
            with(mainText){this?.text= decryptString}
        }

        binding.ibClear.setOnClickListener {
            with(editTextMain) { this?.setText("") }
        }

        binding.btnCopy.setOnClickListener {
            val mainTextString = with(mainText){this?.text.toString()}
            saveToClipboard(mainTextString)
        }
    }
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()
        showInterstitialAdDelayed()
    }

    private fun showInterstitialAdDelayed() {
        val delayMillis = 1000L // Delay between each check in milliseconds
        val maxAttempts = 10 // Maximum number of attempts

        var currentAttempt = 0

        val runnable = object : Runnable {
            override fun run() {
                if (mInterstitialAd != null) {
                    mInterstitialAd?.show(this@EncryptAndDecrypt)
                } else {
                    currentAttempt++
                    if (currentAttempt <= maxAttempts) {
                        Handler().postDelayed(this, delayMillis)
                    } else {
                        Log.e("error", "ad null")
                    }
                }
            }
        }
        Handler().postDelayed(runnable, delayMillis)
    }

    private fun encrypt(str :String) :String {
        var encrypt = ""

        for (i  in str) encrypt += if (i.isUpperCase()&& i.isLetter()) {
            ((i + 3 -65).code % 26+65).toChar()
        } else if(i.isLowerCase() && i.isLetter()){
            ((i + 3-97).code % 26+97).toChar()
        } else{
            i
        }
        return encrypt
    }
    private fun saveToClipboard(string:String){
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("simple text", string)
        clipboard.setPrimaryClip(clip)

        Toast.makeText(this,
            "$string Copied to clipboard!",
            Toast.LENGTH_SHORT).show()
    }

    private fun decrypt(str :String) :String {
        var decrypt = ""

        for (i  in str) {
            decrypt += if (i.isUpperCase()&& i.isLetter()) {
                ((i +(26-3) -65).code % 26+65).toChar()
            } else if(i.isLowerCase() && i.isLetter()){
                ((i + (26-3)-97).code % 26+97).toChar()
            } else{
                i
            }
        }
        return decrypt
    }
}