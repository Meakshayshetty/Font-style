package com.akshay.textstyle.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.akshay.textstyle.R
import com.akshay.textstyle.model.BreakingBadQuote

class BreakingBadAdapter(
    private val quotes: List<BreakingBadQuote>
    ,private val onClickListener: (String) -> Unit) :
    RecyclerView.Adapter<BreakingBadAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val quoteTextView: TextView = itemView.findViewById(R.id.tv_quotes)
        val authorTextView: TextView = itemView.findViewById(R.id.tv_author)
        private val quoteCardview :CardView = itemView.findViewById(R.id.cv_quote)

        init {
            quoteCardview.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val quoteText = "${quotes[position].quote} \n\n -${quotes[position].author}"
                    onClickListener(quoteText)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.adapter_quotes, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val quote = quotes[position]
        holder.quoteTextView.text = quote.quote
        holder.authorTextView.text = "- ${quote.author}"
    }

    override fun getItemCount(): Int {
        return quotes.size
    }
}
