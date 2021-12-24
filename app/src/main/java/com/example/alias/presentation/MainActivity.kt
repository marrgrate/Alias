package com.example.alias.presentation


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

import com.example.alias.databinding.ActivityMainBinding
import com.example.alias.presentation.contracts.HasCustomTitle
import com.example.alias.presentation.contracts.Navigator

import com.example.alias.presentation.fragments.*



class MenuActivity : AppCompatActivity(), Navigator {
    private lateinit var binding: ActivityMainBinding

    private val currentFragment: Fragment
        get() = supportFragmentManager.findFragmentById(binding.menuContainer.id)!!

    private val fragmentListener     = object : FragmentManager.FragmentLifecycleCallbacks() {
        override fun onFragmentViewCreated(
            fm: FragmentManager,
            f: Fragment,
            v: View,
            savedInstanceState: Bundle?
        ) {
            super.onFragmentViewCreated(fm, f, v, savedInstanceState)

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        if (savedInstanceState == null) {
            launchFragment(StartMenuFragment())
        }


        supportFragmentManager.registerFragmentLifecycleCallbacks(fragmentListener, false)
    }

    override fun onDestroy() {
        super.onDestroy()
        supportFragmentManager.unregisterFragmentLifecycleCallbacks(fragmentListener)
    }

    private fun launchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(binding.menuContainer.id, fragment)
            .commit()

        updateUI()
    }

    private fun updateUI() {
        var fragment = currentFragment

        if (fragment is HasCustomTitle) {
            binding.toolbar.toolbar.title = getString(fragment.getTitleRes())
        } else {
            binding.toolbar.toolbar.visibility = View.GONE
        }

        if (supportFragmentManager.backStackEntryCount > 0) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
        } else {
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
            supportActionBar?.setDisplayShowHomeEnabled(false)
        }

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