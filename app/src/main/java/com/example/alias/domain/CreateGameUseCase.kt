package com.example.alias.domain

class CreateGameUseCase(private val gameRepository: GameRepository) {

    fun createGame() {
        return gameRepository.createGame()
    }
}