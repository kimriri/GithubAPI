package com.programmers.githubapiRepository.view

import android.database.Observable
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.programmers.githubapiRepository.R
import com.programmers.githubapiRepository.databinding.ActivityMainBinding
import com.programmers.githubapiRepository.viewmodel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import okhttp3.Dispatcher


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewmodel: MainViewModel by viewModels()
    val TAG by lazy { this.componentName.className }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.search = this
        binding.rvMain.adapter = UsersAdapter(context = this)
        observeData()
    }

    fun searchEvent() {
        viewmodel.fetchUsers(binding.etMain.text.toString())
    }

    private fun observeData() {
        lifecycleScope.launch {
            viewmodel.userList.collectLatest {
                if(it.isNotEmpty()) {
                     (binding.rvMain.adapter as UsersAdapter).update(it)
                }
            }
        }
        viewmodel.uiFlow.observe(this, Observer{
            when (it) {
                MainViewModel.UiFlow.EmptyUserList -> {
                    this@MainActivity.toast { "No Users List" }
                    binding.rvMain.visibility = View.GONE
                }
                is MainViewModel.UiFlow.ErrorMessage -> {
                     this@MainActivity.toast { it.throwable.message.toString() }
                        binding.rvMain.visibility = View.GONE }
                MainViewModel.UiFlow.Init -> { }
            }
        })
    }
}


