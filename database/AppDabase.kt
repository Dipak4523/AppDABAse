package com.app.simpledatabase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(StudentEntity::class), version = 1, exportSchema = false)
abstract class AppDabase:RoomDatabase() {

    abstract fun studentDAO(): StudentDAO
    companion object{

        private var INSTANCE: AppDabase? = null

        fun getDatabase(context: Context): AppDabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}