package com.akshay.textstyle.activity

import android.content.*
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.akshay.textstyle.R
import com.akshay.textstyle.databinding.ActivityDoneScreenBinding

class DoneScreen : AppCompatActivity() {

    private var heartIcon: ImageView? = null
    private var generatedText:TextView? = null
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDoneScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        heartIcon = binding.heartIcon
        generatedText = binding.tvDone

        sharedPreferences = getSharedPreferences("SavedTexts", Context.MODE_PRIVATE)


        val receivedText = intent.getStringExtra("textDataKey")

        if (receivedText != null) {
            // Do something with the received text data
            binding.tvDone.text = receivedText
        }

        binding.cvCopy.setOnClickListener {
            if (receivedText != null) {
                saveToClipboard(receivedText)
            }
        }

        binding.cvShare.setOnClickListener {
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain"
            sharingIntent.putExtra(Intent.EXTRA_TEXT, receivedText)
            //sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject)
            startActivity(Intent.createChooser(sharingIntent, "Share using"))
        }

        heartIcon!!.setOnClickListener {
            toggleHeartIconState()
        }
        if (isGeneratedTextSaved()) {
            // There is saved text, so set the heart icon as red
            heartIcon!!.setImageResource(R.drawable.ic_heart_red)
        } else {
            // No saved text, so set the heart icon as uncolored
            heartIcon!!.setImageResource(R.drawable.ic_heart_uncolored)
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


    private fun toggleHeartIconState() {
        if (isHeartRed()) {
            // If the heart is red, turn it uncolored and remove saved text
            heartIcon?.setImageResource(R.drawable.ic_heart_uncolored)
            removeSavedText()
        } else {
            // If the heart is uncolored, turn it red and save text
            heartIcon?.setImageResource(R.drawable.ic_heart_red)
            saveTextToSharedPreferences()
        }
    }

    private fun isHeartRed(): Boolean {
        // Check if the heart icon is currently displaying the red icon
        return heartIcon?.drawable?.constantState ==
                resources.getDrawable(R.drawable.ic_heart_red).constantState
    }

    private fun saveTextToSharedPreferences() {
        val textToSave = generatedText?.text.toString() // Replace with your text
        val editor = sharedPreferences.edit()
        editor.putString("savedTextKey", textToSave)
        editor.apply()
        Toast.makeText(this,"saved",Toast.LENGTH_SHORT).show()
    }

    private fun removeSavedText() {
        val editor = sharedPreferences.edit()
        editor.remove("savedTextKey")
        editor.apply()
        Toast.makeText(this,"removed",Toast.LENGTH_SHORT).show()

    }

    private fun isGeneratedTextSaved(): Boolean {
        // Check if the generatedText is already saved in SharedPreferences
        val textToSave = generatedText?.text.toString()
        val savedText = sharedPreferences.getString("savedTextKey", "")
        return savedText == textToSave
    }
}