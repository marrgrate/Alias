package com.example.alias.domain.usecases

import com.example.alias.domain.repository.GameRepository

class SkipWordUseCase(private val gameRepository: GameRepository) {

    fun skipWord(word: String) {
        return gameRepository.skipWord(word)
    }
}