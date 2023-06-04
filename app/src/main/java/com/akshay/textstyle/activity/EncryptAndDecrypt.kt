package com.akshay.textstyle.activity

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.akshay.textstyle.R


class EncryptAndDecrypt : AppCompatActivity() {

    private var editTextMain :EditText?=null
    private var mainText:TextView?=null
    private var btnCopy :Button?=null
    private var btnClear :ImageButton?=null
    private var encryptBtn:ImageButton?=null
    private var decryptBtn:ImageButton?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_encrypt_and_decrypt)

        editTextMain = findViewById(R.id.edit_text_sizeColor_main)
        mainText = findViewById(R.id.main_text_sizeColor)
        btnCopy = findViewById(R.id.btn_copy)
        btnClear = findViewById(R.id.ib_clear)

        encryptBtn = findViewById(R.id.encrypt_btn)
        decryptBtn = findViewById(R.id.decrypt_btn)

        encryptBtn?.setOnClickListener {
            val string = with(editTextMain){this?.text.toString()}
            val encryptString = encrypt(string)
            with(mainText){this?.text= encryptString}
        }

        decryptBtn?.setOnClickListener {
            val string = with(editTextMain){this?.text.toString()}
            val decryptString = decrypt(string)
            with(mainText){this?.text= decryptString}
        }

        btnClear?.setOnClickListener {
            with(editTextMain) { this?.setText("") }
        }

        btnCopy?.setOnClickListener {
            val mainTextString = with(mainText){this?.text.toString()}
            saveToClipboard(mainTextString)
        }
    }

    fun encrypt(str :String) :String {
        var encript:String = ""

        for (i  in str) {
            if (i.isUpperCase()&& i.isLetter()) {
                encript += ((i + 3 -65).toInt() % 26+65).toChar()
            }
            else if(i.isLowerCase() && i.isLetter()){
                encript += ((i + 3-97).toInt() % 26+97).toChar()
            }
            else{
                encript += i
            }
        }
        return encript
    }
    private fun saveToClipboard(string:String){
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("simple text", string)
        clipboard.setPrimaryClip(clip)

        Toast.makeText(this,
            "$string Copied to clipboard!",
            Toast.LENGTH_SHORT).show()
    }

    fun decrypt(str :String) :String {
        var encript:String = ""

        for (i  in str) {
            if (i.isUpperCase()&& i.isLetter()) {
                encript += ((i +(26-3) -65).toInt() % 26+65).toChar()
            }
            else if(i.isLowerCase() && i.isLetter()){
                encript += ((i + (26-3)-97).toInt() % 26+97).toChar()
            }
            else{
                encript += i
            }
        }
        return encript
    }
}