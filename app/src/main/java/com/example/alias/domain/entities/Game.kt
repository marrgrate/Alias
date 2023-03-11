package com.example.alias.domain.entities

import android.content.Context
import android.content.SharedPreferences

class  Game {
    var guessedWordCounter: Int = 0
    var dictionary: Int = 0
    var usedWords: List<String> = mutableListOf()
    var winner: String = ""

    companion object {
        const val GAME_CONF = "gameconf"
        const val GAME_CONF_TIME = "time"
        const val GAME_CONF_GUESSES_TO_WIN = "winscore"
        const val GAME_CONF_FIRST_LAUNCH = "firstlaunch"

    }
}

fun initConfig(context: Context) {
    val preferences = context.getSharedPreferences(Game.GAME_CONF, Context.MODE_PRIVATE)
    val firstLaunch = preferences.getBoolean("firstlaunch", false)

    if (firstLaunch) {
        val editor = preferences.edit()
        editor.putLong(Game.GAME_CONF_TIME, 60000)
        editor.putInt(Game.GAME_CONF_GUESSES_TO_WIN, 5)
        editor.putBoolean(Game.GAME_CONF_FIRST_LAUNCH, false)
        editor.apply()
    }
}

