package com.example.alias.domain.usecases

import com.example.alias.domain.repository.GameRepository

class GetWordsUseCase(private val gameRepository: GameRepository) {

    fun getWords() : List<String> {
        return gameRepository.getWords()
    }
}