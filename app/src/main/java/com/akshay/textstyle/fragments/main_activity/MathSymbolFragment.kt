package com.akshay.textstyle.fragments.main_activity

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


class MathSymbolFragment : Fragment() {


    private val icons: ArrayList<String> = arrayListOf("π", "∞", "Σ", "√", "∛", "∜", "∫", "∬", "∭", "∮",
        "∯", "∰", "∱", "∲", "∳", "∀", "∁", "∂", "∃", "∄", "∅", "∆",
        "∇", "∈", "∉", "∊", "∋", "∌", "∍", "∎", "∏", "∐", "∑", "−", "∓", "∔", "∕", "∖", "∗", "∘", "∙", "∝", "∟", "∠", "∡",
        "∢", "∣", "∤", "∥", "∦", "∧", "∨", "∩", "∪", "∴", "∵", "∶", "∷", "∸", "∹", "∺", "∻", "∼", "∽", "∾", "∿", "≀", "≁",
        "≂", "≃", "≄", "≅", "≆", "≇", "≈", "≉", "≊", "≋", "≌", "≍", "≎", "≏", "≐", "≑", "≒", "≓", "≔", "≕", "≖", "≗",
        "≘", "≙", "≚", "≛", "≜", "≝", "≞", "≟", "≠", "≡", "≢", "≣", "≤", "≥", "≦", "≧", "≨", "≩", "≪", "≫", "≬", "≭",
        "≮", "≯", "≰", "≱", "≲", "≳", "≴", "≵", "≶", "≷", "≸", "≹", "≺", "≻", "≼", "≽", "≾", "≿", "⊀", "⊁", "⊂", "⊃",
        "⊄", "⊅", "⊆", "⊇", "⊈", "⊉", "⊊", "⊋", "⊌", "⊍", "⊎", "⊏", "⊐", "⊑", "⊒", "⊓", "⊔", "⊕", "⊖", "⊗", "⊘",
        "⊙", "⊚", "⊛", "⊜", "⊝", "⊞", "⊟", "⊠", "⊡", "⊢", "⊣", "⊤", "⊥", "⊦", "⊧", "⊨", "⊩", "⊪", "⊫", "⊬", "⊭",
        "⊮", "⊯", "⊰", "⊱", "⊲", "⊳", "⊴", "⊵", "⊶", "⊷", "⊸", "⊹", "⊺", "⊻", "⊼", "⊽", "⊾", "⊿", "⋀", "⋁", "⋂",
        "⋃", "⋄", "⋅", "⋆", "⋇", "⋈", "⋉", "⋊", "⋋", "⋌", "⋍", "⋎", "⋏", "⋐", "⋑", "⋒", "⋓", "⋔", "⋕", "⋖", "⋗",
        "⋘", "⋙", "⋚", "⋛", "⋜", "⋝", "⋞", "⋟", "⋠", "⋡", "⋢", "⋣", "⋤", "⋥", "⋦", "⋧", "⋨", "⋩", "⋪", "⋫", "⋬",
        "⋭", "⋮", "⋯", "⋰", "⋱", "⁺", "⁻", "⁼", "⁽", "⁾", "ⁿ", "₊", "₋", "₌", "₍", "₎", "✖", "﹢", "﹣", "＋", "－",
        "／", "＝", "÷", "±", "×","⅟", "½", "⅓", "⅕", "⅙", "⅛", "⅔", "⅖", "⅚", "⅜", "¾", "⅗", "⅝", "⅞", "⅘", "¼", "⅐",
        "⅑", "⅒", "↉", "%", "℅", "‰", "‱",
        "〈", "〉", "《", "》", "「", "」", "『", "』", "【", "】",
        "〔", "〕", "︵", "︶", "︷", "︸", "︹", "︺", "︻", "︼",
        "︽", "︾", "︿", "﹀", "﹁", "﹂", "﹃", "﹄", "﹙", "﹚",
        "﹛", "﹜", "﹝", "﹞", "﹤", "﹥", "（", "）", "＜", "＞",
        "｛", "｝", "〖", "〗", "〘", "〙", "〚", "〛", "«", "»",
        "‹", "›", "〈", "〉", "〱", "│", "┃", "╽", "╿", "╏", "║", "╎", "┇", "︱", "┊", "︳", "┋", "┆", "╵", "〡", "〢", "╹", "╻", "╷", "〣",
        "☰", "☱", "☲", "☳", "☴", "☵", "☶", "☷", "≡", "✕", "═", "━", "─", "╍", "┅", "┉", "┄", "┈", "╌", "╴", "╶",
        "╸", "╺", "╼", "╾", "﹉", "﹍", "﹊", "﹎", "︲", "⑆", "⑇", "⑈", "⑉", "⑊", "⑄", "⑀", "︴", "﹏", "﹌", "﹋",
        "╳", "╲", "╱", "︶", "︵", "〵", "〴", "〳", "〆", "`", "ᐟ", "‐", "⁃", "⎯", "〄")


    private val context: Activity? = null
    private var mainText: TextView?= null
    private var edittext_main : EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_math_symbol, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recycle_view_maths_symbol)
        val layoutManager = GridLayoutManager(context, 4)
        recyclerView.layoutManager = layoutManager

        val adapter = MathsymbolAdapter(icons) { selectedIcon ->
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