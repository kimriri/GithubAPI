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