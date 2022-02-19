package com.example.alias.domain.usecases

import com.example.alias.domain.repository.GameRepository
import com.example.alias.domain.entities.Team

class EditTeamNameUseCase(private val gameRepository: GameRepository) {

    fun editTeamName(team: Team) {
        return gameRepository.editTeamName(team)
    }
}