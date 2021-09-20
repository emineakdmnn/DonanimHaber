package com.emineakduman.donanmhaber.ui.detail

import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.emineakduman.donanmhaber.data.local.NewsDao
import com.emineakduman.donanmhaber.data.local.NewsDatabase
import com.emineakduman.donanmhaber.model.news.NewsResults

class DetailRepository (context:Context) {
    private val db: NewsDatabase by lazy{NewsDatabase.getIntance(context)}
    private val dao: NewsDao by lazy {db.newsDao()  }

    fun insertNews(news:NewsResults?){
        InsertAsyncTask(dao).execute(news)
    }

    fun deleteNews(news: NewsResults?){
        DeleteAsyncTask(dao).execute(news)
    }

    fun getAllNews():LiveData<List<NewsResults>>{
        return dao.getAllNews()
    }

    fun getSingleNews(newsId:Int?):LiveData<NewsResults>{
        return dao.getSingleNews(newsId)


    }



   private class DeleteAsyncTask(val dao: NewsDao) : AsyncTask<NewsResults, Void, Void>() {
       override fun doInBackground(vararg p0: NewsResults?): Void? {
           dao.deleteNews(p0[0])
           return null
       }
}

    private class InsertAsyncTask(val dao:NewsDao): AsyncTask<NewsResults, Void, Void>() {
        override fun doInBackground(vararg p0: NewsResults?): Void? {
            dao.insertNews(p0[0])
            return null
        }

    } }
