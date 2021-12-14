package com.example.alias.domain

data class Game(
    var teamList: List<Team>,
    val playtime: Int,
    var guessedWordCounter: Int,
    var dictionary: Int
) {
    companion object {
        const val DEFAULT_PLAYTIME = 60
        const val DEFAULT_WIN_SCORE = 20
        const val MAX_WIN_SCORE = 70
        const val MAX_PLAYTIME = 120
    }
}


