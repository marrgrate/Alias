package com.example.alias.presentation.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.alias.data.GameRepositoryImpl
import com.example.alias.domain.entities.Game
import com.example.alias.domain.entities.Team
import com.example.alias.domain.usecases.*
import kotlin.random.Random


class GameProcessViewModel : ViewModel() {
    private var repository = GameRepositoryImpl

    private val skipWordUseCase = SkipWordUseCase(repository)
    private val guessWordUseCase = GuessWordUseCase(repository)
    private val parseWordUseCase = ParseWordsUseCase(repository)
    private val getWordsUseCase = GetWordsUseCase(repository)
    private val getTeamListUseCase = GetTeamListUseCase(repository)
    private val closeGameUseCase = CloseGameUseCase(repository)
    private val getGetUsedWordsListUseCase = GetUsedWordsListUseCase(repository)

    var counter = 0
    val winScore = Game.winScore
    private val words = getWordsUseCase.getWords()
    private val teams = getTeamListUseCase.getTeamList()
    val gameTime = Game.playtime
    val currentTeam: Team = nextTeam()


    fun parseWords(context: Context) {
        parseWordUseCase.parseWords(context)
    }

    fun skipWord(word: String) {
        skipWordUseCase.skipWord(word)
    }

    fun guessWord(word: String) {
        guessWordUseCase.guessWord(word, currentTeam)
    }

    fun nextWord(): String {
        return words[Random.nextInt(0, words.size)]
    }

    fun closeGame() {
        closeGameUseCase.closeGame()
    }

    private fun nextTeam(): Team {
        return if (counter < teams.value!!.size) {
            teams.value!![counter]
        } else {
            counter = 0
            teams.value!![counter]
        }
    }

}