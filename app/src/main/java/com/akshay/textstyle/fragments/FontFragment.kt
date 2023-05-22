package com.akshay.textstyle.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akshay.textstyle.R
import com.akshay.textstyle.adapter.FontAdapter
import com.akshay.textstyle.model.Font

class FontFragment : Fragment() {
    private var context: Activity? = null
    private var fontsRV: RecyclerView? = null
    private val fontsItems: ArrayList<Font> = ArrayList<Font>()
    private var editText: EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?, ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_font, container, false)
        if (fontsItems.isEmpty()) {
            val f1 = Font("Bubble")
            val f2 = Font("Currency")
            val f3 = Font("Magic")
            val f4 = Font("Knight")
            val f5 = Font("Antrophobia")
            val f6 = Font("Fancy style 1")
            val f7 = Font("Fancy style 2")
            val f8 = Font("Fancy style 3")
            val f9 = Font("Fancy style 4")
            val f10 = Font("Fancy style 5")
            val f11 = Font("Fancy style 6")
            val f12 = Font("Fancy style 7")
            val f13 = Font("Fancy style 8")
            val f14 = Font("Fancy style 9")
            val f15 = Font("Fancy style 10")
            val f16 = Font("Fancy style 11")
            val f17 = Font("Fancy style 12")
            val f18 = Font("Fancy style 13")
            val f19 = Font("Fancy style 14")
            val f20 = Font("Fancy style 15")
            val f21 = Font("Aries")
            val f22 = Font("Taurus")
            val f23 = Font("Gemini")
            val f24 = Font("Cancer")
            val f25 = Font("Leo")
            val f26 = Font("Virgo")
            val f27 = Font("Libra")
            val f28 = Font("Scorpius")
            val f29 = Font("Sagittarius")
            val f30 = Font("Capricorn")
            val f31 = Font("Aquarius")
            val f32 = Font("Pisces")
            fontsItems.add(f1)
            fontsItems.add(f2)
            fontsItems.add(f3)
            fontsItems.add(f4)
            fontsItems.add(f5)
            fontsItems.add(f6)
            fontsItems.add(f7)
            fontsItems.add(f8)
            fontsItems.add(f9)
            fontsItems.add(f10)
            fontsItems.add(f11)
            fontsItems.add(f12)
            fontsItems.add(f13)
            fontsItems.add(f14)
            fontsItems.add(f15)
            fontsItems.add(f16)
            fontsItems.add(f17)
            fontsItems.add(f18)
            fontsItems.add(f19)
            fontsItems.add(f20)
            fontsItems.add(f21)
            fontsItems.add(f22)
            fontsItems.add(f23)
            fontsItems.add(f24)
            fontsItems.add(f25)
            fontsItems.add(f26)
            fontsItems.add(f27)
            fontsItems.add(f28)
            fontsItems.add(f29)
            fontsItems.add(f30)
            fontsItems.add(f31)
            fontsItems.add(f32)
        } else {
            fontsItems.clear()
            val f1 = Font("Bubble")
            val f2 = Font("Currency")
            val f3 = Font("Magic")
            val f4 = Font("Knight")
            val f5 = Font("Antrophobia")
            val f6 = Font("Fancy style 1")
            val f7 = Font("Fancy style 2")
            val f8 = Font("Fancy style 3")
            val f9 = Font("Fancy style 4")
            val f10 = Font("Fancy style 5")
            val f11 = Font("Fancy style 6")
            val f12 = Font("Fancy style 7")
            val f13 = Font("Fancy style 8")
            val f14 = Font("Fancy style 9")
            val f15 = Font("Fancy style 10")
            val f16 = Font("Fancy style 11")
            val f17 = Font("Fancy style 12")
            val f18 = Font("Fancy style 13")
            val f19 = Font("Fancy style 14")
            val f20 = Font("Fancy style 15")
            val f21 = Font("Aries")
            val f22 = Font("Taurus")
            val f23 = Font("Gemini")
            val f24 = Font("Cancer")
            val f25 = Font("Leo")
            val f26 = Font("Virgo")
            val f27 = Font("Libra")
            val f28 = Font("Scorpius")
            val f29 = Font("Sagittarius")
            val f30 = Font("Capricorn")
            val f31 = Font("Aquarius")
            val f32 = Font("Pisces")
            fontsItems.add(f1)
            fontsItems.add(f2)
            fontsItems.add(f3)
            fontsItems.add(f4)
            fontsItems.add(f5)
            fontsItems.add(f6)
            fontsItems.add(f7)
            fontsItems.add(f8)
            fontsItems.add(f9)
            fontsItems.add(f10)
            fontsItems.add(f11)
            fontsItems.add(f12)
            fontsItems.add(f13)
            fontsItems.add(f14)
            fontsItems.add(f15)
            fontsItems.add(f16)
            fontsItems.add(f17)
            fontsItems.add(f18)
            fontsItems.add(f19)
            fontsItems.add(f20)
            fontsItems.add(f21)
            fontsItems.add(f22)
            fontsItems.add(f23)
            fontsItems.add(f24)
            fontsItems.add(f25)
            fontsItems.add(f26)
            fontsItems.add(f27)
            fontsItems.add(f28)
            fontsItems.add(f29)
            fontsItems.add(f30)
            fontsItems.add(f31)
            fontsItems.add(f32)
        }
        fontsRV = view.findViewById(R.id.recycle_view_FF)
        val adapter = FontAdapter(fontsItems, requireContext() as Activity)
        with(fontsRV) {
            this?.layoutManager = LinearLayoutManager(context)
            this?.setAdapter(adapter)
        }
        editText = view.findViewById(R.id.edit_text_FF)
        with(editText){
            this?.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable) {}
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    var editTextStr = getText().toString()
                    if (editTextStr.isEmpty() || editTextStr == " ") {
                        editTextStr = "Preview text"
                    }
                    for (item in fontsItems.indices) {
                        fontsItems[item].setPreviewText(editTextStr)
                        adapter.notifyDataSetChanged()
                    }
                }
            })
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(requireContext())
        this.context = context as Activity?
    }
}