package com.emineakduman.donanmhaber.ui.main.favorites

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.emineakduman.donanmhaber.R
import com.emineakduman.donanmhaber.common.BaseVMFragment
import com.emineakduman.donanmhaber.model.news.NewsResults
import com.emineakduman.donanmhaber.ui.detail.DetailActivity
import com.emineakduman.donanmhaber.ui.detail.DetailViewModel
import com.emineakduman.donanmhaber.ui.main.NewsAdapter
import com.emineakduman.donanmhaber.util.Constants
import com.emineakduman.donanmhaber.util.gone
import com.emineakduman.donanmhaber.util.visible
import kotlinx.android.synthetic.main.fragment_favorites.*

class FavoritesFragment : BaseVMFragment<DetailViewModel>(), NewsAdapter.OnNewsClickListener {

    private lateinit var adapter : NewsAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun getViewModel(): Class<DetailViewModel> =DetailViewModel::class.java


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter= NewsAdapter()
        favorite_recyclerview.layoutManager= GridLayoutManager(activity,1)
        adapter.setOnNewsClickListener(this)
        viewModel.getAllNews().observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
            favorite_recyclerview.adapter=adapter
            favorite_recyclerview.visible()
            favorite_progressbar.gone()
        })
    }

    override fun onNewsClick(newsResults: NewsResults) {
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra(Constants.EXTRA_NEWS, newsResults)
        startActivity(intent)

    }


}