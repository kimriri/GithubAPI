package com.programmers.githubapiMVC_00.Model.GitHubService

import com.programmers.githubapiMVC_00.Model.UserResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface UsersInterface {
    @GET("search/users")
    @Headers("Authorization: token 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")
    fun getUsers(@Query("q")query: String)
    :  retrofit2.Call<UserResponse>

}