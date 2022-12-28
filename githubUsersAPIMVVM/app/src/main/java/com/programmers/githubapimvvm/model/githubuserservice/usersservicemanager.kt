package com.programmers.githubapimvvm.model.githubuserservice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object usersservicemanager {
    private const val BASE_URL = "https://api.github.com"

    private val getRetrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val getRetrofitService : usersinterface =  getRetrofit.create(usersinterface::class.java)
}
