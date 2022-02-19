package com.example.alias.domain.usecases

import android.content.Context
import com.example.alias.domain.repository.GameRepository

class ParseDictionariesNameUseCase(private val gameRepository: GameRepository) {

    suspend fun parseDictionariesName(context: Context) {
        gameRepository.parseDictionariesName(context)
    }
}