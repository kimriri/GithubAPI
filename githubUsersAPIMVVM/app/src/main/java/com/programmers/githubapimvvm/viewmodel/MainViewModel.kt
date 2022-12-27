package com.programmers.githubapimvvm.viewmodel

import androidx.lifecycle.*
import com.programmers.githubapimvvm.viewmodel.Data.UsersData
import kotlinx.coroutines.launch



class MainViewModel: ViewModel() {

    val _liveData = MutableLiveData<MutableList<UsersData>?>()

    fun loadData(userList: MutableList<UsersData>) = viewModelScope.launch {
        _liveData.value = userList
        _liveData.postValue(userList)
    }


}