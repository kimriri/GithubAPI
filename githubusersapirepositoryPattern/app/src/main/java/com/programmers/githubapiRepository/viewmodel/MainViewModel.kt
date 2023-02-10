package com.programmers.githubapiRepository.viewmodel

import android.content.Context
import androidx.lifecycle.*
import androidx.room.Room
import com.programmers.githubapiRepository.data.UsersData
import com.programmers.githubapiRepository.data.UserInterfaceFlowImpl
import com.programmers.githubapiRepository.data.UsersRoomData
import com.programmers.githubapiRepository.data.repository.local.UserDatabase
import com.programmers.githubapiRepository.data.repository.remote.UsersServiceManager
import kotlinx.coroutines.Dispatchers
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

    fun fetchUsers(liveSearch: String,context: Context) {
        viewModelScope.launch {
            _apiHelper.getUsers(liveSearch)
                .flowOn(Dispatchers.IO)
                .catch { e ->
                    _uiFlow.value = UiFlow.ErrorMessage(e)
                }
                .collect {
                    if (it.body()!!.items.isNotEmpty()) {
                        _userList.value = it.body()!!.items
                        saveLocal(it.body()!!.items,liveSearch,context)
                    } else {
                        _uiFlow.value = UiFlow.EmptyUserList
                    }
                }
        }
    }

    private fun saveLocal(usersData: MutableList<UsersData>,search: String,context: Context) {
        for (i in 0 until usersData.size - 1) {
            viewModelScope.launch{
                UsersRoomData.localUsersRoomDB(context).localUsersDataDao()
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

    fun getLocal(search: String, context: Context) {
        viewModelScope.launch {
            _userList.value = UsersRoomData.localUsersRoomDB(context).localUsersDataDao().getUser(search)
        }
    }


    sealed class UiFlow {
        object EmptyUserList : UiFlow()
        class ErrorMessage(val throwable: Throwable) : UiFlow()
        object Init : UiFlow()

    }
}