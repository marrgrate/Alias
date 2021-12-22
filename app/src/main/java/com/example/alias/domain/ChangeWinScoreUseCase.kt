package com.example.alias.domain

class ChangeWinScoreUseCase(private val gameRepository: GameRepository) {

    fun changeWinScore(score: Int) {
        gameRepository.changeWinScore(score)
    }
}