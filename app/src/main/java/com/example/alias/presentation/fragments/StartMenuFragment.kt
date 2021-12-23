package com.example.alias.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.alias.databinding.FragmentStartMenuBinding
import com.example.alias.presentation.contracts.navigator
import com.example.alias.presentation.viewmodels.StartMenuViewModel


class StartMenuFragment : Fragment() {
    private lateinit var viewModel: StartMenuViewModel
    private lateinit var binding: FragmentStartMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartMenuBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[StartMenuViewModel::class.java]

        setupOnClickListeners()
    }

    private fun setupOnClickListeners() {
        onExitPressed()
        onRulesPressed()
        onSettingsPressed()
        onStartPressed()
    }

    private fun onStartPressed() {
        binding.buttonStart.setOnClickListener { navigator().showModeMenuScreen() }
    }

    private fun onRulesPressed() {
        binding.buttonRules.setOnClickListener { navigator().showRulesScreen() }
    }

    private fun onSettingsPressed() {
        binding.buttonSettings.setOnClickListener { navigator().showConfigScreen() }
    }

    private fun onExitPressed() {
        binding.buttonExit.setOnClickListener { navigator().goBack() }
    }
}