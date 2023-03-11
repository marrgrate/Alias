package com.example.alias.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.alias.domain.entities.Team
import com.example.alias.domain.repository.TeamRepository

class TeamRepositoryImpl : TeamRepository {
    private var teamList = mutableListOf<Team>()
    private var teamListLD = MutableLiveData<List<Team>>()

    init {
        for (i in 0..1) {
            val team = Team("Каманда $i", 0)
            addTeam(team)
        }
    }

    override fun getTeamList(): LiveData<List<Team>> {
        return teamListLD
    }

    override fun addTeam(team: Team) {
        teamList.add(team)

        updateTeamList()

        Log.i("TEAM_COUNT", getTeamList().value?.size.toString())
    }

    override fun deleteTeam(team: Team) {
        teamList.remove(team)

        updateTeamList()
    }

    override fun editTeamName(team: Team) {
        TODO()
    }

    private fun updateTeamList() {
        teamListLD.value = teamList.toList()
    }
}
