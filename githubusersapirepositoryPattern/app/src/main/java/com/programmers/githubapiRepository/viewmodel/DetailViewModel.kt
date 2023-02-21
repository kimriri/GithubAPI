package com.programmers.githubapiRepository.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.programmers.githubapiRepository.data.UsersData
import com.programmers.githubapiRepository.data.UsersRoomData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {
    private val _userList = MutableStateFlow(mutableListOf<UsersData>())
    val userList = _userList.asStateFlow()

    fun  getUserIndex(toString: String, context: Context) {
        viewModelScope.launch {
            _userList.value = UsersRoomData.localUsersRoomDB(context).localUsersDataDao().getUserId(toString)
        }

    }

    fun updateUser(user: UsersData,context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            UsersRoomData.localUsersRoomDB(context).localUsersDataDao().updateUser(user)
        }
    }


}


sealed class UiFlow {
    object EmptyUserList : UiFlow()
    class ErrorMessage(val throwable: Throwable) : UiFlow()
    object Init : UiFlow()

}
