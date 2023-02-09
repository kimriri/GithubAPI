package com.programmers.githubapiRepository.viewmodel

import android.content.Context
import androidx.lifecycle.*
import androidx.room.Room
import com.programmers.githubapiRepository.data.UsersData
import com.programmers.githubapiRepository.data.repository.UserInterfaceFlowImpl
import com.programmers.githubapiRepository.data.repository.local.UserDatabase
import com.programmers.githubapiRepository.data.repository.remote.UsersServiceManager
import com.programmers.githubapiRepository.view.UsersAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {

    private val _userList = MutableStateFlow(mutableListOf<UsersData>())
    val userList = _userList.asStateFlow()

    private val _uiFlow = MutableLiveData<UiFlow>(UiFlow.Init)
    val uiFlow: LiveData<UiFlow> = _uiFlow

    private val _apiHelper = UserInterfaceFlowImpl(UsersServiceManager.getRetrofitService)

    fun fetchUsers(liveSearch: String) {
        viewModelScope.launch {
            _apiHelper.getUsers(liveSearch)
                .flowOn(Dispatchers.IO)
                .catch { e ->
                    _uiFlow.value = UiFlow.ErrorMessage(e)
                }
                .collect {
                    if (it.body()!!.items.isNotEmpty()) {
                        _userList.value = it.body()?.items!!
                    } else {
                        _uiFlow.value = UiFlow.EmptyUserList
                    }
                }
        }
    }

    fun getLocal(toString: String, context: Context) {
        viewModelScope.launch {
            val db = Room.databaseBuilder(context, UserDatabase::class.java, toString).build()
            _userList.value = db.localUsersDataDao().getAllUsers()
        }

    }


    sealed class UiFlow {
        object EmptyUserList : UiFlow()
        class ErrorMessage(val throwable: Throwable) : UiFlow()
        object Init : UiFlow()

    }
}