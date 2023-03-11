package com.example.alias.domain.repository

import androidx.lifecycle.LiveData
import com.example.alias.domain.entities.Team

interface TeamRepository {

    fun addTeam(team: Team)

    fun deleteTeam(team: Team)

    fun editTeamName(team: Team)

    fun getTeamList() : LiveData<List<Team>>
}