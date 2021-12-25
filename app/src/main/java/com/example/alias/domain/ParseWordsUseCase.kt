package com.example.alias.domain

import android.content.Context

class ParseWordsUseCase(private val gameRepository: GameRepository) {

    fun parseWords(context: Context) {
        return gameRepository.parseWords(context)
    }

}