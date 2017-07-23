package com.example.kotlin.movieapp.binding

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.bumptech.glide.request.RequestOptions

object GlideBinding {
    @JvmStatic
    @BindingAdapter(value = *arrayOf("imageUrl", "placeholderResource"), requireAll = false)
    fun setImageUrl(imageView: ImageView, imageUrl: String?, placeholderResource: Int?) {
        if (!imageUrl.isNullOrEmpty()) {
            var glide = Glide.with(imageView.context)
                    .load(imageUrl)
                    .transition(withCrossFade())

            if (placeholderResource != null) {
                glide.apply(
                        RequestOptions()
                                .placeholder(placeholderResource)
                )
            }

            glide.into(imageView)
        }
    }
}
