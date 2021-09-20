package com.emineakduman.donanmhaber.data.remote

import com.emineakduman.donanmhaber.util.Constants
import com.emineakduman.donanmhaber.util.Constants.BASE_URL
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*

object ApiClient {

    fun getApiService(): ApiService{
        val retrofit=Retrofit.Builder()

            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ApiService::class.java)
    }
}