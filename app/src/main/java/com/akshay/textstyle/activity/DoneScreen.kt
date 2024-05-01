package com.akshay.textstyle.activity

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.akshay.textstyle.R
import com.akshay.textstyle.databinding.ActivityDoneScreenBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DoneScreen : AppCompatActivity() {

    private var heartIcon: ImageView? = null
    private var generatedText:TextView? = null
    private lateinit var sharedPreferences: SharedPreferences
    private var savedArray :ArrayList<String>?=ArrayList()
    private var isRed :Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDoneScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        heartIcon = binding.heartIcon
        generatedText = binding.tvDone

        sharedPreferences = getSharedPreferences("YourSharedPreferencesName", Context.MODE_PRIVATE)

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
            if (generatedText?.text?.trim().toString().isNotEmpty()){
                toggleHeartIconState()
            }else{
                Toast.makeText(this,"text is empty",Toast.LENGTH_SHORT).show()
            }
        }
        if (isGeneratedTextSaved()) {
            Log.e("SAVEDARRAYTEXT222222", "red")
            // There is saved text, so set the heart icon as red
            heartIcon!!.setImageResource(R.drawable.ic_heart_red)
        } else {
            Log.e("SAVEDARRAYTEXT222222", "not red")
            // No saved text, so set the heart icon as uncolored
            heartIcon!!.setImageResource(R.drawable.ic_heart_uncolored)
        }
    }

    fun setSaveLists(list:ArrayList<String>){
        val sharedPreferences = getSharedPreferences("YourSharedPreferencesName", Context.MODE_PRIVATE)
        var editor = sharedPreferences.edit()
        val gson = Gson()
        val json = gson.toJson(list)//converting list to Json
        editor.putString("LIST",json)
        editor.commit()
    }

    private fun getSavedList():ArrayList<String>{
        val gson = Gson()
        val sharedPreferences = getSharedPreferences("YourSharedPreferencesName", Context.MODE_PRIVATE)
        val json = sharedPreferences.getString("LIST",null)
        if(json != null){
            val type = object : TypeToken<ArrayList<String>>(){}.type//converting the json to list
            return gson.fromJson(json,type)//returning the list
        }
        return ArrayList()
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
        if (isRed) {

            // If the heart is red, turn it uncolored and remove saved text
            heartIcon?.setImageResource(R.drawable.ic_heart_uncolored)
            isRed = false
            //removeSavedText()
            val textToSave = generatedText?.text.toString()
            savedArray = getSavedList()
            if(savedArray!!.isNotEmpty() ||savedArray!!.contains(textToSave)){
                savedArray?.remove(textToSave)
                setSaveLists(savedArray!!)
                Log.e("SAVEDARRAYTEXT111111", getSavedList().toString())
            }
        } else {

            // If the heart is uncolored, turn it red and save text
            heartIcon?.setImageResource(R.drawable.ic_heart_red)
            isRed = true
           // saveTextToSharedPreferences()
            val textToSave = generatedText?.text.toString()
                savedArray=getSavedList()
                savedArray?.add(textToSave)
                setSaveLists(savedArray!!)

                Log.e("SAVEDARRAYTEXT222222", getSavedList().toString())
            }
    }

/*    private fun saveTextToSharedPreferences() {
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

    }*/

    private fun isGeneratedTextSaved(): Boolean {
        // Check if the generatedText is already saved in SharedPreferences
        val textToSave = generatedText?.text.toString()
        Log.e("SAVEDARRAYTEXT222222", "${sharedPreferences.getString("LIST", "")}")

        val savedText = sharedPreferences.getString("LIST", "")
        return savedText!!.contains(textToSave)
    }
}