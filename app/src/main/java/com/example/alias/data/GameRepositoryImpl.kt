package com.example.alias.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.alias.domain.entities.Game
import com.example.alias.domain.repository.GameRepository
import com.example.alias.domain.entities.Team
import org.json.JSONObject
import java.io.IOException

class GameRepositoryImpl : GameRepository {
    private var usedWordsList = mutableListOf<String>()
    private var usedWordsListLD = MutableLiveData<List<String>>()

    private var dictionaries = mutableListOf<String>()
    private var gameWords = mutableListOf<String>()

    private val game: Game = Game()

    override fun changeDictionary(dictionary: Int) {
        game.dictionary = dictionary
    }

    override fun changeWinScore(score: Int) {
       // game.winScore = score
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
        /*game.reset()
        usedWordsList.clear()
        teamList.clear()
        updateUsedWordsList()
        updateTeamList()*/
    }

    private fun updateUsedWordsList() {
        usedWordsListLD.value = usedWordsList.toList()
    }
}