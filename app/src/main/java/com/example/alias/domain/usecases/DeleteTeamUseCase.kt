package com.example.alias.domain.usecases

import com.example.alias.domain.repository.GameRepository
import com.example.alias.domain.entities.Team

class DeleteTeamUseCase(private val gameRepository: GameRepository) {

    fun deleteTeam(team: Team) {
        return gameRepository.deleteTeam(team)
    }
}