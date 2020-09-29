package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SharedViewModel: ViewModel() {

    var listOfPlayers = mutableListOf<Player>()
    var lopSortedByPoints = mutableListOf<Player>()

    var currentFragmentPos= MutableLiveData<Int>().apply {
        value = 0
    }

    var playerCount = MutableLiveData<Int>().apply {
        value = 0
    }
    var amountOfRounds = MutableLiveData<Int>().apply {
        value = 3
    }

    fun updateFragmentPos(){
        currentFragmentPos.increaseBy(1)
    }

    fun updatePlayerCount(i: Int) = viewModelScope.launch {
        playerCount.putValue(i)
    }

    fun addPlayerToList(player: Player){
        listOfPlayers.add(player)
    }

    fun sorted() = viewModelScope.launch {
         lopSortedByPoints = listOfPlayers.sortedByDescending { player -> player.sumPointsFromListPair()}.toMutableList()
    }


}

private fun MutableLiveData<Int>.increaseBy(i: Int) {
    this.postValue(this.value?.plus(i))
}
private fun MutableLiveData<Int>.putValue(i: Int) {
    this.value = i
}

