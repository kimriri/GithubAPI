package com.programmers.githubapiMVC_00.Model

import android.util.Log
import com.programmers.githubapiMVC_00.GithubService.Data.UserResponse
import com.programmers.githubapiMVC_00.GithubService.Data.UsersData
import com.programmers.githubapiMVC_00.GithubService.UsersService.UsersServiceManager
import com.programmers.githubapiMVC_00.Presenter.MainContract
import retrofit2.Call
import retrofit2.Callback


class MainModel {

     var userList : MutableList<UsersData> = mutableListOf()
    fun resultSearch(query : String) : MutableList<UsersData>{
        val call = UsersServiceManager.getRetrofitService.getUsers(query)
        call.enqueue(object : Callback<UserResponse> {
            override fun onResponse(
                call: Call<UserResponse>,
                response: retrofit2.Response<UserResponse>
            ) {
                if (response.isSuccessful) {
                    if (response.body()?.items != null) {
                        userList = response.body()!!.items

                    }
                }
            }
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.d("TAG", ": onFailure ${t.message}")
            }
        })
        return userList
    }

}