package com.example.alias.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.alias.data.GameRepositoryImpl
import com.example.alias.domain.*

class TeamListViewModel : ViewModel() {
    private var repository = GameRepositoryImpl

    private val addTeamUseCase = AddTeamUseCase(repository)
    private val deleteTeamUseCase = DeleteTeamUseCase(repository)
    private val editTeamNameUseCase = EditTeamNameUseCase(repository)
    private val getTeamListUseCase = GetTeamListUseCase(repository)

    val teamList = getTeamListUseCase.getTeamList()

    fun deleteTeam(team: Team) {
        deleteTeamUseCase.deleteTeam(team)
    }

    fun addTeam(team: Team) {
        addTeamUseCase.addTeam(team)
    }

    fun editTeamName(team: Team) {
        editTeamNameUseCase.editTeamName(team)
    }
}