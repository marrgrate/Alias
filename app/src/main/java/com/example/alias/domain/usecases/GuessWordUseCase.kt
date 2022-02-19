package com.example.alias.domain.usecases

import com.example.alias.domain.repository.GameRepository
import com.example.alias.domain.entities.Team

class GuessWordUseCase(private val gameRepository: GameRepository) {

    fun guessWord(word: String, team: Team) {
        return gameRepository.guessWord(word, team)
    }
}