package com.emineakduman.donanmhaber.ui.detail

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.emineakduman.donanmhaber.R
import com.emineakduman.donanmhaber.common.BaseActivity
import com.emineakduman.donanmhaber.common.ViewPagerAdapter
import com.emineakduman.donanmhaber.databinding.ActivityDetailBinding
import com.emineakduman.donanmhaber.model.news.NewsResults
import com.emineakduman.donanmhaber.util.Constants
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*

class DetailActivity : BaseActivity<ActivityDetailBinding,DetailViewModel>() {
    private var news: NewsResults?=null
    private var isFav: Boolean?= null

    override fun getLayoutsRes(): Int = R.layout.activity_detail

    override fun getViewModel(): Class<DetailViewModel> = DetailViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupUI()

        intent.extras.let {
            news=it?.getParcelable(Constants.EXTRA_NEWS)

            fabBehaviour(news)
            checkFav()

            favorite_fab.setOnClickListener {

            }

            dataBinding.news=news
        }
    }

    private fun favorite(){
        if(isFav!!){
            viewModel.deleteNews(news)
            Toast.makeText(this, "Favorilerden Çıkarıldı", Toast.LENGTH_SHORT).show()
        }else{
            viewModel.insertMovie(news)
            Toast.makeText(this, "Favorilere Eklendi", Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkFav()
    {
            viewModel.getSingleNews(news?.newsId).observe(this, Observer {
                if(it!=null){
                    favorite_fab.setImageResource(R.drawable.ic_star_border)
                    isFav=true
                }
                else{
                    favorite_fab.setImageResource(R.drawable.ic_baseline_star_border_24)
                    isFav=false
                }
            })
    }    private fun fabBehaviour(news: NewsResults?){
        detail_appbar_layout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffsett ->
            if (Math.abs(verticalOffsett) - appBarLayout.totalScrollRange == 0) {
                favorite_fab.hide()
                supportActionBar?.setDisplayShowTitleEnabled(true)
                detail_toolbar.title = news?.Title
            } else {
                favorite_fab.show()
                supportActionBar?.setDisplayShowTitleEnabled(false)
                detail_toolbar.title = " "
            }
        })
        detail_collapsing_toolbarlayout.setExpandedTitleColor(resources.getColor(android.R.color.transparent))
    }

    private fun setupUI(){
        setSupportActionBar(detail_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

    }




}