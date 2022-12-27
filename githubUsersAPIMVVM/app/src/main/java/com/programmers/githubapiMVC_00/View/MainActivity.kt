package com.programmers.githubapiMVC_00.View

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.programmers.githubapiMVC_00.ViewModel.Data.UserResponse
import com.programmers.githubapiMVC_00.ViewModel.Data.UsersData
import com.programmers.githubapiMVC_00.Model.GithubService.UsersService.UsersServiceManager
import com.programmers.githubapiMVC_00.ViewModel.MainViewModel
import com.programmers.githubapi_00.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback


class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val model : MainViewModel by viewModels()
    lateinit var listAdapter: UsersAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        listAdapter = UsersAdapter()


        binding.ivMainSearch.setOnClickListener {
            resultSearch(binding.etMain.text.toString())
        }
        binding.rvMain.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }


    fun resultSearch(query: String) {
        val call = UsersServiceManager.getRetrofitService.getUsers(query)
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