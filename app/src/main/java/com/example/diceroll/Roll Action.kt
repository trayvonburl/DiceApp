package com.example.diceroll

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rolls")
data class Roll(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val value: Int,
    val timestamp: Long = System.currentTimeMillis()
)