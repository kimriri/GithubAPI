package com.programmers.githubapimvvm.data.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.*
import com.programmers.githubapimvvm.data.repository.UserResponse
import com.programmers.githubapimvvm.data.repository.UsersData
import com.programmers.githubapimvvm.data.viewmodel.retrofitapi.UsersServiceManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response


class MainViewModel: ViewModel() {

    val _liveData = MutableLiveData<MutableList<UsersData>?>()
    lateinit var _liveSearch : String

    fun saveData(userList: MutableList<UsersData>) {
        _liveData.value = userList
        _liveData.postValue(userList)
    }

    fun saveSearch(livesearch: String) = viewModelScope.launch {
        _liveSearch = livesearch
            val rqUserList = resultSearch()
            if(rqUserList.isSuccessful) {
                saveData(rqUserList.body()?.items!!)
            }else {
                Log.e(TAG,rqUserList.message())
            }
    }

    suspend fun resultSearch(): Response<UserResponse> {
       return UsersServiceManager.getRetrofitService.getUsers(_liveSearch)

    }

}