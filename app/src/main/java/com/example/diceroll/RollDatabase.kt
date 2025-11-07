package com.example.diceroll

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Roll::class], version = 1, exportSchema = false)
abstract class RollDatabase : RoomDatabase() {
    abstract fun rollDao(): RollDao

    companion object {
        @Volatile private var INSTANCE: RollDatabase? = null

        fun getInstance(context: Context): RollDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RollDatabase::class.java,
                    "roll_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }