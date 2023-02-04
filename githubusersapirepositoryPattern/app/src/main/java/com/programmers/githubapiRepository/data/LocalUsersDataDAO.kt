package com.programmers.githubapiRepository.data

import androidx.room.*
import androidx.room.OnConflictStrategy.Companion.REPLACE
import com.programmers.githubapiRepository.data.UsersData

@Dao
interface LocalUsersDataDAO {

    // REPLACE = 이전 데이터를 제거 하고 새로운 데이터로 변경 ( 중복 방지 )
    @Insert(onConflict = REPLACE)
    suspend fun insert(user: UsersData)

    @Query("SELECT * FROM LOCALUSERSDATE")
    suspend fun getAllUsers(): MutableList<UsersData>

    @Query("SELECT * FROM LOCALUSERSDATE WHERE login = :login")
    suspend fun getUser(login: String): UsersData
}