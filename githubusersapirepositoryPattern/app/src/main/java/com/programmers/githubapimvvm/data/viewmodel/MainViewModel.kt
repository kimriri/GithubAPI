package com.programmers.githubapimvvm.data.viewmodel

import androidx.lifecycle.*
import com.programmers.githubapimvvm.data.repository.UserResponse
import com.programmers.githubapimvvm.data.repository.UsersData
import com.programmers.githubapimvvm.data.viewmodel.retrofitapi.UsersServiceManager
import kotlinx.coroutines.launch
import retrofit2.Response


class MainViewModel: ViewModel() {

    val _liveData = MutableLiveData<MutableList<UsersData>?>()
    lateinit var _liveSearch : String

    fun saveData(userList: MutableList<UsersData>) = viewModelScope.launch{
        _liveData.value = userList
        _liveData.postValue(userList)
    }

    fun saveSearch(liveSearch: String) {
        _liveSearch = liveSearch
    }

    suspend fun resultSearch(): Response<UserResponse> {
       return UsersServiceManager.getRetrofitService.getUsers(_liveSearch)

    }

}