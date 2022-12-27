package com.programmers.githubapiMVC_00.ViewModel.Data

import com.google.gson.annotations.SerializedName

data class UsersData(
       @SerializedName("login")
       val login : String,
       @SerializedName("avatar_url")
       val avatar_url : String
)