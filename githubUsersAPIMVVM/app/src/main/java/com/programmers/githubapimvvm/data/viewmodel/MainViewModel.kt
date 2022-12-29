package com.programmers.githubapimvvm.data.viewmodel

import androidx.lifecycle.*
import com.programmers.githubapimvvm.data.UsersData
import kotlinx.coroutines.launch



class MainViewModel: ViewModel() {

    val _liveData = MutableLiveData<MutableList<UsersData>?>()

    fun loadData(userList: MutableList<UsersData>) = viewModelScope.launch {
        _liveData.value = userList
        _liveData.postValue(userList)
    }

}