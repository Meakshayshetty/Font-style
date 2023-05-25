package com.akshay.textstyle.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.akshay.textstyle.R

class AlphabetAdapter(
    private var icons: ArrayList<String>?,
    private val onClickListener: (String) -> Unit
):
    RecyclerView.Adapter<AlphabetAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val row: View =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_alphabet, parent, false)
        return MyViewHolder(row)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val star = icons?.get(position)
        holder.bind(star)
    }

    override fun getItemCount(): Int {
        return icons!!.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textView: TextView = itemView.findViewById(R.id.description_text_view_alphabet)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val icon = icons?.get(position)
                    if (icon != null) {
                        onClickListener(icon)
                    }
                }
            }
        }

        fun bind(icon: String?) {
            textView.text = icon.toString()
        }
    }
}