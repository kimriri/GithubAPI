package com.programmers.githubapiMVC_00.GithubService.UsersService

import com.programmers.githubapiMVC_00.GithubService.Data.UserResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface UsersInterface {
    @GET("search/users")
    fun getUsers(@Query("q")query: String)
    :  retrofit2.Call<UserResponse>

}