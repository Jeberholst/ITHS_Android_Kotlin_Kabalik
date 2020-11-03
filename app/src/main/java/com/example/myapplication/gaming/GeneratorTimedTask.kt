package com.example.myapplication.gaming

import android.content.Context
import android.content.res.Resources
import com.example.myapplication.R
import java.util.*

class GeneratorTimedTask(val context: Context) {

    val res: Resources = context.resources

    val arrayOfColors = res.getStringArray(R.array.RandomTaskArrayOfColors)
    private val arrayOfFeel = res.getStringArray(R.array.RandomTaskArrayOfFeel)
    private val arrayOfShapes = res.getStringArray(R.array.RandomTaskArrayOfShape)
    val listOfListTasks: MutableList<Array<String>> =
        arrayListOf(arrayOfColors, arrayOfFeel, arrayOfShapes)
    private val arrayOfCons = res.getStringArray(R.array.RandomTaskArrayOfCons)

    fun randomListTask(): String {
        val randomList = listOfListTasks.getRandomList()
        val randomTask = randomList.getRandom()

        return StringBuilder().apply {
            append(context.getString(R.string.find_a))
            append(" ")
            append(randomTask?.toUpperCase(Locale.getDefault()))
            append(" ")
            append(context.getString(R.string.thing_return_before_time_over))
            appendLine()
        }.toString()
    }

    fun randomListCon(): String {
        val randomCon = arrayOfCons.getRandom()

        return StringBuilder().apply {
            append(context.getString(R.string.all_players_give))
            append(" ")
            append(randomCon?.toUpperCase(Locale.getDefault()))
            append(" ")
            append(context.getString(R.string.to_those_who_fail))
        }.toString()
    }

}

private fun <T> Array<T>.getRandom(): String? { return this.random() as? String }
private fun MutableList<Array<String>>.getRandomList(): Array<String> { return this.random() }
