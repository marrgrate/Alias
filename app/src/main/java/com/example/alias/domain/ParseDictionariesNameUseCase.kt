package com.example.alias.domain

import android.content.Context

class ParseDictionariesNameUseCase(private val gameRepository: GameRepository) {

    suspend fun parseDictionariesName(context: Context) {
        gameRepository.parseDictionariesName(context)
    }
}