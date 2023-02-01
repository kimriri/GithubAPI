package com.programmers.githubapiRepository.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "LOCALUSERSDATE")
data class UsersData(
       @PrimaryKey(autoGenerate = true) val id: Int,
       @ColumnInfo(name = "login") var login: String,
       @ColumnInfo(name = "avatar_url") var avatar_url: String,
    //   val login : String,
      // val avatar_url : String
)
{
       // default 값
     //  constructor() : this(0,"_", "_")

}