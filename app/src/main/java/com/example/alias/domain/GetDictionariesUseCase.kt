package com.example.alias.domain

class GetDictionariesUseCase(private val gameRepository: GameRepository) {

    fun getDictionaries() : List<String> {
        return gameRepository.getDictionaries()
    }
}