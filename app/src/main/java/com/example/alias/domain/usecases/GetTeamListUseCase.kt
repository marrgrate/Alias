package com.example.alias.domain.usecases

import androidx.lifecycle.LiveData
import com.example.alias.domain.repository.GameRepository
import com.example.alias.domain.entities.Team

class GetTeamListUseCase(private val gameRepository: GameRepository) {

    fun getTeamList() : LiveData<List<Team>> {
        return gameRepository.getTeamList()
    }
}