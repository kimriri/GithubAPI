package com.programmers.githubapiMVC_00.Presenter

import android.util.Log
import com.programmers.githubapiMVC_00.Model.Data.UserResponse
import com.programmers.githubapiMVC_00.Model.GitHubService.UsersServiceManager
import com.programmers.githubapiMVC_00.Model.ResultSearch
import com.programmers.githubapiMVC_00.View.MainActivity
import retrofit2.Call
import retrofit2.Callback


class MainPresenter(mainActivity: MainActivity) : MainContract.Presenter {

    private var view: MainContract.View? = mainActivity

    fun mResultSearch(query : String) {

        val call = UsersServiceManager.getRetrofitService.getUsers(query)
        call.enqueue(object : Callback<UserResponse> {
            override fun onResponse(
                call: Call<UserResponse>,
                response: retrofit2.Response<UserResponse>
            ) {
                if (response.isSuccessful) {
                    if (response.body()?.items != null) {
                        view?.resultSearch(response.body()?.items!!)
                    }
                }
            }
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.d("TAG", ": onFailure ${t.message}")
            }
        })
    }
    override fun callSearch(search: String) {
        mResultSearch(search)


    }
}