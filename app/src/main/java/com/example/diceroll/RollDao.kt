package com.example.diceroll

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RollDao {
    @Insert
    suspend fun insert(roll: Roll): Long

    @Query("SELECT * FROM rolls ORDER BY timestamp DESC")
    fun getAll(): LiveData<List<Roll>>

    @Query("DELETE FROM rolls")
    suspend fun clear()
}