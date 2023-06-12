package com.akshay.textstyle.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.akshay.textstyle.R
import com.akshay.textstyle.model.Font

class FontAdapter(private val fontItems: ArrayList<Font>, private val activity: Activity): RecyclerView.Adapter<FontAdapter.MyViewHolder>() {

    var textview = activity.findViewById<TextView>(R.id.main_text)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val row: View = LayoutInflater.from(activity).inflate(R.layout.adapter_font, parent, false)
        return MyViewHolder(row)
    }

    @SuppressLint("NewApi")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val f: Font = fontItems[position]
        val strBld: StringBuilder = StringBuilder(f.getPreviewText())
        when (position) {
            0->{
                holder.description.typeface = Typeface.DEFAULT
            }
            1 -> {
                var charOne = 0
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getSpecialCharFirst(a)
                    strBld.setCharAt(charOne, newCh)
                    charOne++
                }
            }
            2 -> {
                var charOne = 0
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getSpecialCharSecond(a)
                    strBld.setCharAt(charOne, newCh)
                    charOne++
                }
            }
            3 -> {
                var charOne = 0
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getSpecialCharThird(a)
                    strBld.setCharAt(charOne, newCh)
                    charOne++
                }
            }
            4 -> {
                var charOne = 0
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getSpecialCharFourth(a)
                    strBld.setCharAt(charOne, newCh)
                    charOne++
                }
            }
            5 -> {
                var charOne = 0
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getSpecialCharFifth(a)
                    strBld.setCharAt(charOne, newCh)
                    charOne++
                }
            }
            6 -> {
                var charOne = 0
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getSpecialCharSixth(a)
                    strBld.setCharAt(charOne, newCh)
                    charOne++
                }
            }
            7 -> {
                var charOne = 0
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getSpecialCharSeventh(a)
                    strBld.setCharAt(charOne, newCh)
                    charOne++
                }
            }
            8 -> if ("Preview text" == f.getPreviewText()) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '♥')
                    }
                    charOne++
                }
            } else if (!f.getPreviewText().contains("♥")) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '♥')
                    }
                    charOne++
                }
            }
            9 -> if ("Preview text" == f.getPreviewText()) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (charOne == 0) {
                        strBld.insert(charOne, '【')
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '】')
                        strBld.insert(++charOne, '【')
                    }
                    if (strBld[charOne] == ' ') {
                        strBld.deleteCharAt(--charOne)
                        strBld.insert(++charOne, '【')
                    }
                    if (strBld.length - 1 == charOne) {
                        strBld.deleteCharAt(charOne)
                    }
                    charOne++
                }
            } else if (!f.getPreviewText().contains("【") && !f.getPreviewText().contains("】")) {
                var charOne = 0
                while (charOne <= strBld.length - 1) {
                    if (charOne == 0) {
                        strBld.insert(charOne, '【')
                        ++charOne
                    }
                    if (strBld.length - 1 != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '】')
                        strBld.insert(++charOne, '【')
                    } else if (strBld.length - 1 == charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '】')
                    }
                    if (strBld[charOne] == ' ' && charOne != 0) {
                        strBld.deleteCharAt(--charOne)
                        strBld.insert(++charOne, '【')
                    } else if (strBld.length - 1 == charOne && strBld[charOne] == ' ' && charOne != 0) {
                        strBld.deleteCharAt(++charOne)
                    }
                    charOne++
                }
            }
            10 -> if ("Preview text" == f.getPreviewText()) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '☆')
                    }
                    charOne++
                }
            } else if (!f.getPreviewText().contains("☆")) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '☆')
                    }
                    charOne++
                }
            }
            11 -> if ("Preview text" == f.getPreviewText()) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '❦')
                    }
                    charOne++
                }
            } else if (!f.getPreviewText().contains("❦")) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '❦')
                    }
                    charOne++
                }
            }
            12 -> if ("Preview text" == f.getPreviewText()) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '❄')
                    }
                    charOne++
                }
            } else if (!f.getPreviewText().contains("❄")) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '❄')
                    }
                    charOne++
                }
            }
            13 -> if ("Preview text" == f.getPreviewText()) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '✾')
                    }
                    charOne++
                }
            } else if (!f.getPreviewText().contains("✾")) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '✾')
                    }
                    charOne++
                }
            }
            14 -> if ("Preview text" == f.getPreviewText()) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '☀')
                    }
                    charOne++
                }
            } else if (!f.getPreviewText().contains("☀")) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '☀')
                    }
                    charOne++
                }
            }
            15 -> if ("Preview text" == f.getPreviewText()) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '☃')
                    }
                    charOne++
                }
            } else if (!f.getPreviewText().contains("☃")) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '☃')
                    }
                    charOne++
                }
            }
            16 -> if ("Preview text" == f.getPreviewText()) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '❤')
                    }
                    charOne++
                }
            } else if (!f.getPreviewText().contains("❤")) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '❤')
                    }
                    charOne++
                }
            }
            17 -> if ("Preview text" == f.getPreviewText()) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '☘')
                    }
                    charOne++
                }
            } else if (!f.getPreviewText().contains("☘")) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '☘')
                    }
                    charOne++
                }
            }
            18 -> if ("Preview text" == f.getPreviewText()) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '☕')
                    }
                    charOne++
                }
            } else if (!f.getPreviewText().contains("☕")) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '☕')
                    }
                    charOne++
                }
            }
            19 -> if ("Preview text" == f.getPreviewText()) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '☝')
                    }
                    charOne++
                }
            } else if (!f.getPreviewText().contains("☝")) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '☝')
                    }
                    charOne++
                }
            }
            20 -> if ("Preview text" == f.getPreviewText()) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '❁')
                    }
                    charOne++
                }
            } else if (!f.getPreviewText().contains("❁")) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '❁')
                    }
                    charOne++
                }
            }
            21 -> if ("Preview text" == f.getPreviewText()) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '♈')
                    }
                    charOne++
                }
            } else if (!f.getPreviewText().contains("♈")) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '♈')
                    }
                    charOne++
                }
            }
            22 -> if ("Preview text" == f.getPreviewText()) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '♉')
                    }
                    charOne++
                }
            } else if (!f.getPreviewText().contains("♉")) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '♉')
                    }
                    charOne++
                }
            }
            23 -> if ("Preview text" == f.getPreviewText()) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '♊')
                    }
                    charOne++
                }
            } else if (!f.getPreviewText().contains("♊")) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '♊')
                    }
                    charOne++
                }
            }
            24 -> if ("Preview text" == f.getPreviewText()) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '♋')
                    }
                    charOne++
                }
            } else if (!f.getPreviewText().contains("♋")) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '♋')
                    }
                    charOne++
                }
            }
            25 -> if ("Preview text" == f.getPreviewText()) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '♌')
                    }
                    charOne++
                }
            } else if (!f.getPreviewText().contains("♌")) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '♌')
                    }
                    charOne++
                }
            }
            26 -> if ("Preview text" == f.getPreviewText()) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '♍')
                    }
                    charOne++
                }
            } else if (!f.getPreviewText().contains("♍")) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '♍')
                    }
                    charOne++
                }
            }
            27 -> if ("Preview text" == f.getPreviewText()) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '♎')
                    }
                    charOne++
                }
            } else if (!f.getPreviewText().contains("♎")) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '♎')
                    }
                    charOne++
                }
            }
            28 -> if ("Preview text" == f.getPreviewText()) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '♏')
                    }
                    charOne++
                }
            } else if (!f.getPreviewText().contains("♏")) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '♏')
                    }
                    charOne++
                }
            }
            29 -> if ("Preview text" == f.getPreviewText()) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '♐')
                    }
                    charOne++
                }
            } else if (!f.getPreviewText().contains("♐")) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '♐')
                    }
                    charOne++
                }
            }
            30 -> if ("Preview text" == f.getPreviewText()) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '♑')
                    }
                    charOne++
                }
            } else if (!f.getPreviewText().contains("♑")) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '♑')
                    }
                    charOne++
                }
            }
            31 -> if ("Preview text" == f.getPreviewText()) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '♒')
                    }
                    charOne++
                }
            } else if (!f.getPreviewText().contains("♒")) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '♒')
                    }
                    charOne++
                }
            }
            32 -> if ("Preview text" == f.getPreviewText()) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '♓')
                    }
                    charOne++
                }
            } else if (!f.getPreviewText().contains("♓")) {
                var charOne = 0
                while (charOne < strBld.length) {
                    if (strBld[charOne] == ' ' && strBld.length - 1 != charOne) {
                        ++charOne
                    }
                    if (strBld.length != charOne && strBld[charOne] != ' ') {
                        strBld.insert(++charOne, '♓')
                    }
                    charOne++
                }
            }
        }


        f.setPreviewText(strBld.toString())
        holder.description.text = f.getPreviewText()
        holder.cardView.setOnClickListener{
            val desStr = holder.description.text.toString()
            val mainText = activity.findViewById<TextView>(R.id.main_text)

            //displaying modified string in textView
            mainText.text = desStr


        }
    }


    private fun getSpecialCharFirst(a: Char): Char {
        var ch = a
        when (ch) {
            'A' -> {
                ch = 'Ⓐ'
            }
            'B' -> {
                ch = 'Ⓑ'
            }
            'C' -> {
                ch = 'Ⓒ'
            }
            'D' -> {
                ch = 'Ⓓ'
            }
            'E' -> {
                ch = 'Ⓔ'
            }
            'F' -> {
                ch = 'Ⓕ'
            }
            'G' -> {
                ch = 'Ⓖ'
            }
            'H' -> {
                ch = 'Ⓗ'
            }
            'I' -> {
                ch = 'Ⓘ'
            }
            'J' -> {
                ch = 'Ⓙ'
            }
            'K' -> {
                ch = 'Ⓚ'
            }
            'L' -> {
                ch = 'Ⓛ'
            }
            'M' -> {
                ch = 'Ⓜ'
            }
            'N' -> {
                ch = 'Ⓝ'
            }
            'O' -> {
                ch = 'Ⓞ'
            }
            'P' -> {
                ch = 'Ⓟ'
            }
            'Q' -> {
                ch = 'Ⓠ'
            }
            'R' -> {
                ch = 'Ⓡ'
            }
            'S' -> {
                ch = 'Ⓢ'
            }
            'T' -> {
                ch = 'Ⓣ'
            }
            'U' -> {
                ch = 'Ⓤ'
            }
            'V' -> {
                ch = 'Ⓥ'
            }
            'W' -> {
                ch = 'Ⓦ'
            }
            'X' -> {
                ch = 'Ⓧ'
            }
            'Y' -> {
                ch = 'Ⓨ'
            }
            'Z' -> {
                ch = 'Ⓩ'
            }
            'a' -> {
                ch = 'ⓐ'
            }
            'b' -> {
                ch = 'ⓑ'
            }
            'c' -> {
                ch = 'ⓒ'
            }
            'd' -> {
                ch = 'ⓓ'
            }
            'e' -> {
                ch = 'ⓔ'
            }
            'f' -> {
                ch = 'ⓕ'
            }
            'g' -> {
                ch = 'ⓖ'
            }
            'h' -> {
                ch = 'ⓗ'
            }
            'i' -> {
                ch = 'ⓘ'
            }
            'j' -> {
                ch = 'ⓙ'
            }
            'k' -> {
                ch = 'ⓚ'
            }
            'l' -> {
                ch = 'ⓛ'
            }
            'm' -> {
                ch = 'ⓜ'
            }
            'n' -> {
                ch = 'ⓝ'
            }
            'o' -> {
                ch = 'ⓞ'
            }
            'p' -> {
                ch = 'ⓟ'
            }
            'q' -> {
                ch = 'ⓠ'
            }
            'r' -> {
                ch = 'ⓡ'
            }
            's' -> {
                ch = 'ⓢ'
            }
            't' -> {
                ch = 'ⓣ'
            }
            'u' -> {
                ch = 'ⓤ'
            }
            'v' -> {
                ch = 'ⓥ'
            }
            'w' -> {
                ch = 'ⓦ'
            }
            'x' -> {
                ch = 'ⓧ'
            }
            'y' -> {
                ch = 'ⓨ'
            }
            'z' -> {
                ch = 'ⓩ'
            }
            '0' -> {
                ch = '⓪'
            }
            '1' -> {
                ch = '①'
            }
            '2' -> {
                ch = '②'
            }
            '3' -> {
                ch = '③'
            }
            '4' -> {
                ch = '④'
            }
            '5' -> {
                ch = '⑤'
            }
            '6' -> {
                ch = '⑥'
            }
            '7' -> {
                ch = '⑦'
            }
            '8' -> {
                ch = '⑧'
            }
            '9' -> {
                ch = '⑨'
            }
        }
        return ch
    }

    private fun getSpecialCharSecond(a: Char): Char {
        var ch = a
        when (ch) {
            'A' -> {
                ch = '₳'
            }
            'B' -> {
                ch = '฿'
            }
            'C' -> {
                ch = '₵'
            }
            'D' -> {
                ch = 'Đ'
            }
            'E' -> {
                ch = 'Ɇ'
            }
            'F' -> {
                ch = '₣'
            }
            'G' -> {
                ch = '₲'
            }
            'H' -> {
                ch = 'Ⱨ'
            }
            'I' -> {
                ch = 'ł'
            }
            'K' -> {
                ch = '₭'
            }
            'L' -> {
                ch = 'Ⱡ'
            }
            'M' -> {
                ch = '₥'
            }
            'N' -> {
                ch = '₦'
            }
            'O' -> {
                ch = 'Ø'
            }
            'P' -> {
                ch = '₱'
            }
            'R' -> {
                ch = 'Ɽ'
            }
            'S' -> {
                ch = '₴'
            }
            'T' -> {
                ch = '₮'
            }
            'U' -> {
                ch = 'Ʉ'
            }
            'W' -> {
                ch = '₩'
            }
            'X' -> {
                ch = 'Ӿ'
            }
            'Y' -> {
                ch = 'Ɏ'
            }
            'Z' -> {
                ch = 'Ⱬ'
            }
            'a' -> {
                ch = '₳'
            }
            'b' -> {
                ch = '฿'
            }
            'c' -> {
                ch = '₵'
            }
            'd' -> {
                ch = 'Đ'
            }
            'e' -> {
                ch = 'Ɇ'
            }
            'f' -> {
                ch = '₣'
            }
            'g' -> {
                ch = '₲'
            }
            'h' -> {
                ch = 'Ⱨ'
            }
            'i' -> {
                ch = 'ł'
            }
            'j' -> {
                ch = 'J'
            }
            'k' -> {
                ch = '₭'
            }
            'l' -> {
                ch = 'Ⱡ'
            }
            'm' -> {
                ch = '₥'
            }
            'n' -> {
                ch = '₦'
            }
            'o' -> {
                ch = 'Ø'
            }
            'p' -> {
                ch = '₱'
            }
            'q' -> {
                ch = 'Q'
            }
            'r' -> {
                ch = 'Ɽ'
            }
            's' -> {
                ch = '₴'
            }
            't' -> {
                ch = '₮'
            }
            'u' -> {
                ch = 'Ʉ'
            }
            'v' -> {
                ch = 'V'
            }
            'w' -> {
                ch = '₩'
            }
            'x' -> {
                ch = 'Ӿ'
            }
            'y' -> {
                ch = 'Ɏ'
            }
            'z' -> {
                ch = 'Ⱬ'
            }
        }
        return ch
    }

    private fun getSpecialCharThird(a: Char): Char {
        var ch = a
        when (ch) {
            'A', 'a' -> {
                ch = 'Ꭺ'
            }
            'B', 'b' -> {
                ch = 'b'
            }
            'C', 'c' -> {
                ch = 'Ꮯ'
            }
            'D', 'd' -> {
                ch = 'Ꭰ'
            }
            'E', 'e' -> {
                ch = 'Ꭼ'
            }
            'F', 'f' -> {
                ch = 'f'
            }
            'G', 'g' -> {
                ch = 'Ꮆ'
            }
            'H', 'h' -> {
                ch = 'h'
            }
            'I', 'i' -> {
                ch = 'Ꭵ'
            }
            'J', 'j' -> {
                ch = 'j'
            }
            'K', 'k' -> {
                ch = 'Ꮶ'
            }
            'L', 'l' -> {
                ch = 'Ꮮ'
            }
            'M', 'm' -> {
                ch = 'm'
            }
            'N', 'n' -> {
                ch = 'Ꮑ'
            }
            'O', 'o' -> {
                ch = 'Ꮎ'
            }
            'P', 'p' -> {
                ch = 'Ꮲ'
            }
            'Q', 'q' -> {
                ch = 'q'
            }
            'R', 'r' -> {
                ch = 'Ꮢ'
            }
            'S', 's' -> {
                ch = 's'
            }
            'T', 't' -> {
                ch = 'Ꮖ'
            }
            'U', 'u' -> {
                ch = 'u'
            }
            'V', 'v' -> {
                ch = 'Ꮙ'
            }
            'W', 'w' -> {
                ch = 'Ꮃ'
            }
            'X', 'x' -> {
                ch = 'x'
            }
            'Y', 'y' -> {
                ch = 'Ꮍ'
            }
            'Z', 'z' -> {
                ch = 'Ꮓ'
            }
        }
        return ch
    }

    private fun getSpecialCharFourth(a: Char): Char {
        var ch = a
        when (ch) {
            'A' -> {
                ch = 'Ḁ'
            }
            'B' -> {
                ch = 'Ḃ'
            }
            'C' -> {
                ch = 'Ḉ'
            }
            'D' -> {
                ch = 'Ḋ'
            }
            'E' -> {
                ch = 'Ḕ'
            }
            'F' -> {
                ch = 'Ḟ'
            }
            'G' -> {
                ch = 'Ḡ'
            }
            'H' -> {
                ch = 'Ḧ'
            }
            'I' -> {
                ch = 'Ḭ'
            }
            'K' -> {
                ch = 'Ḳ'
            }
            'L' -> {
                ch = 'Ḷ'
            }
            'M' -> {
                ch = 'Ṁ'
            }
            'N' -> {
                ch = 'Ṇ'
            }
            'O' -> {
                ch = 'Ṏ'
            }
            'P' -> {
                ch = 'Ṗ'
            }
            'R' -> {
                ch = 'Ṙ'
            }
            'S' -> {
                ch = 'Ṡ'
            }
            'T' -> {
                ch = 'Ṯ'
            }
            'U' -> {
                ch = 'Ṳ'
            }
            'V' -> {
                ch = 'Ṽ'
            }
            'W' -> {
                ch = 'Ẇ'
            }
            'X' -> {
                ch = 'Ẍ'
            }
            'Y' -> {
                ch = 'Ẏ'
            }
            'Z' -> {
                ch = 'Ẓ'
            }
            'a' -> {
                ch = 'Ḁ'
            }
            'b' -> {
                ch = 'ḃ'
            }
            'c' -> {
                ch = 'ḉ'
            }
            'd' -> {
                ch = 'Ḋ'
            }
            'e' -> {
                ch = 'ḕ'
            }
            'f' -> {
                ch = 'ḟ'
            }
            'g' -> {
                ch = 'Ḡ'
            }
            'h' -> {
                ch = 'ḧ'
            }
            'i' -> {
                ch = 'ḭ'
            }
            'k' -> {
                ch = 'Ḳ'
            }
            'l' -> {
                ch = 'Ḷ'
            }
            'm' -> {
                ch = 'ṁ'
            }
            'n' -> {
                ch = 'Ṇ'
            }
            'o' -> {
                ch = 'ṏ'
            }
            'p' -> {
                ch = 'Ṗ'
            }
            'r' -> {
                ch = 'ṙ'
            }
            's' -> {
                ch = 'Ṡ'
            }
            't' -> {
                ch = 'Ṯ'
            }
            'u' -> {
                ch = 'ṳ'
            }
            'v' -> {
                ch = 'Ṽ'
            }
            'w' -> {
                ch = 'ẇ'
            }
            'x' -> {
                ch = 'Ẍ'
            }
            'y' -> {
                ch = 'ẏ'
            }
            'z' -> {
                ch = 'Ẓ'
            }
        }
        return ch
    }

    private fun getSpecialCharFifth(a: Char): Char {
        var ch = a
        when (ch) {
            'A', 'a' -> {
                ch = 'α'
            }
            'B', 'b' -> {
                ch = 'в'
            }
            'C', 'c' -> {
                ch = '¢'
            }
            'D', 'd' -> {
                ch = '∂'
            }
            'E', 'e' -> {
                ch = 'є'
            }
            'F', 'f' -> {
                ch = 'f'
            }
            'G', 'g' -> {
                ch = 'g'
            }
            'H', 'h' -> {
                ch = 'н'
            }
            'I', 'i' -> {
                ch = 'ι'
            }
            'J', 'j' -> {
                ch = 'נ'
            }
            'K', 'k' -> {
                ch = 'к'
            }
            'L', 'l' -> {
                ch = 'ℓ'
            }
            'M', 'm' -> {
                ch = 'м'
            }
            'N', 'n' -> {
                ch = 'и'
            }
            'O', 'o' -> {
                ch = 'σ'
            }
            'P', 'p' -> {
                ch = 'ρ'
            }
            'Q', 'q' -> {
                ch = 'q'
            }
            'R', 'r' -> {
                ch = 'я'
            }
            'S', 's' -> {
                ch = 's'
            }
            'T', 't' -> {
                ch = 'т'
            }
            'U', 'u' -> {
                ch = 'υ'
            }
            'V', 'v' -> {
                ch = 'ν'
            }
            'W', 'w' -> {
                ch = 'ω'
            }
            'X', 'x' -> {
                ch = 'χ'
            }
            'Y', 'y' -> {
                ch = 'у'
            }
            'Z', 'z' -> {
                ch = 'z'
            }
        }
        return ch
    }

    private fun getSpecialCharSixth(a: Char): Char {
        var ch = a
        when (ch) {
            'A', 'a' -> {
                ch = 'Ã'
            }
            'B', 'b' -> {
                ch = 'β'
            }
            'C', 'c' -> {
                ch = 'Č'
            }
            'D', 'd' -> {
                ch = 'Ď'
            }
            'E', 'e' -> {
                ch = 'Ẹ'
            }
            'F', 'f' -> {
                ch = 'Ƒ'
            }
            'G', 'g' -> {
                ch = 'Ğ'
            }
            'H', 'h' -> {
                ch = 'Ĥ'
            }
            'I', 'i' -> {
                ch = 'Į'
            }
            'J', 'j' -> {
                ch = 'Ĵ'
            }
            'K', 'k' -> {
                ch = 'Ќ'
            }
            'L', 'l' -> {
                ch = 'Ĺ'
            }
            'M', 'm' -> {
                ch = 'ϻ'
            }
            'N', 'n' -> {
                ch = 'Ň'
            }
            'O', 'o' -> {
                ch = 'Ỗ'
            }
            'P', 'p' -> {
                ch = 'Ƥ'
            }
            'Q', 'q' -> {
                ch = 'Ǫ'
            }
            'R', 'r' -> {
                ch = 'Ř'
            }
            'S', 's' -> {
                ch = 'Ŝ'
            }
            'T', 't' -> {
                ch = 'Ť'
            }
            'U', 'u' -> {
                ch = 'Ǘ'
            }
            'V', 'v' -> {
                ch = 'ϋ'
            }
            'W', 'w' -> {
                ch = 'Ŵ'
            }
            'X', 'x' -> {
                ch = 'Ж'
            }
            'Y', 'y' -> {
                ch = 'Ў'
            }
            'Z', 'z' -> {
                ch = 'Ż'
            }
        }
        return ch
    }

    private fun getSpecialCharSeventh(a: Char): Char {
        var ch = a
        when (ch) {
            'A', 'a' -> {
                ch = 'A'
            }
            'B', 'b' -> {
                ch = 'Ɓ'
            }
            'C', 'c' -> {
                ch = 'Ƈ'
            }
            'D', 'd' -> {
                ch = 'Ɗ'
            }
            'E', 'e' -> {
                ch = 'Є'
            }
            'F', 'f' -> {
                ch = 'Ƒ'
            }
            'G', 'g' -> {
                ch = 'Ɠ'
            }
            'H', 'h' -> {
                ch = 'Ӈ'
            }
            'I', 'i' -> {
                ch = 'Ɩ'
            }
            'J', 'j' -> {
                ch = 'ʆ'
            }
            'K', 'k' -> {
                ch = 'Ƙ'
            }
            'L', 'l' -> {
                ch = 'Լ'
            }
            'M', 'm' -> {
                ch = 'M'
            }
            'N', 'n' -> {
                ch = 'Ɲ'
            }
            'O', 'o' -> {
                ch = 'Ơ'
            }
            'P', 'p' -> {
                ch = 'Ƥ'
            }
            'Q', 'q' -> {
                ch = 'Ƣ'
            }
            'R', 'r' -> {
                ch = 'Ʀ'
            }
            'S', 's' -> {
                ch = 'Ƨ'
            }
            'T', 't' -> {
                ch = 'Ƭ'
            }
            'U', 'u' -> {
                ch = 'Ʋ'
            }
            'V', 'v' -> {
                ch = 'Ɣ'
            }
            'W', 'w' -> {
                ch = 'Ɯ'
            }
            'X', 'x' -> {
                ch = 'Ҳ'
            }
            'Y', 'y' -> {
                ch = 'Ƴ'
            }
            'Z', 'z' -> {
                ch = 'Ȥ'
            }
        }
        return ch
    }


    override
    fun getItemCount(): Int {
        return fontItems.size
    }

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        //val title: TextView = itemView.findViewById(R.id.titleTV)
        val description: TextView = itemView.findViewById(R.id.descriptionTV)
        val cardView: CardView = itemView.findViewById(R.id.card_view)
    }
}
