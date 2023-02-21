package com.programmers.githubapiRepository.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.programmers.githubapiRepository.data.UsersData
import com.programmers.githubapiRepository.data.UsersRoomData
import com.programmers.githubapiRepository.view.UsersAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {


    private val _userListAll = MutableStateFlow(mutableListOf<UsersData>())
    val userListAll = _userListAll.asStateFlow()


    private val _userList = MutableStateFlow(mutableListOf<UsersData>())
    val userList = _userList.asStateFlow()

    private val _uiFlow = MutableLiveData<UiFlow>(UiFlow.Init)
    val uiFlow: LiveData<UiFlow> = _uiFlow

    fun  getUserList( context: Context) {
        viewModelScope.launch {
            _userListAll.value = UsersRoomData.localUsersRoomDB(context).localUsersDataDao().getAllUsers()
        }
    }

    fun updateUser(user: UsersData,context : Context){
        viewModelScope.launch(Dispatchers.Main) {
            getUserList(context)
             UsersRoomData.localUsersRoomDB(context).localUsersDataDao().updateUser(user)
          //  _userListAll.value = UsersRoomData.localUsersRoomDB(context).localUsersDataDao().getAllUsers()
            _uiFlow.value = UiFlow.Favorite(user.favorite)

        }
    }


}


sealed class UiFlow {
    object EmptyUserList : UiFlow()
    class Favorite(val  favorite: Boolean) : UiFlow()
    object Init : UiFlow()

}
