package com.akshay.textstyle.fragments

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akshay.textstyle.R
import com.akshay.textstyle.adapter.StarAdapter
import com.akshay.textstyle.model.Font

class StarFragment : Fragment() {

    private val startIcons: ArrayList<String> = arrayListOf(
        "★", "☆", "✡", "✦", "✧", "✩", "✪", "✫", "✬", "✭",
        "✮", "✯", "✰", "⁂", "⁎", "⁑", "✢", "✣", "✤", "✥",
        "✱", "✲", "✳", "✴", "✵", "✶", "✷", "✸", "✹", "✺",
        "✻", "✼", "✽", "✾", "✿", "❀", "❁", "❂", "❃", "❇",
        "❈", "❉", "❊", "❋", "❄", "❆", "❅", "⋆", "≛", "ᕯ",
        "✲", "࿏", "꙰", "۞", "⭒", "⍟", "⭐", "🌠", "🌟", "💫",
        "✨", "🌃", "🔯")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_star, container, false)

   /*     if (startIcons.isEmpty()) {
            repeat(63) {
                startIcons.add(Font())
            }
        } else {
            startIcons.clear()
            repeat(63) {
                startIcons.add(Font())
            }
        }*/

        val recyclerView: RecyclerView = view.findViewById(R.id.recycle_view_star)
        val layoutManager = GridLayoutManager(context, 4)
        recyclerView.layoutManager = layoutManager

        val adapter = StarAdapter(startIcons, context as Activity?) { selectedIcon ->
            // Handle the selected icon
            val editText: EditText = requireActivity().findViewById(R.id.main_text)
            editText.append(selectedIcon)
        }
        recyclerView.adapter = adapter

        return view
    }
}