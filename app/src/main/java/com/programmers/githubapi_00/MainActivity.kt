package com.programmers.githubapi_00

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.UserData
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.programmers.githubapi_00.GitHubService.UsersServiceManager
import com.programmers.githubapi_00.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var listAdapter: UsersAdapter
    var userList = listOf<UsersData>()
    val listUsers = MutableLiveData<ArrayList<UserData>>()
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