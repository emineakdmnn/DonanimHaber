package com.emineakduman.donanmhaber.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.emineakduman.donanmhaber.model.news.NewsResults

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertNews(news: NewsResults?):NewsResults

    @Delete
      fun deleteNews(news: NewsResults?):NewsResults

    @Query("SELECT * FROM news")
     fun getAllNews(): LiveData<List<NewsResults>>

    @Query("SELECT * FROM news WHERE newsId= :newsId")
    fun getSingleNews(newsId: Int):LiveData<NewsResults>

}