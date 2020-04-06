package com.jiahaoliuliu.movieslistinstant

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter

class ImageBindingAdapter {

    companion object {
        private const val DRAWABLE = "drawable"

        @BindingAdapter("imageFromResources")
        @JvmStatic
        fun setImageFromResources(imageView: ImageView, imageName: String?) {
            val drawableResourceId = imageView.context.resources.getIdentifier(
                imageName, DRAWABLE, imageView.context.packageName
            )
            if (drawableResourceId != 0) {
                imageView.setImageResource(drawableResourceId)
            } else {
                imageView.setImageResource(R.drawable.movie_bloodshot_thumb)
            }
        }
    }
}