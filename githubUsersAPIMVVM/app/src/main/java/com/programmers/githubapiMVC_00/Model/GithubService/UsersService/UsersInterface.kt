package com.programmers.githubapiMVC_00.Model.GithubService.UsersService

import androidx.lifecycle.Observer
import com.programmers.githubapiMVC_00.ViewModel.Data.UserResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface UsersInterface {
    @GET("search/users")
    @Headers("Authorization: token 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")
    fun getUsers(@Query("q") query: String)
    :  retrofit2.Call<UserResponse>

}