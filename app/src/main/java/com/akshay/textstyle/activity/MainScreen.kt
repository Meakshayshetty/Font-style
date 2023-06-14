package com.akshay.textstyle.activity

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.akshay.textstyle.R
import com.akshay.textstyle.databinding.ActivityMainScreenBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class MainScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         val binding =ActivityMainScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MobileAds.initialize(this)
        val request = AdRequest.Builder().build()
        binding.adViewMainscreen.loadAd(request)


        val animation1: Animation = AnimationUtils.loadAnimation(applicationContext,
            R.anim.shake_animation)
        binding.imageView.startAnimation(animation1)


        binding.bigTextBtn.setOnClickListener {
            val i = Intent(this@MainScreen, BigtextActivity::class.java)
            startActivity(i)
        }

        binding.createTextBtn.setOnClickListener {
            val i = Intent(this@MainScreen, MainActivity::class.java)
            startActivity(i)
        }

        binding.encryptAndDecryptBtn.setOnClickListener {
            val i = Intent(this@MainScreen, EncryptAndDecrypt::class.java)
            startActivity(i)
        }

        binding.textRepeaterBtn.setOnClickListener {
            val i = Intent(this@MainScreen, TextRepeater::class.java)
            startActivity(i)
        }
    }
}