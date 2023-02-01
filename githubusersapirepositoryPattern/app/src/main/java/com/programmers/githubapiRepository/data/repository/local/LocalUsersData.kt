package com.programmers.githubapiRepository.data.repository.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName = "LOCALUSERSDATE")
data class LocalUsersData(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "login") var login: String,
    @ColumnInfo(name = "avatar_url") var avatar_url: String,
) {
    // default 값
    constructor() : this(0, "_", "_")

}