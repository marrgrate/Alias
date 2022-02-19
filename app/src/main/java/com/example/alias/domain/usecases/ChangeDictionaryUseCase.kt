package com.example.alias.domain.usecases

import com.example.alias.domain.repository.GameRepository

class ChangeDictionaryUseCase(private val gameRepository: GameRepository) {

    fun changeDictionary(dictionary: Int) {
        return gameRepository.changeDictionary(dictionary)
    }
}