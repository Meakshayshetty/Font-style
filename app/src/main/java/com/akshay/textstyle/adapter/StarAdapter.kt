package com.akshay.textstyle.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.akshay.textstyle.R

class StarAdapter(private var starIcons: ArrayList<String>?,
                  private val activity: Activity?,
                  private val onClickListener: (String) -> Unit):
    RecyclerView.Adapter<StarAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val row: View =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_star, parent, false)
        return MyViewHolder(row)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val star = starIcons?.get(position)
        holder.bind(star)
    }

    override fun getItemCount(): Int {
        return starIcons!!.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textView: TextView = itemView.findViewById<TextView>(R.id.description_text_view_star)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val icon = starIcons?.get(position)
                    if (icon != null) {
                        onClickListener(icon)
                    }
                }
            }
        }

        fun bind(icon: String?) {
            textView?.text = icon.toString()
        }
    }

}

