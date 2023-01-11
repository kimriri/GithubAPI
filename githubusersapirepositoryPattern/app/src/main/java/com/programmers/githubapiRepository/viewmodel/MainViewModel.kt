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

    val _stateFlow = MutableStateFlow(mutableListOf<UsersData>())
    var stateFlow = _stateFlow.asStateFlow()
    var rquserlist: MutableLiveData<String> = MutableLiveData<String>()
     val apiHelper = UserInterfaceFlowImpl(UsersServiceManager.getRetrofitService)

     fun fetchUsers(liveSearch: String) {
        viewModelScope.launch {
            apiHelper.getUsers(liveSearch)
                .flowOn(Dispatchers.IO)
                .catch { e ->
                    rquserlist.value =e.message.toString()
                }
                .collect {
                    _stateFlow.value = it.body()?.items!!
                    stateFlow = _stateFlow
                    rquserlist.value ="Successful"

                }
        }
    }
}