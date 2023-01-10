package com.programmers.githubapiRepository.viewmodel

import androidx.lifecycle.*
import com.programmers.githubapiRepository.data.UsersData
import com.programmers.githubapiRepository.data.repository.remote.retrofitapi.UserInterfaceFlowImpl
import com.programmers.githubapiRepository.data.repository.remote.retrofitapi.UsersServiceManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {

    val liveData = MutableLiveData<MutableList<UsersData>?>()
    private lateinit var _liveSearch: String
     var rquserlist: MutableLiveData<String> = MutableLiveData<String>()
    val apiHelper = UserInterfaceFlowImpl(UsersServiceManager.getRetrofitService)

     fun fetchUsers(liveSearch: String) {
         _liveSearch = liveSearch
        viewModelScope.launch {
            apiHelper.getUsers(liveSearch)
                .flowOn(Dispatchers.IO)
                .catch { e ->
                    rquserlist.value =e.message.toString()
                }
                .collect {
                    liveData.value = it.body()?.items
                    rquserlist.value ="Successful"

                }
        }
    }


}