package com.example.paging3library.di

import com.example.paging3library.retrofit.QuoteAPI
import com.example.paging3library.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun getRetorift() : Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL).
        addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun getQuoteApi(retrofit: Retrofit) : QuoteAPI {
        return retrofit.create(QuoteAPI::class.java)
    }
}