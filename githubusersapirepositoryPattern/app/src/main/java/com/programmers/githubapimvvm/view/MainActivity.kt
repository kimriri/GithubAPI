package com.programmers.githubapimvvm.view

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.programmers.githubapimvvm.R
import com.programmers.githubapimvvm.viewmodel.MainViewModel
import com.programmers.githubapimvvm.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity()  {

    private lateinit var binding: ActivityMainBinding
    private val viewmodel : MainViewModel by viewModels()
    val TAG by lazy {  this.componentName.className}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.search = this
        binding.rvMain.adapter = UsersAdapter(emptyList())
    }
    fun searchEvent() {
         viewmodel.saveSearch(binding.etMain.text.toString())
         viewmodel._liveData.observe(this, Observer {
            (binding.rvMain.adapter as UsersAdapter).update(it!!)

        })



    }
}