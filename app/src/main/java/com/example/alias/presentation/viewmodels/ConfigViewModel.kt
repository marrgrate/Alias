package com.example.alias.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.alias.domain.entities.Game

class ConfigViewModel : ViewModel() {

    fun setWinScore(score: Int) {
        //Game.winScore = score
    }

    fun setPlaytime(time: Long) {
        //Game.playtime = time
    }
}