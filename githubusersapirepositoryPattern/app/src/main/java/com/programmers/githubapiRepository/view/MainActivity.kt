package com.programmers.githubapiRepository.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.programmers.githubapiRepository.R
import com.programmers.githubapiRepository.databinding.ActivityMainBinding
import com.programmers.githubapiRepository.viewmodel.MainViewModel


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
        viewmodel.saveSearch(binding.etMain.text.toString())
        viewmodel.rquserlist.observe(this,Observer{
            if(it == "Successful") {
                (binding.rvMain.adapter as UsersAdapter).update(viewmodel.liveData.value!!)
            }else{
                Toast.makeText(this,"No Users List ",Toast.LENGTH_SHORT).show()
            }
            })
        }
}