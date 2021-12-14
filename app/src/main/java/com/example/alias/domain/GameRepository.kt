package com.example.alias.domain

interface GameRepository {
    fun addTeam(team: Team)

    fun deleteTeam(team: Team) : List<Team>

    fun changeDictionary(dictionary:  Int)

    fun changeWinScore()
}