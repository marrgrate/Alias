package com.example.alias.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.alias.data.GameRepositoryImpl
import com.example.alias.domain.AddTeamUseCase
import com.example.alias.domain.GuessWordUseCase
import com.example.alias.domain.SkipWordUseCase
import com.example.alias.domain.Team

class GameProcessViewModel : ViewModel() {
    private var repository = GameRepositoryImpl

    private val skipWordUseCase = SkipWordUseCase(repository)
    private val guessWordUseCase = GuessWordUseCase(repository)

    fun skipWord(word: String) {
        skipWordUseCase.skipWord(word)
    }

    fun guessWord(word: String) {
        guessWordUseCase.guessWord(word)
    }

}