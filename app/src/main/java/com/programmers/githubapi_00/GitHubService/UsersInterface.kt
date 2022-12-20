package com.programmers.githubapi_00.GitHubService

import android.media.MediaCodec.QueueRequest
import com.programmers.githubapi_00.UserResponse
import com.programmers.githubapi_00.UsersData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface UsersInterface {
    @GET("search/users")
    @Headers("Authorization: token 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")
    fun getUsers(@Query("q")query: String)
    :  retrofit2.Call<UserResponse>

}