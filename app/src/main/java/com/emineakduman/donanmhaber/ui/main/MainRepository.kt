package com.emineakduman.donanmhaber.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.emineakduman.donanmhaber.data.remote.ApiClient
import com.emineakduman.donanmhaber.data.remote.ApiService
import com.emineakduman.donanmhaber.model.news.NewsResponse
import com.emineakduman.donanmhaber.model.news.NewsResults
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository {

    private val apiService: ApiService by lazy { ApiClient.getApiService() }

    fun getNews(): LiveData<List<NewsResults>>?{
        val newsLiveData: MutableLiveData<List<NewsResults>> = MutableLiveData()
        apiService.getNews().enqueue(object : Callback<NewsResponse>{
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                newsLiveData.value= response.body()?.results

            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
              Log.e("getNews",t.message.toString())
            }

        }
        )
            return newsLiveData
    }
}