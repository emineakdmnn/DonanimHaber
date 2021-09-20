package com.emineakduman.donanmhaber.ui.main.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.emineakduman.donanmhaber.model.news.NewsResults
import com.emineakduman.donanmhaber.ui.main.MainRepository

class NewsViewModel : ViewModel() {
    private val repository: MainRepository by lazy { MainRepository() }
     fun getNews():LiveData<List<NewsResults>>?=repository.getNews()
}