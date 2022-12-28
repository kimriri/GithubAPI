package com.programmers.githubapimvvm.model

import com.programmers.githubapimvvm.data.UserResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface UsersInterface {
    @GET("search/users")
    fun getUsers(@Query("q") query: String)
    :  retrofit2.Call<UserResponse>

}