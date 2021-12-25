package com.example.alias.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.alias.databinding.FragmentGameFinishBinding
import com.example.alias.presentation.contracts.navigator

class GameFinishFragment : Fragment() {
    private lateinit var binding: FragmentGameFinishBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameFinishBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onAgainPressed()
    }

    private fun onAgainPressed() {
        binding.buttonBackToMenu.setOnClickListener { navigator().showStartMenuScreen() }
    }
}