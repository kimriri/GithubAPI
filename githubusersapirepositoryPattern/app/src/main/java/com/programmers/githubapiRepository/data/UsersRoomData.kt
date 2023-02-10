package com.programmers.githubapiRepository.data

import android.content.Context
import androidx.room.Room
import com.programmers.githubapiRepository.data.repository.local.UserDatabase

object UsersRoomData {

    fun localUsersRoomDB(applicationContext: Context): UserDatabase {
        return Room.databaseBuilder(applicationContext, UserDatabase::class.java, "UsersRoomDB").build()
    }

}