package com.example.alias.domain

class GetWordsUseCase(private val gameRepository: GameRepository) {

    fun getWords() : List<String> {
        return gameRepository.getWords()
    }
}