package com.example.myapplication.gaming

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cardtimedtasktable")
data class CardTimedTask(

    @PrimaryKey(autoGenerate = true) var uid: Int?,

    @ColumnInfo(name = "task") var task: String? = "",
    @ColumnInfo(name = "consequence") var consequence: String? = "",
    @ColumnInfo(name = "seconds")  var seconds: Long? = 0L,
)
