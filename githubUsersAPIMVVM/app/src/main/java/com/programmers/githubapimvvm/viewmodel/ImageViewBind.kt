package com.programmers.githubapimvvm.viewmodel

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.programmers.githubapi_00.R

object ImageViewBind {
    @androidx.databinding.BindingAdapter("profileImage")
    @JvmStatic
    fun setProfileUrl(view: ImageView, imageUrl: String?) {
        if(imageUrl != null){
            Glide.with(view.context)
                .load(imageUrl)
                .apply(RequestOptions.circleCropTransform())
                .into(view)
        }else {
            view.setImageResource(R.drawable.ic_search)
        }
    }
}
