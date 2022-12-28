package com.programmers.githubapimvvm.viewmodel

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.programmers.githubapi_00.R
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
