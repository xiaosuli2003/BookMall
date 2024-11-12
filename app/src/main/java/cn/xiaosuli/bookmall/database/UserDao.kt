package cn.xiaosuli.bookmall.database

import androidx.room.Dao
import androidx.room.Query

@Dao
interface UserDao {

    @Query("SELECT * FROM user WHERE username = :username and password = :password")
    suspend fun findOne(username: String, password: String): User?

    @Query("SELECT * FROM user WHERE username = :username")
    suspend fun findOneByUsername(username: String): User?

    @Query("insert into user(username,password,email,phone) values(:username,:password,:email,:phone)")
    suspend fun insert(username: String, password: String, email: String, phone: String): Long
}