package com.akshay.textstyle.fragments.main_activity

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akshay.textstyle.R
import com.akshay.textstyle.adapter.RandomiconAdapter

class RandomIconFragment : Fragment() {

    private val icons: ArrayList<String> = arrayListOf("☮", "☸", "♈", "♉", "☪", "♊", "♋", "♌", "♍", "♎", "♏", "♐", "♑", "♒", "♓",
        "☤", "☥", "☧", "☨", "☩", "☫", "☬", "☭", "☯", "☽", "☾", "✙", "✚", "✛", "✜",
        "✝", "✞", "✟", "†", "⊹", "‡", "♁", "♆", "❖", "♅", "✠", "✡", "✢", "卍", "卐",
        "〷", "☠", "☢", "☣", "☦","¢", "$", "€", "£", "¥", "₮", "৲", "৳", "௹", "฿",
        "៛", "₠", "₡", "₢", "₣", "₤", "₥", "₦", "₧", "₨", "✓", "✔", "✗", "✘", "☓", "∨", "√", "✔️", "✅", "❎", "❌", "💯",
        "✇", "☐", "☑", "☒", "〤", "〥",
        "₩", "₪", "₫", "₭", "₯", "₰", "₱", "₲", "₳", "₴",
        "₵", "￥", "﷼", "¤", "ƒ", "©", "®", "™", "℠", "℡", "℗", "‱", "№", "℀", "℁",
        "℅", "℆", "⅍", "☊", "☎", "☏", "⌨", "✁", "✂", "✃",
        "✄", "✆", "✇", "✈", "✉", "✎", "✏", "✐", "✑", "✒",
        "‰", "§", "¶", "✌️", "☝️", "☞", "☛", "☟", "☜", "☚",
        "✍️","♔", "♕", "♖", "♗", "♘", "♙", "♚", "♛", "♜", "♝",
        "♞", "♟", "♤", "♠", "♧", "♣", "♡", "♥", "♢", "♦", "♩", "♪", "♫", "♬", "♭", "♮", "♯", "°", "ø", "؂",
        "≠", "≭", "°", "℃", "℉", "ϟ", "☀", "☁", "☂", "☃", "☉", "☼",
        "☽", "☾", "♁", "♨", "❄", "❅", "❆", "☇", "☈", "☄",
        "㎎", "㎏", "㎜", "㎝", "㎞", "㎡", "㏄", "㏎", "㏑", "㏒",
        "㏕",)


    private val context: Activity? = null
    private var mainText: TextView?= null
    private var edittext_main : EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_random_icon, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recycle_view_random_icon)
        val layoutManager = GridLayoutManager(context, 4)
        recyclerView.layoutManager = layoutManager


        val adapter = RandomiconAdapter(icons) { selectedIcon ->
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