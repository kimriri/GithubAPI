package com.programmers.githubapiRepository.data.repository.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query

@Dao
interface LocalUsersDataDAO {

    @Insert(onConflict = REPLACE)
    suspend fun insert(user: LocalUsersData)

    @Query("SELECT * FROM LOCALUSERSDATE WHERE login = :login")
    suspend fun getUser(login: String): LocalUsersData
}