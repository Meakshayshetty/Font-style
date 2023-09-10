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
import com.akshay.textstyle.adapter.GameOfThronesAdapter
import com.akshay.textstyle.model.GameOfThrones
import com.akshay.textstyle.network.ApiClient
import com.akshay.textstyle.network.QuoteApi
import com.akshay.textstyle.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GameOfThrones : Fragment() {

    var rvGameOfThrones:RecyclerView? = null
    private lateinit var gameOfThronesAdapter: GameOfThronesAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_game_of_thrones, container, false)

        rvGameOfThrones = view.findViewById(R.id.rv_quotes_game_of_thrones)

        quotes()
        return view
    }

    private fun quotes() {
        val apiService = ApiClient.retrofit(Constants.BASE_URL_GAME_OF_THRONES).create(QuoteApi::class.java)
        val call = apiService.getGameOfThrones()
        rvGameOfThrones?.layoutManager = LinearLayoutManager(view?.context)
        call.enqueue(object : Callback<List<GameOfThrones>> {

            override fun onResponse(call: Call<List<GameOfThrones>>, response: Response<List<GameOfThrones>>) {
                if (response.isSuccessful) {
                    val quotes = response.body()
                    if (!quotes.isNullOrEmpty()) {
                        gameOfThronesAdapter = GameOfThronesAdapter(quotes) { selectedString ->
                            // Handle the selected icon
                            saveToClipboard(selectedString)
                            Log.e("breaking bad Quotes", quotes.toString())
                        }
                        rvGameOfThrones?.adapter = gameOfThronesAdapter

                        // Use the quoteText and author in your app
                    }
                } else {
                    // Handle unsuccessful response
                    Log.e("breaking bad Quotes", response.errorBody().toString())

                }
            }

            override fun onFailure(call: Call<List<GameOfThrones>>, t: Throwable) {
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