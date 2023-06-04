package com.akshay.textstyle.activity

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.akshay.textstyle.R

class TextRepeater : AppCompatActivity() {

    private lateinit var checkbox1: CheckBox
    private lateinit var checkbox2: CheckBox
    private lateinit var checkbox3: CheckBox
    private lateinit var btnGenerate:ImageButton
    private lateinit var btnReset:ImageButton
    private lateinit var editTextMain:EditText
    private lateinit var editTextRepeater:EditText
    private lateinit var mainText:TextView
    private lateinit var mainClearBtn:ImageButton
    private lateinit var repeaterClrBtn:ImageButton
    private lateinit var copyBtn:Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_repater)

        checkbox1 = findViewById(R.id.checkbox1)
        checkbox2 = findViewById(R.id.checkbox2)
        checkbox3 = findViewById(R.id.checkbox3)
        btnGenerate = findViewById(R.id.generate_btn)
        btnReset = findViewById(R.id.reset_btn)
        editTextMain = findViewById(R.id.editText_main)
        editTextRepeater = findViewById(R.id.editText_repetition)
        mainText = findViewById(R.id.main_text_repeater)
        mainClearBtn =findViewById(R.id.main_clear)
        repeaterClrBtn =findViewById(R.id.repeat_clear)
        copyBtn =findViewById(R.id.repeater_copy)


        checkbox1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                checkbox2.isChecked = false
                checkbox3.isChecked = false
            }
        }

        checkbox2.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                checkbox1.isChecked = false
                checkbox3.isChecked = false
            }
        }

        checkbox3.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                checkbox1.isChecked = false
                checkbox2.isChecked = false
            }
        }
        btnGenerate.setOnClickListener {

            val text = editTextMain.text.toString()
            val noOfRepetitiation = editTextRepeater.text.toString().toInt()
            if(text.isEmpty()){
                Toast.makeText(this@TextRepeater,
                    "Enter the text",Toast.LENGTH_SHORT).show()
            }else if(editTextRepeater.text.isEmpty()) {
                Toast.makeText(this@TextRepeater,
                    "Enter the number of Repetition",Toast.LENGTH_SHORT).show()
            }else{
                val repeatedText = generateText(text, noOfRepetitiation)
                mainText.text = repeatedText
            }
        }
        mainClearBtn.setOnClickListener {
            editTextMain.setText("")
        }
        repeaterClrBtn.setOnClickListener {
            editTextRepeater.setText("")
        }

        btnReset.setOnClickListener {
            editTextMain.setText("")
            editTextRepeater.setText("")
            mainText.text = ""
        }

        copyBtn.setOnClickListener{
            val repeaterText = mainText.text.toString()
            saveToClipboard(repeaterText)
        }
    }

    private fun saveToClipboard(desStr:String){
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("simple text", desStr)
        clipboard.setPrimaryClip(clip)

        Toast.makeText(this,
            "$desStr Copied to clipboard!",
            Toast.LENGTH_SHORT).show()
    }

    private fun generateText(text:String,times: Int):String{
        var result=""
        result = if(checkbox1.isChecked){
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