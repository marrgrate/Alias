package com.example.alias.domain

class SkipWordUseCase(private val gameRepository: GameRepository) {

    fun skipWord(word: String) {
        return gameRepository.skipWord(word)
    }
}