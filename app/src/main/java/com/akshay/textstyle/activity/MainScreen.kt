package com.akshay.textstyle.activity

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.akshay.textstyle.R

class MainScreen : AppCompatActivity() {

    var imageView: ImageView?=null
    var createtxtBtn : ImageButton?=null
    var encryptAndDecryptBtn : ImageButton?=null
    var textRepeaterBtn :ImageButton?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        imageView = findViewById(R.id.imageView)
        createtxtBtn = findViewById(R.id.create_text_btn)
        encryptAndDecryptBtn = findViewById(R.id.encrypt_and_decrypt_btn)
        textRepeaterBtn = findViewById(R.id.text_repeater_btn)


        val animation1: Animation = AnimationUtils.loadAnimation(applicationContext,
            R.anim.shake_animation)
        imageView!!.startAnimation(animation1)

        createtxtBtn?.setOnClickListener{
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