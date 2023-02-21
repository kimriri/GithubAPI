package com.programmers.githubapiRepository.view

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.programmers.githubapiRepository.R
import com.programmers.githubapiRepository.data.UsersData
import com.programmers.githubapiRepository.data.UsersRoomData
import com.programmers.githubapiRepository.databinding.ActivityMainBinding
import com.programmers.githubapiRepository.model.NetworkManage
import com.programmers.githubapiRepository.viewmodel.MainViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collectLatest


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewmodel: MainViewModel by viewModels()
    private var bNetworkManage = false
    private val TAG by lazy { this.componentName.className }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val currentTime: Long = System.currentTimeMillis()
        bNetworkManage = NetworkManage().isOnline(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.search = this
        binding.rvMain.adapter = UsersAdapter(context = this)
        runTime()
        (binding.rvMain.adapter as UsersAdapter).setItemClickListener(object :
            UsersAdapter.OnItemClickListener {
            override fun onClick(v: View, position: Int) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("pos",position)
                intent.putExtra("user", viewmodel.userList.value[position].login)
                intent.putExtra("avatar_url", viewmodel.userList.value[position].avatar_url)
                intent.putExtra("favorite", viewmodel.userList.value[position].favorite)
                intent.putExtra("search", binding.etMain.text.toString())
                startActivity(intent)
            }
        })
    }

    fun searchEvent() {
        // 네트워크 상태를 확인하여 네트워크통신 중이 아니라면로컬db에서검색
        if (bNetworkManage) {
            viewmodel.fetchUsers(binding.etMain.text.toString(),applicationContext)
        } else {
            viewmodel.getLocal(binding.etMain.text.toString(), this)
        }
        observeData(binding.etMain.text.toString())
    }

    private fun runTime() {
        lifecycleScope.launch {
            var runtimecount = 0
            // Lifecycle.State.~~  : ~~ 단계 에서 항상 (재)실행 한다.
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                while (true) {
                    Log.d("State.STARTED", binding.tvTimer.text.toString())
                    delay(1000)
                    runtimecount += 1
                    binding.tvTimer.text = "Run Time : ${runtimecount}"
                }
            }
        }
    }


    private fun observeData(search : String) {
        lifecycleScope.launch {
            viewmodel.userList.collectLatest {
                if (it.isNotEmpty()) {
                    (binding.rvMain.adapter as UsersAdapter).update(it)
                    if (bNetworkManage) saveLocal(it,search)
                }
            }
        }
        requestInvalidUsersEvent()

    }

    private fun saveLocal(usersData: MutableList<UsersData>,search: String) {
        for (i in 0 until usersData.size - 1) {
            lifecycleScope.launch {
                UsersRoomData.localUsersRoomDB(applicationContext).localUsersDataDao()
                    .insert(
                        UsersData(
                            i,
                            search,
                            usersData[i].login,
                            usersData[i].avatar_url,
                            usersData[i].favorite
                        )
                    )
            }

        }
    }
    private fun requestInvalidUsersEvent() {
        viewmodel.uiFlow.observe(this, Observer {
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


