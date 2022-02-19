package com.example.alias.domain.usecases

import androidx.lifecycle.LiveData
import com.example.alias.domain.repository.GameRepository

class GetUsedWordsListUseCase(private val gameRepository: GameRepository) {

    fun getUsedWordsList() : LiveData<List<String>> {
        return gameRepository.getUsedWordsList()
    }
}