package com.example.myapplication.localappdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.gaming.CardTimedTask

@Database(entities = [CardTimedTask::class], version = 2)
abstract class LocalAppDataBase : RoomDatabase() {

    abstract fun timedTaskDao(): TimedTaskDao

    companion object {

        @Volatile
        private var INSTANCE: LocalAppDataBase? = null

        fun getDatabase(context: Context): LocalAppDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LocalAppDataBase::class.java,
                    "localapp.db")
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }

    }

}