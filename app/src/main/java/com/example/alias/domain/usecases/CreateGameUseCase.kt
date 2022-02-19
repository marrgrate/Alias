package com.example.alias.domain.usecases

import com.example.alias.domain.repository.GameRepository

class CreateGameUseCase(private val gameRepository: GameRepository) {

    fun createGame() {
        return gameRepository.createGame()
    }
}