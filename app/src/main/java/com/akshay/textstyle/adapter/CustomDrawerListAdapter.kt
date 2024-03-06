package com.akshay.textstyle.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.akshay.textstyle.R
import com.akshay.textstyle.model.CustomListItem

class CustomDrawerListAdapter(context: Context, items: List<CustomListItem>):
    ArrayAdapter<CustomListItem>(context,0, items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        val holder: ViewHolder

        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_drawer, parent, false)
            holder = ViewHolder(itemView.findViewById(R.id.item_image), itemView.findViewById(R.id.item_text))
            itemView.tag = holder
        } else {
            holder = itemView.tag as ViewHolder
        }

        val currentItem = getItem(position)

        // Set image and text for each item
        holder.imageView.setImageResource(currentItem?.imageResId ?: R.drawable.default_image)
        holder.textView.text = currentItem?.text

        return itemView!!
    }

    private class ViewHolder(val imageView: ImageView, val textView: TextView)
}