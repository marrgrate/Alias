package com.example.alias.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.alias.R
import com.example.alias.databinding.ActivityMainBinding
import com.example.alias.presentation.contracts.Navigator
import com.example.alias.presentation.fragments.*

private lateinit var binding: ActivityMainBinding

class MenuActivity : AppCompatActivity(), Navigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        if (savedInstanceState == null) {
            launchFragment(StartMenuFragment())
        }
    }

    private fun launchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(binding.menuContainer.id, fragment)
            .commit()
    }

    override fun goBack() {
        onBackPressed()
    }

    override fun goToMenu() {
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    override fun showStartMenuScreen() {
        launchFragment(StartMenuFragment())
    }

    override fun showModeMenuScreen() {
        launchFragment(ModeMenuFragment())
    }

    override fun showOnlineOptionScreen() {
        TODO()
    }

    override fun showTeamListScreen() {
        launchFragment(TeamListFragment())
    }

    override fun showConfigScreen() {
        launchFragment(ConfigFragment())
    }

    override fun showDictionariesScreen() {
        launchFragment(DictionariesFragment())
    }

    override fun showRulesScreen() {
        launchFragment(RulesFragment())
    }

    override fun showGameProcessScreen() {
        launchFragment(GameProcessFragment())
    }

    override fun showGameFinishScreen() {
        launchFragment(GameFinishFragment())
    }

    override fun showResultScreen() {
        launchFragment(ResultFragment())
    }
}