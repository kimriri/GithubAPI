package com.programmers.githubapimvvm.data.viewmodel.retrofitapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object UsersServiceManager {
    private const val BASE_URL = "https://api.github.com"

    private val getRetrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val getRetrofitService : UsersInterface =  getRetrofit.create(UsersInterface::class.java)
}
