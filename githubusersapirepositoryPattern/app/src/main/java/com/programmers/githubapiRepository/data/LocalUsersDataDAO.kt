package com.programmers.githubapiRepository.data

import androidx.room.*
import androidx.room.OnConflictStrategy.Companion.REPLACE

@Dao
interface LocalUsersDataDAO {

    // REPLACE = 이전 데이터를 제거 하고 새로운 데이터로 변경 ( 중복 방지 )
    @Insert(onConflict = REPLACE)
    suspend fun insert(user: UsersData)

    @Query("SELECT * FROM LOCALUSERSDATE")
    suspend fun getAllUsers(): MutableList<UsersData>

    @Update
    suspend fun updateUser(user : UsersData)

    @Query("SELECT * FROM LOCALUSERSDATE WHERE search = :search")
    suspend fun getUser(search: String): MutableList<UsersData>

//    @Query("SELECT * FROM LOCALUSERSDATE WHERE favorite = :favorite")
//    suspend fun isfavorite(): MutableList<UsersData>
}