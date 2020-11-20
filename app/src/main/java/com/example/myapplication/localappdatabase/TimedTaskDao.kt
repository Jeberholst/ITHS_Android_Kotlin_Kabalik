package com.example.myapplication.localappdatabase

import androidx.room.*
import com.example.myapplication.gaming.CardTimedTask

@Dao
interface TimedTaskDao {

    @Query("SELECT * FROM cardtimedtasktable")
    fun getAll(): List<CardTimedTask>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg cardTimedTask: CardTimedTask)

    @Delete
    fun delete(cardTimedTask: CardTimedTask)

    @Update
    fun update(cardTimedTask: CardTimedTask)

    @Query("DELETE FROM cardtimedtasktable")
    fun clearWholeTable()

    @Query("UPDATE cardtimedtasktable SET uid = 1")
    fun resetPrimaryKey()
}