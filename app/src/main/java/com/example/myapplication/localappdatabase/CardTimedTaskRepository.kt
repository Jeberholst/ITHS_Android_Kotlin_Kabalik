package com.example.myapplication.localappdatabase

import androidx.annotation.WorkerThread
import com.example.myapplication.gaming.CardTimedTask

class CardTimedTaskRepository(private val timedTaskDao: TimedTaskDao) {

    val allCardTimedTask: List<CardTimedTask> = timedTaskDao.getAll()

    @WorkerThread
    suspend fun insertEntity(cardTimedTask: CardTimedTask) {
        timedTaskDao.insertAll(cardTimedTask)
    }

    @WorkerThread
    suspend fun deleteEntity(cardTimedTask: CardTimedTask) {
        timedTaskDao.delete(cardTimedTask)
    }

    @WorkerThread
    suspend fun updateEntity(cardTimedTask: CardTimedTask) {
        timedTaskDao.update(cardTimedTask)
    }

    @WorkerThread
    suspend fun clearWholeTable() {
        timedTaskDao.clearWholeTable()
    }
}

