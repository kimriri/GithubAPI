package com.programmers.githubapimvvm.viewmodel

import androidx.lifecycle.*
import com.programmers.githubapimvvm.viewmodel.data.usersdata
import kotlinx.coroutines.launch



class MainViewModel: ViewModel() {

    val _liveData = MutableLiveData<MutableList<usersdata>?>()

    fun loadData(userList: MutableList<usersdata>) = viewModelScope.launch {
        _liveData.value = userList
        _liveData.postValue(userList)
    }

}