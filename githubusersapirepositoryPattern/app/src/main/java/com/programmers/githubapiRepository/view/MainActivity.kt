package com.programmers.githubapiRepository.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.programmers.githubapiRepository.R
import com.programmers.githubapiRepository.databinding.ActivityMainBinding
import com.programmers.githubapiRepository.viewmodel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewmodel: MainViewModel by viewModels()
    val TAG by lazy { this.componentName.className }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.search = this
        binding.rvMain.adapter = UsersAdapter(context = this)
    }
      fun searchEvent() {
          lifecycleScope.launch {
              viewmodel.rqUserList.collectLatest {
                  viewmodel.fetchUsers(binding.etMain.text.toString())
                  when (viewmodel.rqUserList.value == "Successful") {
                      true -> { if( viewmodel.stateFlow.value.size != 0) (binding.rvMain.adapter as UsersAdapter).update(viewmodel.stateFlow.value)
                            else this@MainActivity.toast {"No Users List" }
                      }
                      else ->  this@MainActivity.toast { viewmodel.rqUserList.value }
                  }

              }

          }

        }

    }

