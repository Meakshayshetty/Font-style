package com.akshay.textstyle.activity

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.akshay.textstyle.databinding.ActivityDoneScreenBinding

class DoneScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDoneScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val receivedText = intent.getStringExtra("textDataKey")

        if (receivedText != null) {
            // Do something with the received text data
            binding.tvDone.text = receivedText
        }
    }
    private fun saveToClipboard(desStr: String) {
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("simple text", desStr)
        clipboard.setPrimaryClip(clip)

        Toast.makeText(
            this,
            "$desStr Copied to clipboard!",
            Toast.LENGTH_SHORT
        ).show()
    }
}