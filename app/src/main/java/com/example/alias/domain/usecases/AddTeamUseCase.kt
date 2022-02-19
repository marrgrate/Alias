package com.example.alias.domain.usecases

import com.example.alias.domain.repository.GameRepository
import com.example.alias.domain.entities.Team

class AddTeamUseCase(private val gameRepository: GameRepository) {

    fun addTeam(team: Team) {
        return gameRepository.addTeam(team)
    }
}