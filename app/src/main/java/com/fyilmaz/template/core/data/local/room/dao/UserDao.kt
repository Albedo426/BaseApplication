package com.fyilmaz.template.core.data.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.fyilmaz.template.core.data.dto.login.LoginResponse
import com.fyilmaz.template.core.data.local.room.BaseDao

@Dao
abstract class UserDao : BaseDao<LoginResponse>() {
    @Query("SELECT * FROM LoginResponse")
    abstract fun getAll(): List<LoginResponse>
}
