package com.programmers.githubapiMVC_00.ViewModel

import android.util.Log
import androidx.lifecycle.*
import com.programmers.githubapiMVC_00.Model.GithubService.Data.UserResponse
import com.programmers.githubapiMVC_00.Model.GithubService.Data.UsersData
import com.programmers.githubapiMVC_00.Model.GithubService.UsersService.UsersServiceManager
import com.programmers.githubapiMVC_00.View.UsersAdapter
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback


class MainViewModel: ViewModel() {

    val _liveData = MutableLiveData<MutableList<UsersData>?>()

    fun loadData(userList: MutableList<UsersData>) = viewModelScope.launch {
        _liveData.value = userList
        _liveData.postValue(userList)
    }

}