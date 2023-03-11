package com.example.alias.domain.usecases

import com.example.alias.domain.entities.Team
import com.example.alias.domain.repository.TeamRepository

class DeleteTeamUseCase(private val gameRepository: TeamRepository) {

    fun deleteTeam(team: Team) {
        return gameRepository.deleteTeam(team)
    }
}