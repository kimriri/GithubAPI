package com.programmers.githubapiMVC_00.Model

import android.util.Log
import com.programmers.githubapiMVC_00.Model.Data.UserResponse
import com.programmers.githubapiMVC_00.Model.Data.UsersData
import com.programmers.githubapiMVC_00.Model.GitHubService.UsersServiceManager
import retrofit2.Call
import retrofit2.Callback

class ResultSearch {

  

    fun mResultSearch(query : String) {

        val call = UsersServiceManager.getRetrofitService.getUsers(query)
        call.enqueue(object : Callback<UserResponse> {
            override fun onResponse(
                call: Call<UserResponse>,
                response: retrofit2.Response<UserResponse>
            ) {
                if (response.isSuccessful) {
                    if (response.body()?.items != null) {
                        var resultUsersList =  response.body()?.items!!
                        ResultUsersList();
                    }
                }
            }
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.d("TAG", ": onFailure ${t.message}")
            }
        })
    }

    fun ResultUsersList(): ArrayList<UsersData> {
        return resultUsersList
    }

}