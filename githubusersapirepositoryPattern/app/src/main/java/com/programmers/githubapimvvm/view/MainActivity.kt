package com.programmers.githubapimvvm.view

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.programmers.githubapimvvm.R
import com.programmers.githubapimvvm.data.repository.UserResponse
import com.programmers.githubapimvvm.data.viewmodel.MainViewModel
import com.programmers.githubapimvvm.databinding.ActivityMainBinding
import com.programmers.githubapimvvm.model.UsersServiceManager
import retrofit2.Call
import retrofit2.Callback


class MainActivity : AppCompatActivity()  {
    private lateinit var binding: ActivityMainBinding

    private val model : MainViewModel by viewModels()
    private val listAdapter: UsersAdapter = UsersAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.search = this
        binding.rvMain.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }

    fun searchEvent() {
        model.saveSearch(binding.etMain.text.toString())
        model.resultSearch()
            val call = UsersServiceManager.getRetrofitService.getUsers(model._liveSearch)
            call.enqueue(object : Callback<UserResponse> {
                override fun onResponse(
                    call: Call<UserResponse>,
                    response: retrofit2.Response<UserResponse>
                ) {
                    if (response.isSuccessful) {
                        if (response.body()?.items != null) {
                            model.saveData(response.body()?.items!!)
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