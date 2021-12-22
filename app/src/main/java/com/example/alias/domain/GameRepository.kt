package com.example.alias.domain

import androidx.lifecycle.LiveData

interface GameRepository {
    fun addTeam(team: Team)

    fun deleteTeam(team: Team)

    fun changeDictionary(dictionary:  Int)

    fun changeWinScore(score: Int)

    fun createGame()

    fun guessWord(word: String)

    fun skipWord(word: String)

    fun editTeamName(team: Team)

    fun getTeamList() : LiveData<List<Team>>

    fun closeGame()

    fun getUsedWordsList() : LiveData<List<String>>
}