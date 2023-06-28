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

class FontAdapter(private val fontItems: ArrayList<Font>, private val activity: Activity) :
    RecyclerView.Adapter<FontAdapter.MyViewHolder>() {

    var textview: TextView = activity.findViewById(R.id.main_text)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val row: View = LayoutInflater.from(activity).inflate(R.layout.adapter_font, parent, false)
        return MyViewHolder(row)
    }

    @SuppressLint("NewApi")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val f: Font = fontItems[position]
        val strBld: StringBuilder = StringBuilder(f.getPreviewText())
        when (position) {
            0 -> {
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

            8 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getSquareChar(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            9 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getSpecialCharUnderlined(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }

            10 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            11 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar2(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            12 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar3(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            13 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getRoundAlphabetChar(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            14 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getSquareBlockAlphabetChar(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            15 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar4(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            16 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar5(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            17 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar6(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            18 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar7(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            19 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar8(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            20 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar9(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            21 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar10(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            22 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar11(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            23 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar12(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            24 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar13(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            25 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar14(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            26 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar15(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            27 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar16(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            28 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar17(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            29 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar18(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            30 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar19(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            31 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar20(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            32 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar21(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            33 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar22(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            34 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar23(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            35 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar24(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            36 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar25(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            37 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar26(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            38 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar27(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            39 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar28(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            40 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar29(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            41 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar30(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }

            42 -> if ("Preview text" == f.getPreviewText()) {
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
            43 -> if ("Preview text" == f.getPreviewText()) {
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
            44 -> if ("Preview text" == f.getPreviewText()) {
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
            45 -> if ("Preview text" == f.getPreviewText()) {
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
            46 -> if ("Preview text" == f.getPreviewText()) {
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
            47 -> if ("Preview text" == f.getPreviewText()) {
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
            48 -> if ("Preview text" == f.getPreviewText()) {
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
            49 -> if ("Preview text" == f.getPreviewText()) {
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
            50 -> if ("Preview text" == f.getPreviewText()) {
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
            51 -> if ("Preview text" == f.getPreviewText()) {
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
            52 -> if ("Preview text" == f.getPreviewText()) {
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
            53 -> if ("Preview text" == f.getPreviewText()) {
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
            54 -> if ("Preview text" == f.getPreviewText()) {
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
            55 -> if ("Preview text" == f.getPreviewText()) {
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
            56 -> if ("Preview text" == f.getPreviewText()) {
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
            57 -> if ("Preview text" == f.getPreviewText()) {
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
            58 -> if ("Preview text" == f.getPreviewText()) {
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
            59 -> if ("Preview text" == f.getPreviewText()) {
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
            60 -> if ("Preview text" == f.getPreviewText()) {
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
            61 -> if ("Preview text" == f.getPreviewText()) {
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
            62 -> if ("Preview text" == f.getPreviewText()) {
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
            63 -> if ("Preview text" == f.getPreviewText()) {
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
            64 -> if ("Preview text" == f.getPreviewText()) {
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
            65 -> if ("Preview text" == f.getPreviewText()) {
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
            66 -> if ("Preview text" == f.getPreviewText()) {
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
            67 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar31(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            68 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar32(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            69 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar33(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            70 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar34(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            71 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar35(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            72 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar36(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            73 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar37(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            74 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar38(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            75 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar39(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            76 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar40(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            77 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar41(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            78 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar42(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            79 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar43(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            80 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar44(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            81 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar45(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            82 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar46(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            83 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar47(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            84 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar48(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            85 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar49(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            86 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar50(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            87 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar51(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
            88 -> {
                var charOne = 0
                val modifiedStrBld = StringBuilder()
                while (charOne <= strBld.length - 1) {
                    val a = strBld[charOne]
                    val newCh = getFancyAlphabetChar52(a)
                    modifiedStrBld.append(newCh)
                    charOne++
                }
                strBld.clear()
                strBld.append(modifiedStrBld)
            }
        }

        f.setPreviewText(strBld.toString())
        holder.description.text = f.getPreviewText()
        holder.cardView.setOnClickListener {
            val desStr = holder.description.text.toString()
            val mainText = activity.findViewById<TextView>(R.id.main_text)

            //displaying modified string in textView
            mainText.text = desStr
        }
    }
    private fun getFancyAlphabetChar52(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "ค"
            'B' -> "๖"
            'C' -> "¢"
            'D' -> "໓"
            'E' -> "ē"
            'F' -> "f"
            'G' -> "ງ"
            'H' -> "h"
            'I' -> "i"
            'J' -> "ว"
            'K' -> "k"
            'L' -> "l"
            'M' -> "๓"
            'N' -> "ຖ"
            'O' -> "໐"
            'P' -> "p"
            'Q' -> "๑"
            'R' -> "r"
            'S' -> "Ş"
            'T' -> "t"
            'U' -> "น"
            'V' -> "ง"
            'W' -> "ຟ"
            'X' -> "x"
            'Y' -> "ฯ"
            'Z' -> "ຊ"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar51(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "ค"
            'B' -> "𝔟"
            'C' -> "ⓒ"
            'D' -> "𝐝"
            'E' -> "є"
            'F' -> "𝕗"
            'G' -> "Ꮆ"
            'H' -> "𝕙"
            'I' -> "丨"
            'J' -> "𝒿"
            'K' -> "ᛕ"
            'L' -> "𝓛"
            'M' -> "Μ"
            'N' -> "Ⓝ"
            'O' -> "ㄖ"
            'P' -> "ᑭ"
            'Q' -> "𝓺"
            'R' -> "Ř"
            'S' -> "ร"
            'T' -> "ｔ"
            'U' -> "𝕦"
            'V' -> "V"
            'W' -> "𝐖"
            'X' -> "Ж"
            'Y' -> "𝓎"
            'Z' -> "Ƶ"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar50(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "𝒶"
            'B' -> "𝒷"
            'C' -> "𝒸"
            'D' -> "𝒹"
            'E' -> "𝑒"
            'F' -> "𝒻"
            'G' -> "𝑔"
            'H' -> "𝒽"
            'I' -> "𝒾"
            'J' -> "𝒿"
            'K' -> "𝓀"
            'L' -> "𝓁"
            'M' -> "𝓂"
            'N' -> "𝓃"
            'O' -> "🏵"
            'P' -> "𝓅"
            'Q' -> "𝓆"
            'R' -> "𝓇"
            'S' -> "𝓈"
            'T' -> "𝓉"
            'U' -> "𝓊"
            'V' -> "𝓋"
            'W' -> "𝓌"
            'X' -> "𝓍"
            'Y' -> "𝓎"
            'Z' -> "𝓏"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar49(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "ค"
            'B' -> "ც"
            'C' -> "८"
            'D' -> "ძ"
            'E' -> "૯"
            'F' -> "Բ"
            'G' -> "૭"
            'H' -> "Һ"
            'I' -> "ɿ"
            'J' -> "ʆ"
            'K' -> "қ"
            'L' -> "Ն"
            'M' -> "ɱ"
            'N' -> "Ո"
            'O' -> "૦"
            'P' -> "ƿ"
            'Q' -> "ҩ"
            'R' -> "Ր"
            'S' -> "ς"
            'T' -> "੮"
            'U' -> "υ"
            'V' -> "౮"
            'W' -> "ω"
            'X' -> "૪"
            'Y' -> "ע"
            'Z' -> "ઽ"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar48(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "𝕒"
            'B' -> "Ⓑ"
            'C' -> "ᶜ"
            'D' -> "∂"
            'E' -> "𝔢"
            'F' -> "Ƒ"
            'G' -> "𝔤"
            'H' -> "н"
            'I' -> "ι"
            'J' -> "𝓳"
            'K' -> "𝓴"
            'L' -> "ㄥ"
            'M' -> "𝓂"
            'N' -> "ᑎ"
            'O' -> "𝕠"
            'P' -> "ᑭ"
            'Q' -> "𝕢"
            'R' -> "ℝ"
            'S' -> "丂"
            'T' -> "t"
            'U' -> "ᑌ"
            'V' -> "Ѷ"
            'W' -> "ฬ"
            'X' -> "א"
            'Y' -> "𝐲"
            'Z' -> "𝕫"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar47(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "𝒶"
            'B' -> "𝒷"
            'C' -> "ｃ"
            'D' -> "𝔻"
            'E' -> "ｅ"
            'F' -> "𝔽"
            'G' -> "Ꮆ"
            'H' -> "ᕼ"
            'I' -> "丨"
            'J' -> "𝓙"
            'K' -> "Ⓚ"
            'L' -> "𝕝"
            'M' -> "๓"
            'N' -> "𝔫"
            'O' -> "𝔬"
            'P' -> "Ƥ"
            'Q' -> "Ǫ"
            'R' -> "ℝ"
            'S' -> "ѕ"
            'T' -> "t"
            'U' -> "𝐮"
            'V' -> "𝐯"
            'W' -> "𝔴"
            'X' -> "𝔵"
            'Y' -> "𝐲"
            'Z' -> "𝕫"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar46(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "Ａ"
            'B' -> "乃"
            'C' -> "𝓒"
            'D' -> "𝓓"
            'E' -> "є"
            'F' -> "ｆ"
            'G' -> "𝓰"
            'H' -> "н"
            'I' -> "ι"
            'J' -> "ן"
            'K' -> "ｋ"
            'L' -> "𝕝"
            'M' -> "Ｍ"
            'N' -> "ᶰ"
            'O' -> "𝓞"
            'P' -> "Ƥ"
            'Q' -> "Ǫ"
            'R' -> "ʳ"
            'S' -> "Ｓ"
            'T' -> "t"
            'U' -> "𝐔"
            'V' -> "𝓥"
            'W' -> "𝓦"
            'X' -> "𝕏"
            'Y' -> "¥"
            'Z' -> "Ż"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar45(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "ค"
            'B' -> "𝓑"
            'C' -> "ς"
            'D' -> "𝓓"
            'E' -> "𝒆"
            'F' -> "ᶠ"
            'G' -> "ⓖ"
            'H' -> "𝒽"
            'I' -> "ｉ"
            'J' -> "ן"
            'K' -> "Ќ"
            'L' -> "l"
            'M' -> "м"
            'N' -> "𝕟"
            'O' -> "𝐨"
            'P' -> "ᵖ"
            'Q' -> "Ǫ"
            'R' -> "ⓡ"
            'S' -> "𝐒"
            'T' -> "丅"
            'U' -> "ย"
            'V' -> "ש"
            'W' -> "ⓦ"
            'X' -> "𝐗"
            'Y' -> "ү"
            'Z' -> "ᶻ"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar44(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "卂"
            'B' -> "в"
            'C' -> "ς"
            'D' -> "𝔡"
            'E' -> "Ẹ"
            'F' -> "ⓕ"
            'G' -> "Ǥ"
            'H' -> "𝔥"
            'I' -> "𝒾"
            'J' -> "ן"
            'K' -> "𝐤"
            'L' -> "𝕃"
            'M' -> "𝓂"
            'N' -> "Ⓝ"
            'O' -> "𝕆"
            'P' -> "ℙ"
            'Q' -> "q"
            'R' -> "尺"
            'S' -> "ⓢ"
            'T' -> "т"
            'U' -> "𝐮"
            'V' -> "𝓥"
            'W' -> "𝓌"
            'X' -> "ⓧ"
            'Y' -> "у"
            'Z' -> "𝐳"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar43(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "Ａ"
            'B' -> "𝕓"
            'C' -> "ς"
            'D' -> "𝒹"
            'E' -> "ᵉ"
            'F' -> "ℱ"
            'G' -> "𝐆"
            'H' -> "Ⓗ"
            'I' -> "𝕚"
            'J' -> "ј"
            'K' -> "𝓀"
            'L' -> "ℓ"
            'M' -> "𝓂"
            'N' -> "𝓝"
            'O' -> "𝔬"
            'P' -> "Ƥ"
            'Q' -> "Ǫ"
            'R' -> "尺"
            'S' -> "𝓈"
            'T' -> "ｔ"
            'U' -> "𝓊"
            'V' -> "𝐕"
            'W' -> "𝔀"
            'X' -> "Ｘ"
            'Y' -> "Ⓨ"
            'Z' -> "z"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar42(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "ค"
            'B' -> "𝔟"
            'C' -> "℃"
            'D' -> "𝔻"
            'E' -> "Ｅ"
            'F' -> "Ⓕ"
            'G' -> "𝔾"
            'H' -> "ｈ"
            'I' -> "ι"
            'J' -> "ʲ"
            'K' -> "Ｋ"
            'L' -> "Ｌ"
            'M' -> "м"
            'N' -> "Ⓝ"
            'O' -> "ό"
            'P' -> "Ⓟ"
            'Q' -> "ᵠ"
            'R' -> "Ř"
            'S' -> "ร"
            'T' -> "𝔱"
            'U' -> "𝕦"
            'V' -> "𝓋"
            'W' -> "ｗ"
            'X' -> "𝕩"
            'Y' -> "ʸ"
            'Z' -> "ｚ"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar41(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "卂"
            'B' -> "β"
            'C' -> "𝕔"
            'D' -> "𝔻"
            'E' -> "є"
            'F' -> "ｆ"
            'G' -> "𝑔"
            'H' -> "Ħ"
            'I' -> "ｉ"
            'J' -> "ⓙ"
            'K' -> "ᵏ"
            'L' -> "Ⓛ"
            'M' -> "𝓂"
            'N' -> "ℕ"
            'O' -> "𝕆"
            'P' -> "𝐩"
            'Q' -> "ℚ"
            'R' -> "ℝ"
            'S' -> "s"
            'T' -> "ᵗ"
            'U' -> "ᵘ"
            'V' -> "V"
            'W' -> "ฬ"
            'X' -> "χ"
            'Y' -> "ץ"
            'Z' -> "𝕫"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar40(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "ａ"
            'B' -> "๒"
            'C' -> "𝐜"
            'D' -> "๔"
            'E' -> "𝐞"
            'F' -> "Ｆ"
            'G' -> "Ⓖ"
            'H' -> "н"
            'I' -> "ί"
            'J' -> "𝐣"
            'K' -> "Ｋ"
            'L' -> "Ł"
            'M' -> "ｍ"
            'N' -> "ᑎ"
            'O' -> "Ø"
            'P' -> "𝓟"
            'Q' -> "𝓆"
            'R' -> "𝐑"
            'S' -> "ⓢ"
            'T' -> "𝐭"
            'U' -> "Ｕ"
            'V' -> "𝓥"
            'W' -> "𝐰"
            'X' -> "𝔁"
            'Y' -> "𝓨"
            'Z' -> "z"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar39(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "𝕒"
            'B' -> "𝕓"
            'C' -> "匚"
            'D' -> "đ"
            'E' -> "Ẹ"
            'F' -> "𝐅"
            'G' -> "𝕘"
            'H' -> "𝓱"
            'I' -> "𝓲"
            'J' -> "נ"
            'K' -> "ķ"
            'L' -> "𝓛"
            'M' -> "Ⓜ"
            'N' -> "ℕ"
            'O' -> "𝑜"
            'P' -> "卩"
            'Q' -> "ⓠ"
            'R' -> "ｒ"
            'S' -> "ｓ"
            'T' -> "𝐭"
            'U' -> "𝕌"
            'V' -> "ש"
            'W' -> "ⓦ"
            'X' -> "Ж"
            'Y' -> "Ⓨ"
            'Z' -> "ž"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar38(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "ά"
            'B' -> "Ｂ"
            'C' -> "ᶜ"
            'D' -> "𝐃"
            'E' -> "𝕖"
            'F' -> "Ｆ"
            'G' -> "𝓰"
            'H' -> "ℍ"
            'I' -> "𝕚"
            'J' -> "Ｊ"
            'K' -> "Ｋ"
            'L' -> "ℓ"
            'M' -> "м"
            'N' -> "𝔫"
            'O' -> "Ｏ"
            'P' -> "𝔭"
            'Q' -> "𝐐"
            'R' -> "Ř"
            'S' -> "ร"
            'T' -> "ｔ"
            'U' -> "υ"
            'V' -> "Ｖ"
            'W' -> "𝓌"
            'X' -> "Ж"
            'Y' -> "¥"
            'Z' -> "𝓩"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar37(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "卂"
            'B' -> "𝔟"
            'C' -> "¢"
            'D' -> "𝕕"
            'E' -> "Ⓔ"
            'F' -> "ｆ"
            'G' -> "𝔤"
            'H' -> "𝔥"
            'I' -> "ᶤ"
            'J' -> "ڶ"
            'K' -> "ķ"
            'L' -> "𝔩"
            'M' -> "Ⓜ"
            'N' -> "Ň"
            'O' -> "ᗝ"
            'P' -> "𝔭"
            'Q' -> "𝓠"
            'R' -> "𝓡"
            'S' -> "ｓ"
            'T' -> "ｔ"
            'U' -> "𝕌"
            'V' -> "ש"
            'W' -> "ⓦ"
            'X' -> "Ⓧ"
            'Y' -> "𝓎"
            'Z' -> "𝐳"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar36(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "ᵃ"
            'B' -> "𝓑"
            'C' -> "𝓬"
            'D' -> "Ⓓ"
            'E' -> "€"
            'F' -> "Ｆ"
            'G' -> "𝓰"
            'H' -> "𝐡"
            'I' -> "ⓘ"
            'J' -> "𝓙"
            'K' -> "ｋ"
            'L' -> "ｌ"
            'M' -> "๓"
            'N' -> "𝓃"
            'O' -> "ㄖ"
            'P' -> "𝓟"
            'Q' -> "ᵠ"
            'R' -> "𝓡"
            'S' -> "ⓢ"
            'T' -> "丅"
            'U' -> "𝓊"
            'V' -> "𝓿"
            'W' -> "ω"
            'X' -> "Ж"
            'Y' -> "𝕪"
            'Z' -> "ž"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar35(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "ⓐ"
            'B' -> "в"
            'C' -> "¢"
            'D' -> "๔"
            'E' -> "𝐄"
            'F' -> "千"
            'G' -> "g"
            'H' -> "ⓗ"
            'I' -> "𝓘"
            'J' -> "ڶ"
            'K' -> "к"
            'L' -> "𝔩"
            'M' -> "𝓜"
            'N' -> "ภ"
            'O' -> "ⓞ"
            'P' -> "𝓹"
            'Q' -> "ｑ"
            'R' -> "𝓡"
            'S' -> "ˢ"
            'T' -> "ᵗ"
            'U' -> "𝓊"
            'V' -> "𝐕"
            'W' -> "Ｗ"
            'X' -> "𝕩"
            'Y' -> "ㄚ"
            'Z' -> "ž"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar34(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "ά"
            'B' -> "ⓑ"
            'C' -> "Ć"
            'D' -> "๔"
            'E' -> "Ｅ"
            'F' -> "ℱ"
            'G' -> "ｇ"
            'H' -> "ⓗ"
            'I' -> "丨"
            'J' -> "ן"
            'K' -> "Ќ"
            'L' -> "Ｌ"
            'M' -> "Μ"
            'N' -> "𝐧"
            'O' -> "Ỗ"
            'P' -> "ᵖ"
            'Q' -> "𝕢"
            'R' -> "ʳ"
            'S' -> "𝐒"
            'T' -> "т"
            'U' -> "𝐔"
            'V' -> "ν"
            'W' -> "ω"
            'X' -> "Ж"
            'Y' -> "Ｙ"
            'Z' -> "Ｚ"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar33(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "𝒶"
            'B' -> "Ⓑ"
            'C' -> "ᑕ"
            'D' -> "𝐝"
            'E' -> "ᵉ"
            'F' -> "ᖴ"
            'G' -> "𝐆"
            'H' -> "𝕙"
            'I' -> "𝓘"
            'J' -> "ⓙ"
            'K' -> "ⓚ"
            'L' -> "𝐋"
            'M' -> "ｍ"
            'N' -> "几"
            'O' -> "ｏ"
            'P' -> "ｐ"
            'Q' -> "Ɋ"
            'R' -> "尺"
            'S' -> "ᔕ"
            'T' -> "𝕥"
            'U' -> "υ"
            'V' -> "𝓋"
            'W' -> "ᗯ"
            'X' -> "𝓧"
            'Y' -> "Ｙ"
            'Z' -> "𝐙"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar32(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "ₐ"
            'B' -> "b"
            'C' -> "c"
            'D' -> "d"
            'E' -> "ₑ"
            'F' -> "f"
            'G' -> "g"
            'H' -> "ₕ"
            'I' -> "ᵢ"
            'J' -> "ⱼ"
            'K' -> "ₖ"
            'L' -> "ₗ"
            'M' -> "ₘ"
            'N' -> "ₙ"
            'O' -> "ₒ"
            'P' -> "ₚ"
            'Q' -> "q"
            'R' -> "ᵣ"
            'S' -> "ₛ"
            'T' -> "ₜ"
            'U' -> "ᵤ"
            'V' -> "ᵥ"
            'W' -> "w"
            'X' -> "ₓ"
            'Y' -> "y"
            'Z' -> "z"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar31(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "𝐀"
            'B' -> "๒"
            'C' -> "Ć"
            'D' -> "𝓭"
            'E' -> "𝑒"
            'F' -> "ⓕ"
            'G' -> "𝕘"
            'H' -> "𝓱"
            'I' -> "Ɨ"
            'J' -> "Ｊ"
            'K' -> "Ⓚ"
            'L' -> "ᒪ"
            'M' -> "м"
            'N' -> "𝐍"
            'O' -> "Ø"
            'P' -> "卩"
            'Q' -> "q"
            'R' -> "я"
            'S' -> "丂"
            'T' -> "𝐓"
            'U' -> "ย"
            'V' -> "ｖ"
            'W' -> "𝔀"
            'X' -> "x"
            'Y' -> "𝔂"
            'Z' -> "𝓩"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar30(char: Char): String {
        return when (char.lowercaseChar()) {
            'a' -> "ค"
            'b' -> "๖"
            'c' -> "¢"
            'd' -> "໓"
            'e' -> "ē"
            'f' -> "f"
            'g' -> "ງ"
            'h' -> "h"
            'i' -> "i"
            'j' -> "ว"
            'k' -> "k"
            'l' -> "l"
            'm' -> "๓"
            'n' -> "ຖ"
            'o' -> "໐"
            'p' -> "p"
            'q' -> "๑"
            'r' -> "r"
            's' -> "Ş"
            't' -> "t"
            'u' -> "น"
            'v' -> "ง"
            'w' -> "ຟ"
            'x' -> "x"
            'y' -> "ฯ"
            'z' -> "ຊ"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar29(char: Char): String {
        return when (char.lowercaseChar()) {
            'a' -> "Թ"
            'b' -> "Յ"
            'c' -> "Շ"
            'd' -> "Ժ"
            'e' -> "ȝ"
            'f' -> "Բ"
            'g' -> "Գ"
            'h' -> "ɧ"
            'i' -> "ɿ"
            'j' -> "ʝ"
            'k' -> "ƙ"
            'l' -> "ʅ"
            'm' -> "ʍ"
            'n' -> "Ռ"
            'o' -> "Ծ"
            'p' -> "ρ"
            'q' -> "φ"
            'r' -> "Ր"
            's' -> "Տ"
            't' -> "Ե"
            'u' -> "Մ"
            'v' -> "ע"
            'w' -> "ա"
            'x' -> "Ճ"
            'y' -> "Վ"
            'z' -> "Հ"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar28(char: Char): String {
        return when (char.lowercaseChar()) {
            'a' -> "Ꮧ"
            'b' -> "Ᏸ"
            'c' -> "ፈ"
            'd' -> "Ꮄ"
            'e' -> "Ꮛ"
            'f' -> "Ꭶ"
            'g' -> "Ꮆ"
            'h' -> "Ꮒ"
            'i' -> "Ꭵ"
            'j' -> "Ꮰ"
            'k' -> "Ꮶ"
            'l' -> "Ꮭ"
            'm' -> "Ꮇ"
            'n' -> "Ꮑ"
            'o' -> "Ꭷ"
            'p' -> "Ꭾ"
            'q' -> "Ꭴ"
            'r' -> "Ꮢ"
            's' -> "Ꮥ"
            't' -> "Ꮦ"
            'u' -> "Ꮼ"
            'v' -> "Ꮙ"
            'w' -> "Ꮗ"
            'x' -> "ጀ"
            'y' -> "Ꭹ"
            'z' -> "ፚ"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar27(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "ᗩ"
            'B' -> "ᗷ"
            'C' -> "ᑕ"
            'D' -> "ᗪ"
            'E' -> "E"
            'F' -> "ᖴ"
            'G' -> "G"
            'H' -> "ᕼ"
            'I' -> "I"
            'J' -> "ᒍ"
            'K' -> "K"
            'L' -> "ᒪ"
            'M' -> "ᗰ"
            'N' -> "ᑎ"
            'O' -> "O"
            'P' -> "ᑭ"
            'Q' -> "ᑫ"
            'R' -> "ᖇ"
            'S' -> "ᔕ"
            'T' -> "T"
            'U' -> "ᑌ"
            'V' -> "ᐯ"
            'W' -> "ᗯ"
            'X' -> "᙭"
            'Y' -> "Y"
            'Z' -> "ᘔ"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar26(char: Char): String {
        return when (char.lowercaseChar()) {
            'a' -> "ﾑ"
            'b' -> "乃"
            'c' -> "ᄃ"
            'd' -> "り"
            'e' -> "乇"
            'f' -> "ｷ"
            'g' -> "ム"
            'h' -> "ん"
            'i' -> "ﾉ"
            'j' -> "ﾌ"
            'k' -> "ズ"
            'l' -> "ﾚ"
            'm' -> "ﾶ"
            'n' -> "刀"
            'o' -> "の"
            'p' -> "ｱ"
            'q' -> "ゐ"
            'r' -> "尺"
            's' -> "丂"
            't' -> "ｲ"
            'u' -> "ひ"
            'v' -> "√"
            'w' -> "W"
            'x' -> "ﾒ"
            'y' -> "ﾘ"
            'z' -> "乙"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar25(char: Char): String {
        return when (char.lowercaseChar()) {
            'a' -> "ค"
            'b' -> "๒"
            'c' -> "ς"
            'd' -> "๔"
            'e' -> "є"
            'f' -> "Ŧ"
            'g' -> "ﻮ"
            'h' -> "ђ"
            'i' -> "เ"
            'j' -> "ן"
            'k' -> "к"
            'l' -> "l"
            'm' -> "๓"
            'n' -> "ภ"
            'o' -> "๏"
            'p' -> "ק"
            'q' -> "ợ"
            'r' -> "г"
            's' -> "ร"
            't' -> "t"
            'u' -> "ย"
            'v' -> "ש"
            'w' -> "ฬ"
            'x' -> "ץ"
            'y' -> "א"
            'z' -> "z"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar24(char: Char): String {
        return when (char.lowercaseChar()) {
            'a' -> "მ"
            'b' -> "ჩ"
            'c' -> "ე"
            'd' -> "ძ"
            'e' -> "პ"
            'f' -> "f"
            'g' -> "ც"
            'h' -> "h"
            'i' -> "ἶ"
            'j' -> "ქ"
            'k' -> "κ"
            'l' -> "l"
            'm' -> "ო"
            'n' -> "ῆ"
            'o' -> "õ"
            'p' -> "ρ"
            'q' -> "გ"
            'r' -> "Γ"
            's' -> "ჰ"
            't' -> "ན"
            'u' -> "υ"
            'v' -> "ὗ"
            'w' -> "w"
            'x' -> "ჯ"
            'y' -> "ყ"
            'z' -> "ɀ"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar23(char: Char): String {
        return when (char.lowercaseChar()) {
            'a' -> "ǟ"
            'b' -> "ɮ"
            'c' -> "ƈ"
            'd' -> "ɖ"
            'e' -> "ɛ"
            'f' -> "ʄ"
            'g' -> "ɢ"
            'h' -> "ɦ"
            'i' -> "ɨ"
            'j' -> "ʝ"
            'k' -> "ӄ"
            'l' -> "ʟ"
            'm' -> "ʍ"
            'n' -> "ռ"
            'o' -> "օ"
            'p' -> "ք"
            'q' -> "զ"
            'r' -> "ʀ"
            's' -> "ֆ"
            't' -> "ȶ"
            'u' -> "ʊ"
            'v' -> "ʋ"
            'w' -> "ա"
            'x' -> "Ӽ"
            'y' -> "ʏ"
            'z' -> "ʐ"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar22(char: Char): String {
        return when (char.lowercaseChar()) {
            'a' -> "a̷"
            'b' -> "b̷"
            'c' -> "c̷"
            'd' -> "d̷"
            'e' -> "e̷"
            'f' -> "f̷"
            'g' -> "g̷"
            'h' -> "h̷"
            'i' -> "i̷"
            'j' -> "j̷"
            'k' -> "k̷"
            'l' -> "l̷"
            'm' -> "m̷"
            'n' -> "n̷"
            'o' -> "o̷"
            'p' -> "p̷"
            'q' -> "q̷"
            'r' -> "r̷"
            's' -> "s̷"
            't' -> "t̷"
            'u' -> "u̷"
            'v' -> "v̷"
            'w' -> "w̷"
            'x' -> "x̷"
            'y' -> "y̷"
            'z' -> "z̷"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar21(char: Char): String {
        return when (char.lowercaseChar()) {
            'a' -> "a̶"
            'b' -> "b̶"
            'c' -> "c̶"
            'd' -> "d̶"
            'e' -> "e̶"
            'f' -> "f̶"
            'g' -> "g̶"
            'h' -> "h̶"
            'i' -> "i̶"
            'j' -> "j̶"
            'k' -> "k̶"
            'l' -> "l̶"
            'm' -> "m̶"
            'n' -> "n̶"
            'o' -> "o̶"
            'p' -> "p̶"
            'q' -> "q̶"
            'r' -> "r̶"
            's' -> "s̶"
            't' -> "t̶"
            'u' -> "u̶"
            'v' -> "v̶"
            'w' -> "w̶"
            'x' -> "x̶"
            'y' -> "y̶"
            'z' -> "z̶"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar20(char: Char): String {
        return when (char.lowercaseChar()) {
            'a' -> "ꋬ"
            'b' -> "ꃳ"
            'c' -> "ꉔ"
            'd' -> "꒯"
            'e' -> "ꏂ"
            'f' -> "ꊰ"
            'g' -> "ꍌ"
            'h' -> "ꁝ"
            'i' -> "꒐"
            'j' -> "꒻"
            'k' -> "ꀘ"
            'l' -> "꒒"
            'm' -> "ꂵ"
            'n' -> "ꋊ"
            'o' -> "ꄲ"
            'p' -> "ꉣ"
            'q' -> "ꆰ"
            'r' -> "ꋪ"
            's' -> "ꇙ"
            't' -> "꓄"
            'u' -> "꒤"
            'v' -> "꒦"
            'w' -> "ꅐ"
            'x' -> "ꉧ"
            'y' -> "ꌦ"
            'z' -> "ꁴ"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar19(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "ᗅ"
            'B' -> "ᙘ"
            'C' -> "ᑤ"
            'D' -> "ᗫ"
            'E' -> "ᙍ"
            'F' -> "ᖴ"
            'G' -> "ᘜ"
            'H' -> "ᕼ"
            'I' -> "ᓿ"
            'J' -> "ᒙ"
            'K' -> "ᖽ"
            'L' -> "ᒪ"
            'M' -> "ᙢ"
            'N' -> "ᘉ"
            'O' -> "ᓎ"
            'P' -> "ᕿ"
            'Q' -> "ᕴ"
            'R' -> "ᖇ"
            'S' -> "S"
            'T' -> "ᖶ"
            'U' -> "ᑗ"
            'V' -> "ᐻ"
            'W' -> "ᙎ"
            'X' -> "᙭"
            'Y' -> "ᖻ"
            'Z' -> "Z"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar18(char: Char): String {
        return when (char.lowercaseChar()) {
            'a' -> "მ"
            'b' -> "ჩ"
            'c' -> "ე"
            'd' -> "ძ"
            'e' -> "პ"
            'f' -> "f"
            'g' -> "ც"
            'h' -> "h"
            'i' -> "ἶ"
            'j' -> "ქ"
            'k' -> "κ"
            'l' -> "l"
            'm' -> "ო"
            'n' -> "ῆ"
            'o' -> "õ"
            'p' -> "ρ"
            'q' -> "გ"
            'r' -> "Γ"
            's' -> "ჰ"
            't' -> "ན"
            'u' -> "υ"
            'v' -> "ὗ"
            'w' -> "w"
            'x' -> "ჯ"
            'y' -> "ყ"
            'z' -> "ɀ"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar17(char: Char): String {
        return when (char.lowercaseChar()) {
            'a' -> "α"
            'b' -> "в"
            'c' -> "¢"
            'd' -> "∂"
            'e' -> "є"
            'f' -> "ƒ"
            'g' -> "g"
            'h' -> "н"
            'i' -> "ι"
            'j' -> "נ"
            'k' -> "к"
            'l' -> "ℓ"
            'm' -> "м"
            'n' -> "и"
            'o' -> "σ"
            'p' -> "ρ"
            'q' -> "q"
            'r' -> "я"
            's' -> "ѕ"
            't' -> "т"
            'u' -> "υ"
            'v' -> "ν"
            'w' -> "ω"
            'x' -> "χ"
            'y' -> "у"
            'z' -> "z"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar16(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "α"
            'B' -> "Ⴆ"
            'C' -> "ƈ"
            'D' -> "ԃ"
            'E' -> "ҽ"
            'F' -> "ϝ"
            'G' -> "ɠ"
            'H' -> "ԋ"
            'I' -> "ι"
            'J' -> "ʝ"
            'K' -> "ƙ"
            'L' -> "ʅ"
            'M' -> "ɱ"
            'N' -> "ɳ"
            'O' -> "σ"
            'P' -> "ρ"
            'Q' -> "ϙ"
            'R' -> "ɾ"
            'S' -> "ʂ"
            'T' -> "ƚ"
            'U' -> "υ"
            'V' -> "ʋ"
            'W' -> "ɯ"
            'X' -> "x"
            'Y' -> "ყ"
            'Z' -> "ȥ"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar15(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "Δ"
            'B' -> "β"
            'C' -> "Ć"
            'D' -> "Đ"
            'E' -> "€"
            'F' -> "₣"
            'G' -> "Ǥ"
            'H' -> "Ħ"
            'I' -> "Ɨ"
            'J' -> "Ĵ"
            'K' -> "Ҝ"
            'L' -> "Ł"
            'M' -> "Μ"
            'N' -> "Ň"
            'O' -> "Ø"
            'P' -> "Ƥ"
            'Q' -> "Ω"
            'R' -> "Ř"
            'S' -> "Ş"
            'T' -> "Ŧ"
            'U' -> "Ữ"
            'V' -> "V"
            'W' -> "Ŵ"
            'X' -> "Ж"
            'Y' -> "¥"
            'Z' -> "Ž"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar14(char: Char): String {
        return when (char.lowercaseChar()) {
            'a' -> "ᴀ"
            'b' -> "ʙ"
            'c' -> "ᴄ"
            'd' -> "ᴅ"
            'e' -> "ᴇ"
            'f' -> "ғ"
            'g' -> "ɢ"
            'h' -> "ʜ"
            'i' -> "ɪ"
            'j' -> "ᴊ"
            'k' -> "ᴋ"
            'l' -> "ʟ"
            'm' -> "ᴍ"
            'n' -> "ɴ"
            'o' -> "ᴏ"
            'p' -> "ϙ"
            'q' -> "ʀ"
            'r' -> "ʀ"
            's' -> "ꜱ"
            't' -> "ᴛ"
            'u' -> "ᴜ"
            'v' -> "ᴠ"
            'w' -> "ᴡ"
            'x' -> "x"
            'y' -> "ʏ"
            'z' -> "ᴢ"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar13(char: Char): String {
        return when (char.lowercaseChar()) {
            'a' -> "𝘢"
            'b' -> "𝘣"
            'c' -> "𝘤"
            'd' -> "𝘥"
            'e' -> "𝘦"
            'f' -> "𝘧"
            'g' -> "𝘨"
            'h' -> "𝘩"
            'i' -> "𝘪"
            'j' -> "𝘫"
            'k' -> "𝘬"
            'l' -> "𝘭"
            'm' -> "𝘮"
            'n' -> "𝘯"
            'o' -> "𝘰"
            'p' -> "𝘱"
            'q' -> "𝘲"
            'r' -> "𝘳"
            's' -> "𝘴"
            't' -> "𝘵"
            'u' -> "𝘶"
            'v' -> "𝘷"
            'w' -> "𝘸"
            'x' -> "𝘹"
            'y' -> "𝘺"
            'z' -> "𝘻"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar12(char: Char): String {
        return when (char) {
            'a' -> "𝙖"
            'b' -> "𝙗"
            'c' -> "𝙘"
            'd' -> "𝙙"
            'e' -> "𝙚"
            'f' -> "𝙛"
            'g' -> "𝙜"
            'h' -> "𝙝"
            'i' -> "𝙞"
            'j' -> "𝙟"
            'k' -> "𝙠"
            'l' -> "𝙡"
            'm' -> "𝙢"
            'n' -> "𝙣"
            'o' -> "𝙤"
            'p' -> "𝙥"
            'q' -> "𝙦"
            'r' -> "𝙧"
            's' -> "𝙨"
            't' -> "𝙩"
            'u' -> "𝙪"
            'v' -> "𝙫"
            'w' -> "𝙬"
            'x' -> "𝙭"
            'y' -> "𝙮"
            'z' -> "𝙯"
            'A' -> "𝘼"
            'B' -> "𝘽"
            'C' -> "𝘾"
            'D' -> "𝘿"
            'E' -> "𝙀"
            'F' -> "𝙁"
            'G' -> "𝙂"
            'H' -> "𝙃"
            'I' -> "𝙄"
            'J' -> "𝙅"
            'K' -> "𝙆"
            'L' -> "𝙇"
            'M' -> "𝙈"
            'N' -> "𝙉"
            'O' -> "𝙊"
            'P' -> "𝙋"
            'Q' -> "𝙌"
            'R' -> "𝙍"
            'S' -> "𝙎"
            'T' -> "𝙏"
            'U' -> "𝙐"
            'V' -> "𝙑"
            'W' -> "𝙒"
            'X' -> "𝙓"
            'Y' -> "𝙔"
            'Z' -> "𝙕"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar11(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "ꍏ"
            'B' -> "ꌃ"
            'C' -> "ꉓ"
            'D' -> "ꀸ"
            'E' -> "ꍟ"
            'F' -> "ꎇ"
            'G' -> "ꁅ"
            'H' -> "ꃅ"
            'I' -> "ꀤ"
            'J' -> "ꀭ"
            'K' -> "ꀘ"
            'L' -> "꒒"
            'M' -> "ꂵ"
            'N' -> "ꈤ"
            'O' -> "ꂦ"
            'P' -> "ꉣ"
            'Q' -> "ꆰ"
            'R' -> "ꋪ"
            'S' -> "ꌗ"
            'T' -> "꓄"
            'U' -> "ꀎ"
            'V' -> "ꃴ"
            'W' -> "ꅏ"
            'X' -> "ꊼ"
            'Y' -> "ꌩ"
            'Z' -> "ꁴ"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar10(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "α"
            'B' -> "ɓ"
            'C' -> "૮"
            'D' -> "∂"
            'E' -> "ε"
            'F' -> "ƒ"
            'G' -> "ɠ"
            'H' -> "ɦ"
            'I' -> "เ"
            'J' -> "ʝ"
            'K' -> "ҡ"
            'L' -> "ℓ"
            'M' -> "ɱ"
            'N' -> "ɳ"
            'O' -> "σ"
            'P' -> "ρ"
            'Q' -> "φ"
            'R' -> "૨"
            'S' -> "ร"
            'T' -> "ƭ"
            'U' -> "µ"
            'V' -> "ѵ"
            'W' -> "ω"
            'X' -> "א"
            'Y' -> "ყ"
            'Z' -> "ƶ"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar9(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "卂"
            'B' -> "乃"
            'C' -> "匚"
            'D' -> "ᗪ"
            'E' -> "乇"
            'F' -> "千"
            'G' -> "Ꮆ"
            'H' -> "卄"
            'I' -> "丨"
            'J' -> "ﾌ"
            'K' -> "Ҝ"
            'L' -> "ㄥ"
            'M' -> "爪"
            'N' -> "几"
            'O' -> "ㄖ"
            'P' -> "卩"
            'Q' -> "Ɋ"
            'R' -> "尺"
            'S' -> "丂"
            'T' -> "ㄒ"
            'U' -> "ㄩ"
            'V' -> "ᐯ"
            'W' -> "山"
            'X' -> "乂"
            'Y' -> "ㄚ"
            'Z' -> "乙"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar8(char: Char): String {
        return when (char.lowercaseChar()) {
            'a' -> "α"
            'b' -> "Ⴆ"
            'c' -> "ƈ"
            'd' -> "ԃ"
            'e' -> "ҽ"
            'f' -> "ϝ"
            'g' -> "ɠ"
            'h' -> "ԋ"
            'i' -> "ι"
            'j' -> "ʝ"
            'k' -> "ƙ"
            'l' -> "ʅ"
            'm' -> "ɱ"
            'n' -> "ɳ"
            'o' -> "σ"
            'p' -> "ρ"
            'q' -> "ϙ"
            'r' -> "ɾ"
            's' -> "ʂ"
            't' -> "ƚ"
            'u' -> "υ"
            'v' -> "ʋ"
            'w' -> "ɯ"
            'x' -> "x"
            'y' -> "ყ"
            'z' -> "ȥ"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar7(char: Char): String {
        return when (char) {
            'a' -> "𝒶"
            'b' -> "𝒷"
            'c' -> "𝒸"
            'd' -> "𝒹"
            'e' -> "𝑒"
            'f' -> "𝒻"
            'g' -> "𝑔"
            'h' -> "𝒽"
            'i' -> "𝒾"
            'j' -> "𝒿"
            'k' -> "𝓀"
            'l' -> "𝓁"
            'm' -> "𝓂"
            'n' -> "𝓃"
            'o' -> "𝑜"
            'p' -> "𝓅"
            'q' -> "𝓆"
            'r' -> "𝓇"
            's' -> "𝓈"
            't' -> "𝓉"
            'u' -> "𝓊"
            'v' -> "𝓋"
            'w' -> "𝓌"
            'x' -> "𝓍"
            'y' -> "𝓎"
            'z' -> "𝓏"
            'A' -> "𝒜"
            'B' -> "𝐵"
            'C' -> "𝒞"
            'D' -> "𝒟"
            'E' -> "𝐸"
            'F' -> "𝐹"
            'G' -> "𝒢"
            'H' -> "𝐻"
            'I' -> "𝐼"
            'J' -> "𝒥"
            'K' -> "𝒦"
            'L' -> "𝐿"
            'M' -> "𝑀"
            'N' -> "𝒩"
            'O' -> "𝒪"
            'P' -> "𝒫"
            'Q' -> "𝒬"
            'R' -> "𝑅"
            'S' -> "𝒮"
            'T' -> "𝒯"
            'U' -> "𝒰"
            'V' -> "𝒱"
            'W' -> "𝒲"
            'X' -> "𝒳"
            'Y' -> "𝒴"
            'Z' -> "𝒵"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar6(char: Char): String {
        return when (char) {
            'a' -> "𝓪"
            'b' -> "𝓫"
            'c' -> "𝓬"
            'd' -> "𝓭"
            'e' -> "𝓮"
            'f' -> "𝓯"
            'g' -> "𝓰"
            'h' -> "𝓱"
            'i' -> "𝓲"
            'j' -> "𝓳"
            'k' -> "𝓴"
            'l' -> "𝓵"
            'm' -> "𝓶"
            'n' -> "𝓷"
            'o' -> "𝓸"
            'p' -> "𝓹"
            'q' -> "𝓺"
            'r' -> "𝓻"
            's' -> "𝓼"
            't' -> "𝓽"
            'u' -> "𝓾"
            'v' -> "𝓿"
            'w' -> "𝔀"
            'x' -> "𝔁"
            'y' -> "𝔂"
            'z' -> "𝔃"
            'A' -> "𝓐"
            'B' -> "𝓑"
            'C' -> "𝓒"
            'D' -> "𝓓"
            'E' -> "𝓔"
            'F' -> "𝓕"
            'G' -> "𝓖"
            'H' -> "𝓗"
            'I' -> "𝓘"
            'J' -> "𝓙"
            'K' -> "𝓚"
            'L' -> "𝓛"
            'M' -> "𝓜"
            'N' -> "𝓝"
            'O' -> "𝓞"
            'P' -> "𝓟"
            'Q' -> "𝓠"
            'R' -> "𝓡"
            'S' -> "𝓢"
            'T' -> "𝓣"
            'U' -> "𝓤"
            'V' -> "𝓥"
            'W' -> "𝓦"
            'X' -> "𝓧"
            'Y' -> "𝓨"
            'Z' -> "𝓩"
            '0' -> "𝟎"
            '1' -> "𝟏"
            '2' -> "𝟐"
            '3' -> "𝟑"
            '4' -> "𝟒"
            '5' -> "𝟓"
            '6' -> "𝟔"
            '7' -> "𝟕"
            '8' -> "𝟖"
            '9' -> "𝟗"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar5(char: Char): String {
        return when (char) {
            'A' -> "𝔸"
            'B' -> "𝔹"
            'C' -> "ℂ"
            'D' -> "𝔻"
            'E' -> "𝔼"
            'F' -> "𝔽"
            'G' -> "𝔾"
            'H' -> "ℍ"
            'I' -> "𝕀"
            'J' -> "𝕁"
            'K' -> "𝕂"
            'L' -> "𝕃"
            'M' -> "𝕄"
            'N' -> "ℕ"
            'O' -> "𝕆"
            'P' -> "ℙ"
            'Q' -> "ℚ"
            'R' -> "ℝ"
            'S' -> "𝕊"
            'T' -> "𝕋"
            'U' -> "𝕌"
            'V' -> "𝕍"
            'W' -> "𝕎"
            'X' -> "𝕏"
            'Y' -> "𝕐"
            'Z' -> "ℤ"
            '0' -> "𝟘"
            '1' -> "𝟙"
            '2' -> "𝟚"
            '3' -> "𝟛"
            '4' -> "𝟜"
            '5' -> "𝟝"
            '6' -> "𝟞"
            '7' -> "𝟟"
            '8' -> "𝟠"
            '9' -> "𝟡"
            'a' -> "𝕒"
            'b' -> "𝕓"
            'c' -> "𝕔"
            'd' -> "𝕕"
            'e' -> "𝕖"
            'f' -> "𝕗"
            'g' -> "𝕘"
            'h' -> "𝕙"
            'i' -> "𝕚"
            'j' -> "𝕛"
            'k' -> "𝕜"
            'l' -> "𝕝"
            'm' -> "𝕞"
            'n' -> "𝕟"
            'o' -> "𝕠"
            'p' -> "𝕡"
            'q' -> "𝕢"
            'r' -> "𝕣"
            's' -> "𝕤"
            't' -> "𝕥"
            'u' -> "𝕦"
            'v' -> "𝕧"
            'w' -> "𝕨"
            'x' -> "𝕩"
            'y' -> "𝕪"
            'z' -> "𝕫"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar4(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "₳"
            'B' -> "฿"
            'C' -> "₵"
            'D' -> "Đ"
            'E' -> "Ɇ"
            'F' -> "₣"
            'G' -> "₲"
            'H' -> "Ⱨ"
            'I' -> "ł"
            'J' -> "J"
            'K' -> "₭"
            'L' -> "Ⱡ"
            'M' -> "₥"
            'N' -> "₦"
            'O' -> "Ø"
            'P' -> "₱"
            'Q' -> "Q"
            'R' -> "Ɽ"
            'S' -> "₴"
            'T' -> "₮"
            'U' -> "Ʉ"
            'V' -> "V"
            'W' -> "₩"
            'X' -> "Ӿ"
            'Y' -> "Ɏ"
            'Z' -> "Ⱬ"
            else -> char.toString()
        }
    }

    private fun getSquareBlockAlphabetChar(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "🅰"
            'B' -> "🅱"
            'C' -> "🅲"
            'D' -> "🅳"
            'E' -> "🅴"
            'F' -> "🅵"
            'G' -> "🅶"
            'H' -> "🅷"
            'I' -> "🅸"
            'J' -> "🅹"
            'K' -> "🅺"
            'L' -> "🅻"
            'M' -> "🅼"
            'N' -> "🅽"
            'O' -> "🅾"
            'P' -> "🅿"
            'Q' -> "🆀"
            'R' -> "🆁"
            'S' -> "🆂"
            'T' -> "🆃"
            'U' -> "🆄"
            'V' -> "🆅"
            'W' -> "🆆"
            'X' -> "🆇"
            'Y' -> "🆈"
            'Z' -> "🆉"
            else -> char.toString()
        }
    }

    private fun getRoundAlphabetChar(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "🅐"
            'B' -> "🅑"
            'C' -> "🅒"
            'D' -> "🅓"
            'E' -> "🅔"
            'F' -> "🅕"
            'G' -> "🅖"
            'H' -> "🅗"
            'I' -> "🅘"
            'J' -> "🅙"
            'K' -> "🅚"
            'L' -> "🅛"
            'M' -> "🅜"
            'N' -> "🅝"
            'O' -> "🅞"
            'P' -> "🅟"
            'Q' -> "🅠"
            'R' -> "🅡"
            'S' -> "🅢"
            'T' -> "🅣"
            'U' -> "🅤"
            'V' -> "🅥"
            'W' -> "🅦"
            'X' -> "🅧"
            'Y' -> "🅨"
            'Z' -> "🅩"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar3(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "ꋫ"
            'B' -> "ꃃ"
            'C' -> "ꏸ"
            'D' -> "ꁕ"
            'E' -> "ꍟ"
            'F' -> "ꄘ"
            'G' -> "ꁍ"
            'H' -> "ꑛ"
            'I' -> "ꂑ"
            'J' -> "ꀭ"
            'K' -> "ꀗ"
            'L' -> "꒒"
            'M' -> "ꁒ"
            'N' -> "ꁹ"
            'O' -> "ꆂ"
            'P' -> "ꉣ"
            'Q' -> "ꁸ"
            'R' -> "꒓"
            'S' -> "ꌚ"
            'T' -> "꓅"
            'U' -> "ꐇ"
            'V' -> "ꏝ"
            'W' -> "ꅐ"
            'X' -> "ꇓ"
            'Y' -> "ꐟ"
            'Z' -> "ꁴ"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar2(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "𝕬"
            'B' -> "𝕭"
            'C' -> "𝕮"
            'D' -> "𝕯"
            'E' -> "𝕰"
            'F' -> "𝕱"
            'G' -> "𝕲"
            'H' -> "𝕳"
            'I' -> "𝕴"
            'J' -> "𝕵"
            'K' -> "𝕶"
            'L' -> "𝕷"
            'M' -> "𝕸"
            'N' -> "𝕹"
            'O' -> "𝕺"
            'P' -> "𝕻"
            'Q' -> "𝕼"
            'R' -> "𝕽"
            'S' -> "𝕾"
            'T' -> "𝕿"
            'U' -> "𝖀"
            'V' -> "𝖁"
            'W' -> "𝖂"
            'X' -> "𝖃"
            'Y' -> "𝖄"
            'Z' -> "𝖅"
            else -> char.toString()
        }
    }

    private fun getFancyAlphabetChar(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "𝖆"
            'B' -> "𝖇"
            'C' -> "𝖈"
            'D' -> "𝖉"
            'E' -> "𝖊"
            'F' -> "𝖋"
            'G' -> "𝖌"
            'H' -> "𝖍"
            'I' -> "𝖎"
            'J' -> "𝖏"
            'K' -> "𝖐"
            'L' -> "𝖑"
            'M' -> "𝖒"
            'N' -> "𝖓"
            'O' -> "𝖔"
            'P' -> "𝖕"
            'Q' -> "𝖖"
            'R' -> "𝖗"
            'S' -> "𝖘"
            'T' -> "𝖙"
            'U' -> "𝖚"
            'V' -> "𝖛"
            'W' -> "𝖜"
            'X' -> "𝖝"
            'Y' -> "𝖞"
            'Z' -> "𝖟"
            else -> char.toString()
        }
    }

    private fun getSpecialCharUnderlined(char: Char): String {
        return when (char.lowercaseChar()) {
            'a' -> "ɐ"
            'b' -> "b"
            'c' -> "ɔ"
            'd' -> "d"
            'e' -> "ǝ"
            'f' -> "ɟ"
            'g' -> "ƃ"
            'h' -> "ɥ"
            'i' -> "ı"
            'j' -> "ɾ"
            'k' -> "ʞ"
            'l' -> "l"
            'm' -> "ɯ"
            'n' -> "n"
            'o' -> "o"
            'p' -> "d"
            'q' -> "b"
            'r' -> "ɹ"
            's' -> "s"
            't' -> "ʇ"
            'u' -> "n"
            'v' -> "ʌ"
            'w' -> "ʍ"
            'x' -> "x"
            'y' -> "ʎ"
            'z' -> "z"
            else -> char.toString()
        }
    }

    private fun getSquareChar(char: Char): String {
        return when (char.uppercaseChar()) {
            'A' -> "🄰"
            'B' -> "🄱"
            'C' -> "🄲"
            'D' -> "🄳"
            'E' -> "🄴"
            'F' -> "🄵"
            'G' -> "🄶"
            'H' -> "🄷"
            'I' -> "🄸"
            'J' -> "🄹"
            'K' -> "🄺"
            'L' -> "🄻"
            'M' -> "🄼"
            'N' -> "🄽"
            'O' -> "🄾"
            'P' -> "🄿"
            'Q' -> "🅀"
            'R' -> "🅁"
            'S' -> "🅂"
            'T' -> "🅃"
            'U' -> "🅄"
            'V' -> "🅅"
            'W' -> "🅆"
            'X' -> "🅇"
            'Y' -> "🅈"
            'Z' -> "🅉"
            else -> "$char"
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

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val description: TextView = itemView.findViewById(R.id.descriptionTV)
        val cardView: CardView = itemView.findViewById(R.id.card_view)
    }
}
