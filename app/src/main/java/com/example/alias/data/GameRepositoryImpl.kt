package com.example.alias.data

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.alias.domain.Game
import com.example.alias.domain.GameRepository
import com.example.alias.domain.Team
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.lang.RuntimeException

object GameRepositoryImpl : GameRepository {
    private var usedWordsList = mutableListOf<String>()
    private var usedWordsListLD = MutableLiveData<List<String>>()
    private var teamList = mutableListOf<Team>()
    private var teamListLD = MutableLiveData<List<Team>>()
    private var dictionaries = mutableListOf<String>()

    init {
        for (i in 0..2) {
            val team = Team("Team$i", 0)
            addTeam(team)
        }
    }

    private val game: Game = Game

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

    override fun getDictionaries(): List<String> {
        return dictionaries
    }

    override suspend fun parseDictionariesName(context: Context) {
        val manager = context.assets

        try {
            val listFileNames = manager.list("dictionaries")
            if (listFileNames != null) {
                for (file in listFileNames) {
                    val inputStream: InputStream = manager.open("dictionaries/$file")
                    var jsonString = inputStream.bufferedReader()
                        .use { it.readText() }
                    val jsonDictionary = JSONObject(jsonString)
                    var dictionaryName = jsonDictionary.getString("name")
                    dictionaries.add(dictionaryName)
                }
            }

        } catch (e: IOException) {
            throw e
        }
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