package com.programmers.githubapiRepository.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "LOCALUSERSDATE")
data class UsersData(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "search") var search: String,
    @ColumnInfo(name = "login") var login: String,
    @ColumnInfo(name = "avatar_url") var avatar_url: String,
    @ColumnInfo(name = "favorite") var favorite: Boolean,
) {
    // default 값
    constructor() : this(0,"-", "_", "_", false)
}
