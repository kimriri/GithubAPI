package com.programmers.githubapimvvm.data.viewmodel

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


    @BindingAdapter("profileImage")
    fun ImageView.profileImage(imageUrl: String) {
        Glide.with(this)
            .load(imageUrl)
            .apply(RequestOptions.centerCropTransform())
            .into(this)
}
