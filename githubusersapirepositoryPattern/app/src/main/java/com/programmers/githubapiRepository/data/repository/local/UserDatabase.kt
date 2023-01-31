package com.programmers.githubapiRepository.data.repository.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LocalUsersData::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun localUsersDataDao(): LocalUsersDataDAO
}