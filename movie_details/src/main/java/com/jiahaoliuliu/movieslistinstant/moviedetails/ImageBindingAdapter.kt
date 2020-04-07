package com.jiahaoliuliu.movieslistinstant.moviedetails

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class ImageBindingAdapter {

    companion object {
        @BindingAdapter("imageFromUrl")
        @JvmStatic
        fun setImageFromUrl(imageView: ImageView, url: String?) {
            Glide.with(imageView.context)
                .load(url)
                .into(imageView)
        }
    }
}