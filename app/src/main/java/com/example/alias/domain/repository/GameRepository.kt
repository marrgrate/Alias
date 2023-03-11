package com.example.alias.domain.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.alias.domain.entities.Team

interface GameRepository {

    fun changeDictionary(dictionary:  Int)

    fun changeWinScore(score: Int)

    fun createGame()

    fun guessWord(word: String, team: Team)

    fun skipWord(word: String)

    fun closeGame()

    fun getUsedWordsList() : LiveData<List<String>>

    fun getDictionaries() : List<String>

    suspend fun parseDictionariesName(context: Context)

    fun parseWords(context: Context)

    fun getWords() : List<String>
}