package com.example.alias.domain.usecases

import com.example.alias.domain.repository.GameRepository
import com.example.alias.domain.entities.Team
import com.example.alias.domain.repository.TeamRepository

class EditTeamNameUseCase(private val gameRepository: TeamRepository) {

    fun editTeamName(team: Team) {
        return gameRepository.editTeamName(team)
    }
}