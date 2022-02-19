package com.example.alias.domain.usecases

import com.example.alias.domain.repository.GameRepository

class ChangeWinScoreUseCase(private val gameRepository: GameRepository) {

    fun changeWinScore(score: Int) {
        gameRepository.changeWinScore(score)
    }
}