package com.programmers.githubapimvvm.view

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.programmers.githubapimvvm.R
import com.programmers.githubapimvvm.data.viewmodel.MainViewModel
import com.programmers.githubapimvvm.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity()  {


    private lateinit var binding: ActivityMainBinding
    private val viewmodel : MainViewModel by viewModels()
    private val listAdapter: UsersAdapter = UsersAdapter()
    val TAG by lazy {  this.componentName.className}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.search = this
        binding.rvMain.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }
    fun searchEvent() {
         viewmodel.saveSearch(binding.etMain.text.toString())
         CoroutineScope(Dispatchers.Main).launch {
             val rqUserList = viewmodel.resultSearch()
             if(rqUserList.isSuccessful) {
                 Log.d(TAG,rqUserList.code().toString())
                 viewmodel.saveData(rqUserList.body()?.items!!)
                 listAdapter.setList(viewmodel._liveData)
             }else {
                 Log.e(TAG,rqUserList.message())
             }
         }
    }
}