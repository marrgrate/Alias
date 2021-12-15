package com.example.alias.domain

import androidx.lifecycle.LiveData

class GetUsedWordsListUseCase(private val gameRepository: GameRepository) {

    fun getUsedWordsList() : LiveData<List<String>> {
        return gameRepository.getUsedWordsList()
    }
}