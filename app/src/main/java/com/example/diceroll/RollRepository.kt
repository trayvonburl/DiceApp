package com.example.diceroll

import androidx.lifecycle.LiveData

class RollRepository(private val dao: RollDao) {
    fun getAll(): LiveData<List<Roll>> = dao.getAll()
    suspend fun insert(roll: Roll) = dao.insert(roll)
    suspend fun clear() = dao.clear()
}