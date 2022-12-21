package com.programmers.githubapiMVC_00.Model.GitHubService

import com.programmers.githubapiMVC_00.Model.Data.UserResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface UsersInterface {
    @GET("search/users")
    @Headers("Authorization: token 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")
    fun getUsers(@Query("q")query: String)
    :  retrofit2.Call<UserResponse>

}