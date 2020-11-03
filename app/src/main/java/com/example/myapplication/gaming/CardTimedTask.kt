package com.example.myapplication.gaming

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CardTimeTaskTable")
data class CardTimedTask(

    @PrimaryKey(autoGenerate = true) val uid: Int? = 0,

    var task: String = "",
    var consequence: String = "",
    var seconds: Long = 0,
)
