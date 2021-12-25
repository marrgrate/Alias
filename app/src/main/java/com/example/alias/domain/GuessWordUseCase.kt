package com.example.alias.domain

class GuessWordUseCase(private val gameRepository: GameRepository) {

    fun guessWord(word: String, team: Team) {
        return gameRepository.guessWord(word, team)
    }
}