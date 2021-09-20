package com.emineakduman.donanmhaber

import android.app.Application
import com.facebook.stetho.Stetho

class NewsApp: Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }

}