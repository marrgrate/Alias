package com.example.alias.domain

class CloseGameUseCase(private val gameRepository: GameRepository) {

    fun closeGame() {
        return gameRepository.closeGame()
    }
}