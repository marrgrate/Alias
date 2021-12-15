package com.example.alias.domain

import androidx.lifecycle.LiveData

class GetTeamListUseCase(private val gameRepository: GameRepository) {

    fun getTeamList() : LiveData<List<Team>> {
        return gameRepository.getTeamList()
    }
}