package com.emineakduman.donanmhaber.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.emineakduman.donanmhaber.databinding.ItemNewsBinding
import com.emineakduman.donanmhaber.model.news.NewsResults

class NewsAdapter : ListAdapter<NewsResults, NewsAdapter.ViewHolder>(DIFF_CALLBACK) {

    private lateinit var onNewsClickListener: OnNewsClickListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.create(LayoutInflater.from(parent.context),parent,onNewsClickListener)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(getItem(position))

    fun setOnNewsClickListener(onNewsClickListener: OnNewsClickListener){
        this.onNewsClickListener=onNewsClickListener
    }

    class ViewHolder(val binding: ItemNewsBinding,onNewsClickListener: OnNewsClickListener):RecyclerView.ViewHolder(binding.root) {
        init{
            binding.root.setOnClickListener {
                onNewsClickListener.onNewsClick(binding.news!!)
            }
        }

        companion object{
            fun create(inflater: LayoutInflater,parent: ViewGroup,onNewsClickListener: OnNewsClickListener) : ViewHolder{
                val itemNewsBinding= ItemNewsBinding.inflate(inflater,parent,false)
                return ViewHolder(itemNewsBinding,onNewsClickListener)

            }
        }
        fun bind(newsResults: NewsResults){
            binding.news = newsResults
            binding.executePendingBindings()

        }

    }

    companion object{
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<NewsResults>() {
            override fun areItemsTheSame(oldItem: NewsResults, newItem: NewsResults): Boolean =
                oldItem.newsId==newItem.newsId



            override fun areContentsTheSame(oldItem: NewsResults, newItem: NewsResults): Boolean =
                oldItem.Title==newItem.Title

        }
    }

    interface OnNewsClickListener{
        fun onNewsClick(newsResults: NewsResults)


    }
}