package com.akshay.textstyle.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.akshay.textstyle.R


@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // the splash screen as a full screen activity.
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        val splash_image: ImageView = findViewById(R.id.splashScreen_image)
        val slideAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        splash_image.startAnimation(slideAnimation)

         Handler().postDelayed({
             // This method will be executed once the timer is over
             // Start your app main activity
             val i = Intent(this@SplashScreen, MainActivity::class.java)
             startActivity(i)
             // Close this activity
             finish()
         }, 2000)
    }
}