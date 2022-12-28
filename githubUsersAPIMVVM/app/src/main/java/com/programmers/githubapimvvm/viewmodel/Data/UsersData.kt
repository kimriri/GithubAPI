package com.programmers.githubapimvvm.viewmodel.Data

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.annotations.SerializedName


data class UsersData(
       @SerializedName("login")
       val login : String,
       @SerializedName("avatar_url")
       val avatar_url : String
)