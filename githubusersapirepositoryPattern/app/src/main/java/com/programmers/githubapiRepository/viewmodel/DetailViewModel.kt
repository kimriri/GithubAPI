package com.programmers.githubapiRepository.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.programmers.githubapiRepository.data.UsersData
import com.programmers.githubapiRepository.data.repository.local.MIGRATION_1_2
import com.programmers.githubapiRepository.data.repository.local.UserDatabase
import com.programmers.githubapiRepository.view.DetailActivity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailViewModel  : ViewModel() {


    private val _userList = MutableStateFlow(UsersData())
    val userList = _userList.asStateFlow()
    private var mContext: Context? = DetailActivity()


    fun getUserIndex(toString: String, context: Context, userName:String) {
        viewModelScope.launch {
            mContext = context
            val db = Room.databaseBuilder(context, UserDatabase::class.java, toString )
                .addMigrations(MIGRATION_1_2)
                .build()
            _userList.value = db.localUsersDataDao().getUser(userName)
        }

    }

    fun userDetailUpdate(usersData: UsersData) {


    }


    sealed class UiFlow{
        object EmptyUserList : UiFlow()
        class ErrorMessage(val throwable : Throwable) : UiFlow()
        object Init : UiFlow()

    }
}