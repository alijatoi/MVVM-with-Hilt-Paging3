package com.example.paging3library.retrofit

import com.example.paging3library.QuoteList
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteAPI {

    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page: Int) : QuoteList

}