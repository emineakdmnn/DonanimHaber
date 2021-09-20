package com.emineakduman.donanmhaber.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emineakduman.donanmhaber.R
import com.emineakduman.donanmhaber.common.ViewPagerAdapter
import com.emineakduman.donanmhaber.ui.main.favorites.FavoritesFragment
import com.emineakduman.donanmhaber.ui.main.news.NewsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
    }

    private fun setupUI(){
        setSupportActionBar(main_toolbar)
        setupViewPager()
        main_tabs.setupWithViewPager(main_viewpager)

    }
    private fun setupViewPager(){
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.apply {
            addFragment(NewsFragment(),"Haberler")
            addFragment(FavoritesFragment(),"Favoriler")
        }
        main_viewpager.adapter = adapter
        main_viewpager.offscreenPageLimit = 2


    }
}