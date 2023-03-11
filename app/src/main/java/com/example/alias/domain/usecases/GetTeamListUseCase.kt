package com.example.alias.domain.usecases

import androidx.lifecycle.LiveData
import com.example.alias.domain.repository.GameRepository
import com.example.alias.domain.entities.Team
import com.example.alias.domain.repository.TeamRepository

class GetTeamListUseCase(private val gameRepository: TeamRepository) {

    fun getTeamList() : LiveData<List<Team>> {
        return gameRepository.getTeamList()
    }
}