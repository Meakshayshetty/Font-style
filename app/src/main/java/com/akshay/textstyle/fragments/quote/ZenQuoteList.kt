package com.akshay.textstyle.fragments.quote

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akshay.textstyle.R
import com.akshay.textstyle.activity.DoneScreen
import com.akshay.textstyle.adapter.QuoteAdapter
import com.akshay.textstyle.model.Quote
import com.akshay.textstyle.network.ApiClient
import com.akshay.textstyle.network.QuoteApi
import com.akshay.textstyle.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ZenQuoteList : Fragment() {

    private var rvQuotes :RecyclerView? = null
    private lateinit var quoteAdapter: QuoteAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=  inflater.inflate(R.layout.fragment_zen_quote_list, container, false)

        rvQuotes= view.findViewById(R.id.rv_quotes)

        quotes()

        return view
    }

    private fun quotes() {
        val apiService = ApiClient.retrofit(Constants.BASE_URL_ZEN_QUOTES).create(QuoteApi::class.java)
        val call = apiService.getQuotes()
        rvQuotes?.layoutManager = LinearLayoutManager(view?.context)
        call.enqueue(object : Callback<List<Quote>> {
            override fun onResponse(call: Call<List<Quote>>, response: Response<List<Quote>>) {
                if (response.isSuccessful) {
                    val quotes = response.body()
                    if (!quotes.isNullOrEmpty()) {
                        quoteAdapter = QuoteAdapter(quotes) { selectedString ->
                            // Handle the selected icon
                            val intent = Intent(context, DoneScreen::class.java)
                            intent.putExtra("textDataKey", selectedString)
                            startActivity(intent)
                        }
                        rvQuotes?.adapter = quoteAdapter

                        // Use the quoteText and author in your app
                    }
                } else {
                    // Handle unsuccessful response
                }
            }

            override fun onFailure(call: Call<List<Quote>>, t: Throwable) {
                // Handle network failure
            }
        })
    }
}