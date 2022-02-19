package com.example.alias.domain.usecases

import android.content.Context
import com.example.alias.domain.repository.GameRepository

class ParseWordsUseCase(private val gameRepository: GameRepository) {

    fun parseWords(context: Context) {
        return gameRepository.parseWords(context)
    }

}