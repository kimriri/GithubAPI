package com.programmers.githubapimvvm.data.repository.remote.retrofitapi

import com.programmers.githubapimvvm.data.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


  interface UsersInterface {
    @GET("search/users")
    suspend fun getUsers(@Query("q") query: String)
    : Response<UserResponse>
}
