package com.akshay.textstyle.activity

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.akshay.textstyle.R
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class MainScreen : AppCompatActivity() {

    private var imageView: ImageView? = null
    private var createBtn: ImageButton? = null
    private var encryptAndDecryptBtn: ImageButton? = null
    private var textRepeaterBtn: ImageButton? = null
    private lateinit var bigTextBtn :ImageButton

    private lateinit var adView: AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        imageView = findViewById(R.id.imageView)
        createBtn = findViewById(R.id.create_text_btn)
        encryptAndDecryptBtn = findViewById(R.id.encrypt_and_decrypt_btn)
        textRepeaterBtn = findViewById(R.id.text_repeater_btn)
        bigTextBtn = findViewById(R.id.big_text_btn)

        MobileAds.initialize(this)
        val request = AdRequest.Builder().build()
        adView = findViewById(R.id.adView_mainscreen)
        adView.loadAd(request)


        val animation1: Animation = AnimationUtils.loadAnimation(applicationContext,
            R.anim.shake_animation)
        imageView!!.startAnimation(animation1)


        bigTextBtn.setOnClickListener {
            val i = Intent(this@MainScreen, BigtextActivity::class.java)
            startActivity(i)
        }

        createBtn?.setOnClickListener {
            val i = Intent(this@MainScreen, MainActivity::class.java)
            startActivity(i)
        }

        encryptAndDecryptBtn?.setOnClickListener {
            val i = Intent(this@MainScreen, EncryptAndDecrypt::class.java)
            startActivity(i)
        }

        textRepeaterBtn?.setOnClickListener {
            val i = Intent(this@MainScreen, TextRepeater::class.java)
            startActivity(i)
        }
    }
}