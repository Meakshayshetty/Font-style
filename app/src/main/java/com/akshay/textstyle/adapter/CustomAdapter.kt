package com.akshay.textstyle.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.akshay.textstyle.R

class CustomAdapter(context: Context, items: List<String>):
    ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getView(position, convertView, parent)
        val textView = view.findViewById<TextView>(android.R.id.text1)
        textView.setTextColor(ContextCompat.getColor(context, R.color.black))
        return view
    }
}