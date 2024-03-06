package com.akshay.textstyle.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.akshay.textstyle.R

class QuickChatAdapter (
    private var quickChats: ArrayList<String>?,
    private val onClickListener: (String) -> Unit
): RecyclerView.Adapter<QuickChatAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val row: View =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_quickchat, parent, false)
        return MyViewHolder(row)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val quickChats = quickChats?.get(position)
        holder.bind(quickChats)

        holder.shareImage.setOnClickListener {
            val sharingIntent = Intent(Intent.ACTION_SEND)

            sharingIntent.type = "text/plain"

            sharingIntent.putExtra(Intent.EXTRA_TEXT, quickChats)

            //sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject)
            holder.itemView.context.startActivity(Intent.createChooser(sharingIntent, "Share using"))
        }
    }

    override fun getItemCount(): Int {
        return quickChats!!.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textView: TextView = itemView.findViewById(R.id.textView)
        val copyImage:ImageView = itemView.findViewById(R.id.imageView_copy)
        val shareImage:ImageView = itemView.findViewById(R.id.imageView_share)

        init {
            copyImage.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val string = quickChats?.get(position)
                    if (string != null) {
                        onClickListener(string)
                    }
                }
            }

        }

        fun bind(quickChats: String?) {
            textView.text = quickChats.toString()
        }
    }
}