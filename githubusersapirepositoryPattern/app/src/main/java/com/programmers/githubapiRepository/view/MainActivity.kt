package com.programmers.githubapiRepository.view

import android.os.Bundle
import android.service.autofill.UserData
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.room.Room
import com.programmers.githubapiRepository.R
import com.programmers.githubapiRepository.data.UsersData
import com.programmers.githubapiRepository.data.repository.local.LocalUsersData
import com.programmers.githubapiRepository.data.repository.local.UserDatabase
import com.programmers.githubapiRepository.databinding.ActivityMainBinding
import com.programmers.githubapiRepository.viewmodel.MainViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collectLatest


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
            var runtimecount = 0
        // Lifecycle.State.~~  : ~~ 단계 에서 항상 (재)실행 한다.
            repeatOnLifecycle(Lifecycle.State.STARTED){
                while (true) {
                    Log.d("State.STARTED", binding.tvTimer.text.toString())
                    delay(1000)
                    runtimecount += 1
                    binding.tvTimer.text = "Run Time : ${runtimecount}"
                }
            }
        }
    }


    private fun observeData() {
        lifecycleScope.launch {

            viewmodel.userList.collectLatest {
                if (it.isNotEmpty()) {
                    (binding.rvMain.adapter as UsersAdapter).update(it)
                    saveLocal(it)

                }
            }
        }
        requestInvalidUsersEvent()

    }

    private fun saveLocal(usersData: MutableList<UsersData>) {

        val db = Room.databaseBuilder(
            applicationContext,
            UserDatabase::class.java, binding.tvTimer.text.toString() // DB 이름
        ).build()
        for (i in 0 until  usersData.size) {
            var login: String = usersData[i].login
            var avatar_url: String = usersData[i].avatar_url
            runBlocking {
                db.localUsersDataDao().insert(LocalUsersData(i, login, avatar_url))
                Log.d("[SUCCESS]", " value is saved! name : $login , avatar_url : $avatar_url")
            }
            // IO 쓰레드에서 진행.
            GlobalScope.launch(Dispatchers.IO) {
                var user = db.localUsersDataDao().getUser(login)
                Log.d("[SUCCESS]", " value getted! name : ${user.login} , avatar_url : ${user.avatar_url}")
            }
        }
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


