package cn.xiaosuli.bookmall.database

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM user WHERE username = :username and password = :password")
    fun findOne(username: String, password: String): Flow<User?>

    @Query("insert into user(username,password) values(:username,:password)")
    fun insert(username: String, password: String)
}