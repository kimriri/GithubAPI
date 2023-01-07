package com.programmers.githubapiRepository.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.programmers.githubapiRepository.R
import com.programmers.githubapiRepository.databinding.ActivityMainBinding
import com.programmers.githubapiRepository.viewmodel.MainViewModel



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