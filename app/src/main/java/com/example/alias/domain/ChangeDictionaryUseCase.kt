package com.example.alias.domain

class ChangeDictionaryUseCase(private val gameRepository: GameRepository) {

    fun changeDictionary(dictionary: Int) {
        return gameRepository.changeDictionary(dictionary)
    }
}