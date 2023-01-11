package com.programmers.githubapiRepository.viewmodel

import androidx.lifecycle.*
import com.programmers.githubapiRepository.data.UsersData
import com.programmers.githubapiRepository.data.repository.UserInterfaceFlowImpl
import com.programmers.githubapiRepository.data.repository.remote.UsersServiceManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {

    val liveData = MutableLiveData<MutableList<UsersData>?>()
    var rquserlist: MutableLiveData<String> = MutableLiveData<String>()
     val apiHelper = UserInterfaceFlowImpl(UsersServiceManager.getRetrofitService)

//     fun fetchUsers(liveSearch: String) {
//        viewModelScope.launch {
//            _apiHelper.getUsers(liveSearch)
//                .flowOn(Dispatchers.IO)
//                .catch { e ->
//                    rquserlist.value =e.message.toString()
//                }
//                .collect {
//                    liveData.value = it.body()?.items
//                    rquserlist.value ="Successful"
//
//                }
//        }
//    }
}