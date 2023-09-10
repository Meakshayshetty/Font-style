package com.akshay.textstyle.network

import com.akshay.textstyle.model.BreakingBadQuote
import com.akshay.textstyle.model.GameOfThrones
import com.akshay.textstyle.model.Quote
import retrofit2.Call
import retrofit2.http.GET

interface QuoteApi {
    @GET("quotes")
    fun getQuotes(): Call<List<Quote>>

    @GET("random")
    fun getRandomQuotes(): Call<List<Quote>>

    @GET("v1/quotes/100")
    fun getBreakingBadQuotes() :Call<List<BreakingBadQuote>>

    @GET("v1/random/100")
    fun getGameOfThrones(): Call<List<GameOfThrones>>
}
