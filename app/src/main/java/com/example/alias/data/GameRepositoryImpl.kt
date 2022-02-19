package com.example.alias.data


import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.alias.domain.entities.Game
import com.example.alias.domain.repository.GameRepository
import com.example.alias.domain.entities.Team
import org.json.JSONObject
import java.io.IOException

object GameRepositoryImpl : GameRepository {
    private var usedWordsList = mutableListOf<String>()
    private var usedWordsListLD = MutableLiveData<List<String>>()
    private var teamList = mutableListOf<Team>()
    private var teamListLD = MutableLiveData<List<Team>>()
    private var dictionaries = mutableListOf<String>()
    private var gameWords = mutableListOf<String>()

    init {
        for (i in 0..1) {
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

    override fun guessWord(word: String, team: Team) {
        team.result++

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
                    val jsonString: String = manager
                        .open("dictionaries/$file")
                        .bufferedReader()
                        .use { it.readText() }

                    val jsonDictionary = JSONObject(jsonString)
                    val dictionaryName = jsonDictionary.getString("name")

                    dictionaries.add(dictionaryName)
                }
            }

        } catch (e: IOException) {
            throw e
        }
    }

    override fun parseWords(context: Context) {
        val manager = context.assets

        try {
            val listFileNames = manager.list("dictionaries")

            if (listFileNames != null) {
                val jsonString = manager
                    .open("dictionaries/${listFileNames[game.dictionary]}")
                    .bufferedReader()
                    .use { it.readText() }

                val jsonDictionary = JSONObject(jsonString)
                val jsonArray = jsonDictionary.getJSONArray("words")

                for (i: Int in 0 until jsonArray.length()) {
                    gameWords.add(jsonArray.getString(i))
                }
            }
        } catch (e: IOException) {
            throw e
        }
    }

    override fun getWords(): List<String> {
        return gameWords
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