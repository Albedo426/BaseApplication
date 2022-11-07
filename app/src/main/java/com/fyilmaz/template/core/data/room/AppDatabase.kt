package com.fyilmaz.template.core.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fyilmaz.template.core.data.dto.login.LoginResponse
import com.fyilmaz.template.core.data.room.dao.UserDao

@Database(entities = [LoginResponse::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun UserDao(): UserDao
}
