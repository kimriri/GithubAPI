package com.programmers.githubapiRepository.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import com.programmers.githubapiRepository.data.UserResponse
import com.programmers.githubapiRepository.data.UsersData
import com.programmers.githubapiRepository.data.repository.remote.UserListRepository
import kotlinx.coroutines.launch
import retrofit2.Response


class MainViewModel: ViewModel() {

    val _liveData = MutableLiveData<MutableList<UsersData>?>()
    lateinit var _liveSearch : String
    var _rquserList : String = "userList "

    fun saveData(userList: MutableList<UsersData>) {
        _liveData.value = userList
        _liveData.postValue(userList)
    }

    private fun rquserList(rqdata: String) {
        _rquserList = rqdata
    }
    private fun errorMessage(rqdata: String) {
        _rquserList = rqdata
    }
    fun saveSearch(livesearch: String) = viewModelScope.launch {
        _liveSearch = livesearch
            val rqUserList = resultSearch()
            if(rqUserList.isSuccessful)  {
                saveData(rqUserList.body()?.items!!)
                rquserList("Successful")
            }else {
                rquserList("ERROR")
                errorMessage(rqUserList.message())
                Log.e(TAG,rqUserList.message())
            }
    }

     private suspend fun resultSearch(): Response<UserResponse> {
       return UserListRepository().getUser(_liveSearch)

    }

}