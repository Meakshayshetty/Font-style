package com.akshay.textstyle.fragments

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akshay.textstyle.R
import com.akshay.textstyle.adapter.MathsymbolAdapter
import com.akshay.textstyle.adapter.NumeralAdapter

class NumeralFragment : Fragment() {

    private val icons: ArrayList<String> = arrayListOf("Ⅰ", "Ⅱ", "Ⅲ", "Ⅳ", "Ⅴ", "Ⅵ", "Ⅶ", "Ⅷ", "Ⅸ", "Ⅹ", "Ⅺ", "Ⅻ", "Ⅼ",
        "Ⅽ", "Ⅾ", "Ⅿ", "ⅰ", "ⅱ", "ⅲ", "ⅳ", "ⅴ",
        "ⅵ", "ⅶ", "ⅷ", "ⅸ", "ⅹ", "ⅺ", "ⅻ", "ⅼ", "ⅽ", "ⅾ", "ⅿ", "ↀ", "ↁ", "ↂ", "➀", "➁", "➂", "➃", "➄", "➅", "➆",
        "➇", "➈", "➉", "➊", "➋", "➌", "➍", "➎", "➏", "➐", "➑", "➒", "➓", "⓵", "⓶", "⓷", "⓸", "⓹", "⓺", "⓻", "⓼",
        "⓽", "⓾", "⓿", "❶", "❷", "❸", "❹", "❺", "❻", "❼", "❽", "❾", "❿", "⁰", "¹", "²", "³", "⁴", "⁵", "⁶", "⁷", "⁸",
        "⁹", "₀", "₁", "₂", "₃", "₄", "₅", "₆", "₇", "₈", "₉", "⓪", "①", "②", "③", "④", "⑤", "⑥", "⑦", "⑧", "⑨",
        "⑩", "⑪", "⑫", "⑬", "⑭", "⑮", "⑯", "⑰", "⑱", "⑲", "⑳", "⑴", "⑵", "⑶", "⑷", "⑸", "⑹", "⑺", "⑻", "⑼", "⑽",
        "⑾", "⑿", "⒀", "⒁", "⒂", "⒃", "⒄", "⒅", "⒆", "⒇", "⒈", "⒉", "⒊", "⒋", "⒌", "⒍", "⒎", "⒏", "⒐", "⒑", "⒒",
        "⒓", "⒔", "⒕", "⒖", "⒗", "⒘", "⒙", "⒚", "⒛", "㈠", "㈡", "㈢", "㈣", "㈤", "㈥", "㈦", "㈧", "㈨", "㈩", "㊀",
        "㊁", "㊂", "㊃", "㊄", "㊅", "㊆", "㊇", "㊈", "㊉", "０", "１", "２", "３", "４", "５", "６", "７", "８", "９", "ⁱ",
        "ₐ", "ₑ", "ₒ", "ₓ", "ₔ")

    private val context: Activity? = null
    private var mainText: TextView?= null
    private var edittext_main : EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_numeral_symbols, container, false)


        val recyclerView: RecyclerView = view.findViewById(R.id.recycle_view_numeral)
        val layoutManager = GridLayoutManager(context, 4)
        recyclerView.layoutManager = layoutManager


        val adapter = NumeralAdapter(icons) { selectedIcon ->
            // Handle the selected icon
            mainText = activity?.findViewById(R.id.main_text)
            edittext_main = activity?.findViewById(R.id.edit_text_main)
            mainText?.append(selectedIcon)
            edittext_main?.append(selectedIcon)
        }
        recyclerView.adapter = adapter

       return view
    }
}