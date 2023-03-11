package com.example.alias.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.alias.databinding.FragmentGameFinishBinding
import com.example.alias.domain.entities.Game
import com.example.alias.presentation.contracts.navigator
import java.lang.RuntimeException

class GameFinishFragment : Fragment() {
    private var _binding: FragmentGameFinishBinding? = null
    private val binding: FragmentGameFinishBinding
        get() = _binding ?: throw RuntimeException("FragmentDictionariesBinding == null!")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameFinishBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onPlayAgainPressed()
        //binding.winnerTitle.text = Game.winner
    }

    private fun onPlayAgainPressed() {
        binding.buttonBackToMenu.setOnClickListener { navigator().showStartMenuScreen() }
    }
}