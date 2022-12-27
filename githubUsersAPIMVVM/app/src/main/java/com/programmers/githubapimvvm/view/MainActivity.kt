package com.programmers.githubapimvvm.view

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.programmers.githubapi_00.R
import com.programmers.githubapimvvm.viewmodel.Data.UserResponse
import com.programmers.githubapimvvm.model.githubuserservice.UsersServiceManager
import com.programmers.githubapimvvm.viewmodel.MainViewModel
import com.programmers.githubapi_00.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding // xml 파일명이 CamelCase 표기로 바뀌고 Binding이 붙습니다.

    private val model : MainViewModel by viewModels()
    lateinit var listAdapter: UsersAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.search = this
        listAdapter = UsersAdapter()

        binding.ivMainSearch.setOnClickListener {
            resultSearch()
         binding.invalidateAll()
        }

        binding.rvMain.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }


    fun resultSearch() {
        val call = UsersServiceManager.getRetrofitService.getUsers(binding.etMain.text.toString())
        call.enqueue(object : Callback<UserResponse> {
            override fun onResponse(
                call: Call<UserResponse>,
                response: retrofit2.Response<UserResponse>
            ) {
                if (response.isSuccessful) {
                    if (response.body()?.items != null) {
                        model.loadData(response.body()?.items!!)
                        listAdapter.setList(model._liveData)

                    }
                }
            }
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.d("TAG", ": onFailure ${t.message}")
            }
        })
    }
}