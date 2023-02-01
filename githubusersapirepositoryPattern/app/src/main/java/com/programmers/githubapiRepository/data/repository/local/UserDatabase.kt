package com.programmers.githubapiRepository.data.repository.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.programmers.githubapiRepository.data.UsersData

@Database(entities = [UsersData::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun localUsersDataDao(): LocalUsersDataDAO
}