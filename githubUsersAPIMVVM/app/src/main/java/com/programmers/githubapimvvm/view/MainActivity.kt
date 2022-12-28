package com.programmers.githubapimvvm.view

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.programmers.githubapi_00.R
import com.programmers.githubapimvvm.viewmodel.data.userresponse
import com.programmers.githubapimvvm.model.githubuserservice.usersservicemanager
import com.programmers.githubapimvvm.viewmodel.MainViewModel
import com.programmers.githubapi_00.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val model : MainViewModel by viewModels()
    lateinit var listAdapter: usersadapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.search = this
        listAdapter = usersadapter()

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
        val call = usersservicemanager.getRetrofitService.getUsers(binding.etMain.text.toString())
        call.enqueue(object : Callback<userresponse> {
            override fun onResponse(
                call: Call<userresponse>,
                response: retrofit2.Response<userresponse>
            ) {
                if (response.isSuccessful) {
                    if (response.body()?.items != null) {
                        model.loadData(response.body()?.items!!)
                        listAdapter.setList(model._liveData)

                    }
                }
            }
            override fun onFailure(call: Call<userresponse>, t: Throwable) {
                Log.d("TAG", ": onFailure ${t.message}")
            }
        })
    }
}