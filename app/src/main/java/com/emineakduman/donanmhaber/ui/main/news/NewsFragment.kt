package com.emineakduman.donanmhaber.ui.main.news

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.emineakduman.donanmhaber.R
import com.emineakduman.donanmhaber.common.BaseVMFragment
import com.emineakduman.donanmhaber.model.news.NewsResults
import com.emineakduman.donanmhaber.ui.detail.DetailActivity
import com.emineakduman.donanmhaber.ui.main.NewsAdapter
import com.emineakduman.donanmhaber.util.Constants
import com.emineakduman.donanmhaber.util.gone
import com.emineakduman.donanmhaber.util.visible
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : BaseVMFragment<NewsViewModel>(),NewsAdapter.OnNewsClickListener{

    private lateinit var adapter: NewsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun getViewModel(): Class<NewsViewModel> = NewsViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = NewsAdapter()
        news_recyclerview.layoutManager = GridLayoutManager(activity,1)
        adapter.setOnNewsClickListener(this)



        viewModel.getNews()?.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
            news_recyclerview.adapter= adapter
            news_recyclerview.visible()
            news_progressbar.gone()


        })
    }

    override fun onNewsClick(newsResults: NewsResults) {
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra(Constants.EXTRA_NEWS, newsResults)
        startActivity(intent)

    }


}