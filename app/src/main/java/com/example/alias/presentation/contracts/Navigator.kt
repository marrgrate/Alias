package com.example.alias.presentation.contracts

import androidx.fragment.app.Fragment

fun Fragment.navigator(): Navigator {
    return requireActivity() as Navigator
}

interface Navigator {

    fun goBack()

    fun goToMenu()

    fun showStartMenuScreen()

    fun showModeMenuScreen()

    fun showOnlineModeScreen()

    fun showTeamListScreen()

    fun showConfigScreen()

    fun showDictionariesScreen()

    fun showRulesScreen()

    fun showGameProcessScreen()

    fun showGameFinishScreen()

    fun showResultScreen()

    fun showGameKeyFragment()



}