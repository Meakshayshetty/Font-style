package com.akshay.textstyle.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.akshay.textstyle.R
import com.akshay.textstyle.callback.DeleteCallback

class SavedAdapter(private var savedText:ArrayList<String>,
    var callback: DeleteCallback
): RecyclerView.Adapter<SavedAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        private val textView: TextView = itemView.findViewById(R.id.savedTxt)
        private val deleteIcon:ImageView = itemView.findViewById(R.id.deleteIcon)

        fun bind(text: String?,callback: DeleteCallback) {
            textView.text = text.toString()
            deleteIcon.setOnClickListener{
                callback.deleted(text!!)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val row: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_saved, parent, false)
        return MyViewHolder(row)
    }
    override fun getItemCount(): Int {
        return savedText.size
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val text = savedText.get(position)
        holder.bind(text,callback)
    }
    fun updateData(textToSave:ArrayList<String>){
        savedText =textToSave
        notifyDataSetChanged()
    }
}