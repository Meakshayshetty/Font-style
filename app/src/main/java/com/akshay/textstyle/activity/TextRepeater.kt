package com.akshay.textstyle.activity

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.akshay.textstyle.R
import com.akshay.textstyle.databinding.ActivityTextRepaterBinding
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class TextRepeater : AppCompatActivity() {

    private lateinit var checkbox1: CheckBox
    private lateinit var checkbox2: CheckBox
    private lateinit var checkbox3: CheckBox
    private lateinit var editTextMain:EditText
    private lateinit var editTextRepeater:EditText
    private lateinit var mainText:TextView

    private var mInterstitialAd:InterstitialAd?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTextRepaterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkbox1 = binding.checkbox1
        checkbox2 = binding.checkbox2
        checkbox3 = binding.checkbox3
        editTextMain = binding.editTextMainRepeater
        editTextRepeater = binding.editTextRepetition
        mainText = binding.mainTextRepeater



        MobileAds.initialize(this)

        val adRequest = AdRequest.Builder().build()
        binding.repeaterAdView.loadAd(adRequest)

        InterstitialAd.load(this,getString(R.string.text_repeater_interstitial_uniid),adRequest, object : InterstitialAdLoadCallback() {
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
      /*  Handler().postDelayed({
            if(mInterstitialAd !=null){
                mInterstitialAd?.show(this)
            }else Log.e("error","ad null")
        },8000)*/

       // showInterstitialAdDelayed()



        checkbox1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                checkbox2.isChecked = false
                checkbox3.isChecked = false
            }
        }

        checkbox2.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                checkbox1.isChecked = false
                checkbox3.isChecked = false
            }
        }

        checkbox3.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                checkbox1.isChecked = false
                checkbox2.isChecked = false
            }
        }
        binding.generateBtnRepeater.setOnClickListener {

            if(editTextMain.text.isEmpty()){
                Toast.makeText(this@TextRepeater,
                    "Enter the text",Toast.LENGTH_SHORT).show()
            }else if(editTextRepeater.text.isEmpty()) {
                Toast.makeText(this@TextRepeater,
                    "Enter the number of Repetition",Toast.LENGTH_SHORT).show()
            }else{
                val text = editTextMain.text.toString()
                val noOfRepetitiation = editTextRepeater.text.toString().toInt()
                val repeatedText = generateText(text, noOfRepetitiation)
                mainText.text = repeatedText
            }
        }
        binding.mainClear.setOnClickListener {
            editTextMain.setText("")
        }
        binding.repeatClear.setOnClickListener {
            editTextRepeater.setText("")
        }

        binding.resetBtnRepeater.setOnClickListener {
            editTextMain.setText("")
            editTextRepeater.setText("")
            mainText.text = ""
        }

        binding.repeaterCopy.setOnClickListener{
            showInterstitialAdDelayed()
            val repeaterText = mainText.text.toString()
            val intent = Intent(this, DoneScreen::class.java)
            intent.putExtra("textDataKey", repeaterText)
            startActivity(intent)
        }
    }
    private fun showInterstitialAdDelayed() {
        val delayMillis = 1000L // Delay between each check in milliseconds
        val maxAttempts = 10 // Maximum number of attempts

        var currentAttempt = 0

        val runnable = object : Runnable {
            override fun run() {
                if (mInterstitialAd != null) {
                    mInterstitialAd?.show(this@TextRepeater)
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

    private fun generateText(text:String,times: Int):String{
        val result: String = if(checkbox1.isChecked){
            repeatText(text, times)
        }else if(checkbox2.isChecked){
            repeatText(text,times,2)
        }else{
            repeatText(text,times,3)
        }
        return result
    }

    private fun repeatText(text: String, times: Int, repetitionMode: Int = 1): String {
        var result = ""
        for (i in 1..times) {
            result += text
            when (repetitionMode) {
                2 -> result += " " // Add a space between each repetition
                3 -> result += "\n" // Add a newline after each repetition
            }
        }
        return result
    }
}