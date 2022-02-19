package com.example.alias.domain.usecases

import com.example.alias.domain.repository.GameRepository

class GetDictionariesUseCase(private val gameRepository: GameRepository) {

    fun getDictionaries() : List<String> {
        return gameRepository.getDictionaries()
    }
}