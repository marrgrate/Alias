package com.example.alias.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.alias.data.GameRepositoryImpl
import com.example.alias.data.TeamRepositoryImpl
import com.example.alias.domain.entities.Team
import com.example.alias.domain.usecases.AddTeamUseCase
import com.example.alias.domain.usecases.DeleteTeamUseCase
import com.example.alias.domain.usecases.EditTeamNameUseCase
import com.example.alias.domain.usecases.GetTeamListUseCase

class TeamListViewModel : ViewModel() {
    private var repository = TeamRepositoryImpl()

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