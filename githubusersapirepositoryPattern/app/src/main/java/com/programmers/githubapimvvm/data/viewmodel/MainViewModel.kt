package com.programmers.githubapimvvm.data.viewmodel

import androidx.lifecycle.*
import com.programmers.githubapimvvm.data.repository.UserResponse
import com.programmers.githubapimvvm.data.repository.UsersData
import com.programmers.githubapimvvm.model.UsersServiceManager
import com.programmers.githubapimvvm.view.UsersAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import kotlin.coroutines.CoroutineContext


class MainViewModel: ViewModel() {

    val _liveData = MutableLiveData<MutableList<UsersData>?>()
    var _liveSearch : String = "11"

    fun saveData(userList: MutableList<UsersData>) = viewModelScope.launch{
        _liveData.value = userList
        _liveData.postValue(userList)
    }

    fun saveSearch(liveSearch: String) {
        _liveSearch = liveSearch
    }

    fun resultSearch(): Call<UserResponse> {
       return UsersServiceManager.getRetrofitService.getUsers(_liveSearch)

    }

}