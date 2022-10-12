package com.fyilmaz.template.core.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fyilmaz.template.core.data.dto.login.LoginResponse
import com.fyilmaz.template.core.data.local.room.dao.UserDao

@Database(entities = [LoginResponse::class], version = 5)
abstract class AppDatabase : RoomDatabase() {
    abstract fun UserDao(): UserDao
}
