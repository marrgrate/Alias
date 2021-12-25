package com.example.alias.domain

import android.content.Context
import androidx.lifecycle.LiveData

interface GameRepository {
    fun addTeam(team: Team)

    fun deleteTeam(team: Team)

    fun changeDictionary(dictionary:  Int)

    fun changeWinScore(score: Int)

    fun createGame()

    fun guessWord(word: String, team: Team)

    fun skipWord(word: String)

    fun editTeamName(team: Team)

    fun getTeamList() : LiveData<List<Team>>

    fun closeGame()

    fun getUsedWordsList() : LiveData<List<String>>

    fun getDictionaries() : List<String>

    suspend fun parseDictionariesName(context: Context)

    fun parseWords(context: Context)

    fun getWords() : List<String>
}