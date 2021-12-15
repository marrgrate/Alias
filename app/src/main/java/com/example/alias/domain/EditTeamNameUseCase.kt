package com.example.alias.domain

class EditTeamNameUseCase(private val gameRepository: GameRepository) {

    fun editTeamName(team: Team) {
        return gameRepository.editTeamName(team)
    }
}