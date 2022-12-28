package com.programmers.githubapimvvm.data.viewmodel

import android.widget.ImageView
import coil.load
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import retrofit2.http.Url

object ImageViewBind {
    @androidx.databinding.BindingAdapter("profileImage")
    @JvmStatic
    fun profileImage(view: ImageView, imageUrl: String) {
        Glide.with(view.context)
            .load(imageUrl)
            .apply(RequestOptions.circleCropTransform())
            .into(view)
    }
}
