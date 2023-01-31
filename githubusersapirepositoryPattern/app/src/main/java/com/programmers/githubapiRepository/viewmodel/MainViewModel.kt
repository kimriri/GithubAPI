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

    private val _userList = MutableStateFlow(mutableListOf<UsersData>())
    val userList = _userList.asStateFlow()

    private val _uiFlow = MutableLiveData<UiFlow>(UiFlow.Init)
    val uiFlow : LiveData<UiFlow> = _uiFlow

    val _apiHelper = UserInterfaceFlowImpl(UsersServiceManager.getRetrofitService)

    fun fetchUsers(liveSearch: String) {
        viewModelScope.launch {
            _apiHelper.getUsers(liveSearch)
                .flowOn(Dispatchers.IO)
                .catch { e ->
                    _uiFlow.value = UiFlow.ErrorMessage(e)
                }
                .collect {
                    if(it.body()!!.items.isNotEmpty()){
                        _userList.value = it.body()?.items!!
                    }else {
                        _uiFlow.value = UiFlow.EmptyUserList
                    }

                }
        }
    }



    sealed class UiFlow{
        object EmptyUserList : UiFlow()
        class ErrorMessage(val throwable : Throwable) : UiFlow()
        object Init : UiFlow()

    }
}