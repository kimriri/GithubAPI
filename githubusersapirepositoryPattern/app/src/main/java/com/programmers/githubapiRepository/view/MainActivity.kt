package com.programmers.githubapiRepository.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.programmers.githubapiRepository.R
import com.programmers.githubapiRepository.databinding.ActivityMainBinding
import com.programmers.githubapiRepository.viewmodel.MainViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import java.util.*
import kotlin.concurrent.scheduleAtFixedRate


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewmodel: MainViewModel by viewModels()
    val TAG by lazy { this.componentName.className }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val currentTime : Long = System.currentTimeMillis()
        val currentTimeLong = currentTime
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.search = this
        binding.rvMain.adapter = UsersAdapter(context = this)
        runTime()
        observeData()

    }
    fun searchEvent() {
        viewmodel.fetchUsers(binding.etMain.text.toString())
    }
    private fun runTime() {
        lifecycleScope.launch{
            val currentTime : Long = System.currentTimeMillis()

            repeatOnLifecycle(Lifecycle.State.STARTED){
                timerFlow(currentTime).collect{
                    Log.d("ASDF", binding.tvTimer.text.toString())
                }
            }
        }
    }

    private fun timerFlow(currentTime: Long): Flow<Long> = flow {
        var runtime = 1
        var mRunTime = (System.currentTimeMillis() - currentTime) * 0.001
        Timer().scheduleAtFixedRate(0,1000) {
           // Log.d("ASDF", binding.tvTimer.text.toString())
            runtime += 1
            binding.tvTimer.text = "Run Time : ${runtime}"
        }
        emit(mRunTime.toLong())
    }



    private fun observeData() {
        lifecycleScope.launch {

            viewmodel.userList.collectLatest {
                if (it.isNotEmpty()) {
                    (binding.rvMain.adapter as UsersAdapter).update(it)
                }
            }
        }
        requestInvalidUsersEvent()

    }
    private fun requestInvalidUsersEvent() {
        viewmodel.uiFlow.observe(this, Observer{
                when (it) {
                    MainViewModel.UiFlow.EmptyUserList -> {

                        this@MainActivity.toast { "No Users List" }
                        binding.rvMain.visibility = View.GONE
                    }
                    is MainViewModel.UiFlow.ErrorMessage -> {
                        this@MainActivity.toast { it.throwable.message.toString() }
                        binding.rvMain.visibility = View.GONE
                    }
                    MainViewModel.UiFlow.Init -> {}
                }
        })

    }
}


