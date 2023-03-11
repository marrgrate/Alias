package com.example.alias.domain.usecases

import com.example.alias.domain.entities.Team
import com.example.alias.domain.repository.TeamRepository

class AddTeamUseCase(private val gameRepository: TeamRepository) {

    fun addTeam(team: Team) {
        return gameRepository.addTeam(team)
    }
}