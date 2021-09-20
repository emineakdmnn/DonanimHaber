package com.emineakduman.donanmhaber.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.emineakduman.donanmhaber.R

object ImageBindingAdapter {
    @BindingAdapter("imageFromUrl")
    @JvmStatic
    fun bindImageFromUrl(view: ImageView, imageUrl: String?) {
        if (imageUrl != null) {
            if(imageUrl.isNotEmpty()) {
                Glide.with(view.context)
                    .load(imageUrl)
                    .into(view)
            }
        }
    }
}