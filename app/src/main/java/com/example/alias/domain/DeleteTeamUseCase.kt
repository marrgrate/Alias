package com.example.alias.domain

class DeleteTeamUseCase(private val gameRepository: GameRepository) {

    fun deleteTeam(team: Team) {
        return gameRepository.deleteTeam(team)
    }
}