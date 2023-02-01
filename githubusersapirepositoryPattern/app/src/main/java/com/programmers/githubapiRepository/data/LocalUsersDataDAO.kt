package com.programmers.githubapiRepository.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.programmers.githubapiRepository.data.UsersData

@Dao
interface LocalUsersDataDAO {

    @Insert(onConflict = REPLACE)
    suspend fun insert(user: UsersData)

    @Query("SELECT * FROM LOCALUSERSDATE")
    suspend fun getAllUsers(): MutableList<UsersData>

    @Query("SELECT * FROM LOCALUSERSDATE WHERE login = :login")
    suspend fun getUser(login: String): UsersData
}