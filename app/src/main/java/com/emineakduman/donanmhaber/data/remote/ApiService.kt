package com.emineakduman.donanmhaber.data.remote

import com.emineakduman.donanmhaber.model.news.NewsResponse
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {



    @GET("/dev/and/api/newest?pageIndex=0&pageSize=15")
    fun getNews(): Call<NewsResponse>
   // fun getNewsResultAsync(@Query("pageIndex") keywords: String): Deferred<Response<NewsResponse>>


}