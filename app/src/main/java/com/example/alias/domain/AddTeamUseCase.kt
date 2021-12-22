package com.example.alias.domain

class AddTeamUseCase(private val gameRepository: GameRepository) {

    fun addTeam(team: Team) {
        return gameRepository.addTeam(team)
    }
}