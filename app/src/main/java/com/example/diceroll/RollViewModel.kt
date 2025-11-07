package com.example.diceroll

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RollViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: RollRepository
    val allRolls: LiveData<List<Roll>>

    init {
        val db = RollDatabase.getInstance(application)
        repository = RollRepository(db.rollDao())
        allRolls = repository.getAll()
    }

    fun addRoll(value: Int)
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            repository.insert(Roll(value = value))
        }
    }

    fun clearHistory()
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            repository.clear()
        }
    }
}