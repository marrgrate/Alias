package com.example.alias.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.alias.R
import com.example.alias.databinding.FragmentGameProcessBinding
import com.example.alias.presentation.viewmodels.GameProcessViewModel

class GameProcessFragment : Fragment() {
    private lateinit var binding: FragmentGameProcessBinding
    private lateinit var viewModel: GameProcessViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameProcessBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[GameProcessViewModel::class.java]
        setupOnClickListeners()
    }

    private fun onStartGamePressed() {
        binding.buttonStartGame.setOnClickListener {
            it.visibility = View.GONE
            binding.imageButtonWordAccept.visibility = View.VISIBLE
            binding.imageButtonWordSkip.visibility = View.VISIBLE
            binding.word.visibility = View.VISIBLE
        }
    }

    private fun onSkipWordPressed() {
        binding.imageButtonWordSkip.setOnClickListener {
            viewModel.skipWord(binding.word.toString())
        }
    }

    private fun onGuessWordPressed() {
        binding.imageButtonWordSkip.setOnClickListener {
            viewModel.guessWord(binding.word.toString())
        }
    }

    private fun setupOnClickListeners() {
        onStartGamePressed()
        onSkipWordPressed()
        onGuessWordPressed()
    }
}