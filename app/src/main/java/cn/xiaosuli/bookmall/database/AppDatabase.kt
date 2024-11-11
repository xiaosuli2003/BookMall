package cn.xiaosuli.bookmall.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cn.xiaosuli.bookmall.App

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private val instance = Room.databaseBuilder(
            App.context,
            AppDatabase::class.java, "book-mall"
        ).build()

        val userDao = instance.userDao()
    }
}