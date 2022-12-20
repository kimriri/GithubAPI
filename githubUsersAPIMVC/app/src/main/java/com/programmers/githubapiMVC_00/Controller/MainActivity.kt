package com.programmers.githubapiMVC_00.Controller

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.programmers.githubapiMVC_00.Model.GitHubService.UsersServiceManager
import com.programmers.githubapiMVC_00.Model.UserResponse
import com.programmers.githubapiMVC_00.Model.UsersData
import com.programmers.githubapi_00.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var listAdapter: UsersAdapter
    var userList = listOf<UsersData>()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        listAdapter = UsersAdapter()

        binding.ivMainSearch.setOnClickListener {

            initList(binding.etMain.text.toString())
            listAdapter.setList(userList)
            listAdapter.notifyDataSetChanged()
        }


        binding.rvMain.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }

    }


    private fun initList(query: String) {
        val call = UsersServiceManager.getRetrofitService.getUsers(query)
        call.enqueue(object : Callback<UserResponse> {
                override fun onResponse(
                    call: Call<UserResponse>,
                    response: retrofit2.Response<UserResponse>
                ) {
                    if (response.isSuccessful) {
                        userList = (response.body()?.items ?: "No") as List<UsersData>
                        listAdapter.setList(userList)
                    }
                }

                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                    Log.d("TAG", ": onFailure ${t.message}")
                }
            })

    }
}