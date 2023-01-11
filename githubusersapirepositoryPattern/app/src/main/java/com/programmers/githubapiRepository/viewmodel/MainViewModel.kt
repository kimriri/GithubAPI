package com.programmers.githubapiRepository.viewmodel

import androidx.lifecycle.*
import com.programmers.githubapiRepository.data.UsersData
import com.programmers.githubapiRepository.data.repository.UserInterfaceFlowImpl
import com.programmers.githubapiRepository.data.repository.remote.UsersServiceManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {

    private val _stateFlow = MutableStateFlow(mutableListOf<UsersData>())
    private val _rqUserList =  MutableStateFlow("def")
     val _apiHelper = UserInterfaceFlowImpl(UsersServiceManager.getRetrofitService)

    val stateFlow = _stateFlow.asStateFlow()
    val rqUserList = _rqUserList.asStateFlow()

    fun fetchUsers(liveSearch: String) {
        viewModelScope.launch {
            _apiHelper.getUsers(liveSearch)
                .flowOn(Dispatchers.IO)
                .catch { e ->
                    _rqUserList.value = e.message.toString()
                }
                .collect {
                    _stateFlow.value = it.body()?.items!!
                    _rqUserList.value = "Successful"
                }
        }
    }

}