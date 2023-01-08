package com.programmers.githubapiRepository.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.*
import com.programmers.githubapiRepository.data.UserResponse
import com.programmers.githubapiRepository.data.UsersData
import com.programmers.githubapiRepository.data.repository.remote.UserListRepository
import kotlinx.coroutines.launch
import retrofit2.Response


class MainViewModel : ViewModel() {

    val liveData = MutableLiveData<MutableList<UsersData>?>()
    private lateinit var _liveSearch: String
     var rquserlist: MutableLiveData<String> = MutableLiveData<String>()

    fun saveSearch(livesearch: String) = viewModelScope.launch {
        _liveSearch = livesearch
        val rqUserList = resultSearch()
        if (rqUserList.isSuccessful && rqUserList.body()?.items?.size != 0) {
            liveData.value = rqUserList.body()?.items!!
            rquserlist.value ="Successful"
        } else {
            rquserlist.value =rqUserList.message()
            Log.e(TAG, rqUserList.message())
        }
    }

    private suspend fun resultSearch(): Response<UserResponse> {
        return UserListRepository().getUser(_liveSearch)

    }

}