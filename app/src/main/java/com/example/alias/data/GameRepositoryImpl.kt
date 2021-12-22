package com.example.alias.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.alias.domain.Game
import com.example.alias.domain.GameRepository
import com.example.alias.domain.Team

object GameRepositoryImpl : GameRepository {
    private var usedWordsList = mutableListOf<String>()
    private var usedWordsListLD = MutableLiveData<List<String>>()
    private var teamList = mutableListOf<Team>()
    private var teamListLD = MutableLiveData<List<Team>>()

    private val game: Game = Game

    override fun addTeam(team: Team) {
        if (teamList.map { it.name }.contains(team.name)) {
            teamList.add(team)
        }

        updateTeamList()
    }

    override fun deleteTeam(team: Team) {
        teamList.remove(team)

        updateTeamList()
    }

    override fun editTeamName(team: Team) {
        TODO()
    }

    override fun changeDictionary(dictionary: Int) {
        game.dictionary = dictionary
    }

    override fun changeWinScore(score: Int) {
        game.winScore = score
    }

    override fun createGame() {
        TODO("Not yet implemented")
    }

    override fun guessWord(word: String) {
        game.guessedWordCounter++

        usedWordsList.add(word)
        updateUsedWordsList()
    }

    override fun skipWord(word: String) {
        usedWordsList.add(word)
        updateUsedWordsList()
    }

    override fun getTeamList(): LiveData<List<Team>> {
        return teamListLD
    }

    override fun getUsedWordsList(): LiveData<List<String>> {
        return usedWordsListLD
    }

    override fun closeGame() {
        game.guessedWordCounter = 0
        usedWordsList.clear()
        teamList.clear()
        updateUsedWordsList()
        updateTeamList()
    }

    private fun updateTeamList() {
        teamListLD.value = teamList.toList()
    }

    private fun updateUsedWordsList() {
        usedWordsListLD.value = usedWordsList.toList()
    }


}