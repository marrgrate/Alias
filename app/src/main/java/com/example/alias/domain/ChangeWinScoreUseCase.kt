package com.example.alias.domain

class ChangeWinScoreUseCase(private val gameRepository: GameRepository) {

    fun changeWinScore() {
        gameRepository.changeWinScore()
    }
}