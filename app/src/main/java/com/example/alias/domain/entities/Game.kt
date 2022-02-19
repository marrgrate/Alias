package com.example.alias.domain.entities

object  Game {
    var playtime: Long = 60000               //ms
    var guessedWordCounter: Int = 0
    var dictionary: Int = 0
    var usedWords: List<String> = mutableListOf()
    var winScore = 5
}


