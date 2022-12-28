package com.programmers.githubapimvvm.model.githubuserservice

import com.programmers.githubapimvvm.viewmodel.data.userresponse
import retrofit2.http.GET
import retrofit2.http.Query


interface usersinterface {
    @GET("search/users")
    fun getUsers(@Query("q") query: String)
    :  retrofit2.Call<userresponse>

}