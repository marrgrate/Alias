package com.example.alias.domain.usecases

import com.example.alias.domain.repository.GameRepository

class CloseGameUseCase(private val gameRepository: GameRepository) {

    fun closeGame() {
        return gameRepository.closeGame()
    }
}