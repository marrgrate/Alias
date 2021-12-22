package com.example.alias.domain

class GuessWordUseCase(private val gameRepository: GameRepository) {

    fun guessWord(word: String) {
        return gameRepository.guessWord(word)
    }
}