package com.programmers.githubapiRepository.data.repository.local

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.programmers.githubapiRepository.data.LocalUsersDataDAO
import com.programmers.githubapiRepository.data.UsersData

@Database(entities = [UsersData::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun localUsersDataDao(): LocalUsersDataDAO

}



//val MIGRATION_1_2 = object : Migration(1, 2) {
//    override fun migrate(database: SupportSQLiteDatabase) {
//        database.execSQL("ALTER TABLE Book ADD COLUMN favorite BOOLEAN")
//    }
//}