package com.programmers.githubapimvvm.data.viewmodel

import android.widget.EditText
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.programmers.githubapimvvm.data.repository.UsersData
import com.programmers.githubapimvvm.view.UsersAdapter


@BindingAdapter("profileImage")
    fun ImageView.profileImage(imageUrl: String) {
        Glide.with(this)
            .load(imageUrl)
            .apply(RequestOptions.centerCropTransform())
            .into(this)
}
