package com.emineakduman.donanmhaber.data.local

import android.content.Context
import androidx.room.*
import com.emineakduman.donanmhaber.model.news.NewsResults

@Database(entities = [NewsResults::class],version = 1,exportSchema = false)
@TypeConverters(Converter::class)
abstract class NewsDatabase:RoomDatabase() {

    abstract fun newsDao(): NewsDao

    companion object{
        @Volatile
        var INSTANCE: NewsDatabase?=null

        @Synchronized
        fun getIntance(context: Context):NewsDatabase{
            if(INSTANCE==null){
                INSTANCE= Room.databaseBuilder(
                    context.applicationContext,
                    NewsDatabase::class.java,
                    "news.db"
                )
                    .build()
            }
                return INSTANCE as NewsDatabase
        }
    }
}