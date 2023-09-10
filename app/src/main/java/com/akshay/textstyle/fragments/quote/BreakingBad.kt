package com.akshay.textstyle.fragments.quote

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akshay.textstyle.R
import com.akshay.textstyle.adapter.BreakingBadAdapter
import com.akshay.textstyle.model.BreakingBadQuote
import com.akshay.textstyle.network.ApiClient
import com.akshay.textstyle.network.QuoteApi
import com.akshay.textstyle.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BreakingBad : Fragment() {

    private var rvQuotesBreakingBad : RecyclerView? = null
    private lateinit var breakingBadAdapter: BreakingBadAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_breaking_bad, container, false)

        rvQuotesBreakingBad = view.findViewById(R.id.rv_quotes_breakingBad)

        quotes()
        return view
    }
    private fun quotes() {
        val apiService = ApiClient.retrofit(Constants.BASE_URL_BREAKING_BAD).create(QuoteApi::class.java)
        val call = apiService.getBreakingBadQuotes()
        rvQuotesBreakingBad?.layoutManager = LinearLayoutManager(view?.context)
        call.enqueue(object : Callback<List<BreakingBadQuote>> {

            override fun onResponse(call: Call<List<BreakingBadQuote>>, response: Response<List<BreakingBadQuote>>) {
                if (response.isSuccessful) {
                    val quotes = response.body()
                    if (!quotes.isNullOrEmpty()) {
                        breakingBadAdapter = BreakingBadAdapter(quotes) { selectedString ->
                            // Handle the selected icon
                            saveToClipboard(selectedString)
                            Log.e("breaking bad Quotes", quotes.toString())
                        }
                        rvQuotesBreakingBad?.adapter = breakingBadAdapter

                        // Use the quoteText and author in your app
                    }
                } else {
                    // Handle unsuccessful response
                    Log.e("breaking bad Quotes", response.errorBody().toString())

                }
            }

            override fun onFailure(call: Call<List<BreakingBadQuote>>, t: Throwable) {
                // Handle network failure
                Log.e("breaking bad Quotes", t.message.toString())

            }
        })
    }

    private fun saveToClipboard(desStr: String) {
        val clipboard = requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("simple text", desStr)
        clipboard.setPrimaryClip(clip)

        Toast.makeText(
            context,
            "$desStr Copied!",
            Toast.LENGTH_SHORT
        ).show()
    }
}