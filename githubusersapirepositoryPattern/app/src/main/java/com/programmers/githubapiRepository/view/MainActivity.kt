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
        viewmodel.fetchUsers(binding.etMain.text.toString())
        viewmodel.rquserlist.observe(this) {
            if (it == "Successful" && viewmodel.stateFlow.value.size != 0) {
                (binding.rvMain.adapter as UsersAdapter).update(viewmodel.stateFlow.value)
                Toast("No Users List")
            } else {
                Toast(viewmodel.rquserlist.toString())
            }
        }
    }
    fun Toast(string: String) {
        Toast.makeText(this, string , Toast.LENGTH_SHORT).show()
    }

}
