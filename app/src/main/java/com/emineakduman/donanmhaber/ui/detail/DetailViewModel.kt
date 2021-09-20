package com.emineakduman.donanmhaber.ui.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.emineakduman.donanmhaber.model.news.NewsResults

class DetailViewModel(app:Application): AndroidViewModel(app) {

    private val repository: DetailRepository by lazy { DetailRepository(app.applicationContext) }

    fun insertMovie(newsResults: NewsResults?) = repository.insertNews(newsResults)

    fun deleteNews(newsResults: NewsResults?) = repository.deleteNews(newsResults)

    fun getSingleNews(newsId: Int?): LiveData<NewsResults> = repository.getSingleNews(newsId)

    fun getAllNews(): LiveData<List<NewsResults>> = repository.getAllNews()

}