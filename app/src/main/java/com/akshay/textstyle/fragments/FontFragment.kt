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


       /* if (fontsItems.isEmpty()) {
            val f1 = Font()
            val f2 = Font()
            val f3 = Font()
            val f4 = Font()
            val f5 = Font()
            val f6 = Font()
            val f7 = Font()
            val f8 = Font()
            val f9 = Font()
            val f10 = Font()
            val f11 = Font()
            val f12 = Font()
            val f13 = Font()
            val f14 = Font()
            val f15 = Font()
            val f16 = Font()
            val f17 = Font()
            val f18 = Font()
            val f19 = Font()
            val f20 = Font()
            val f21 = Font()
            val f22 = Font()
            val f23 = Font()
            val f24 = Font()
            val f25 = Font()
            val f26 = Font()
            val f27 = Font()
            val f28 = Font()
            val f29 = Font()
            val f30 = Font()
            val f31 = Font()
            val f32 = Font()
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
        else {
            fontsItems.clear()
            val f1 = Font()
            val f2 = Font()
            val f3 = Font()
            val f4 = Font()
            val f5 = Font()
            val f6 = Font()
            val f7 = Font()
            val f8 = Font()
            val f9 = Font()
            val f10 = Font()
            val f11 = Font()
            val f12 = Font()
            val f13 = Font()
            val f14 = Font()
            val f15 = Font()
            val f16 = Font()
            val f17 = Font()
            val f18 = Font()
            val f19 = Font()
            val f20 = Font()
            val f21 = Font()
            val f22 = Font()
            val f23 = Font()
            val f24 = Font()
            val f25 = Font()
            val f26 = Font()
            val f27 = Font()
            val f28 = Font()
            val f29 = Font()
            val f30 = Font()
            val f31 = Font()
            val f32 = Font()
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
        }*/

        if (fontsItems.isEmpty()) {
            repeat(33) {
                fontsItems.add(Font())
            }
        }else {
            fontsItems.clear()
            repeat(33) {
                fontsItems.add(Font())
            }
        }

        fontsRV = view.findViewById(R.id.recycle_view_FF)
        val adapter = FontAdapter(fontsItems, requireContext() as Activity)
        with(fontsRV) {
            this?.layoutManager = LinearLayoutManager(context)
            this?.setAdapter(adapter)
        }
        editText = activity?.findViewById(R.id.edit_text_main)
        with(editText){
            this?.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable) {}
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    //var editTextStr = text.toString()

                    updateDecorationFonts(s.toString())
                    adapter.notifyDataSetChanged()

                  /*  if (editTextStr.isEmpty() || editTextStr == " ") {
                        editTextStr = "hey!"
                    }
                    for (item in fontsItems.indices) {
                        fontsItems[item].setPreviewText(editTextStr)
                        adapter.notifyDataSetChanged()
                    }*/
                }
            })
            updateDecorationFonts(editText?.text.toString())
            adapter.notifyDataSetChanged()
        }
        return view
    }
    private fun updateDecorationFonts(text:String) {
        var editTextStr = text
        if (editTextStr.isEmpty()) {
            editTextStr= "hello"
        }
        for (item in fontsItems.indices) {
            fontsItems[item].setPreviewText(editTextStr)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(requireContext())
        this.context = context as Activity?
    }
}