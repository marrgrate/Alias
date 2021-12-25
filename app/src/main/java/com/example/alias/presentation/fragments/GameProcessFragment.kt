package com.example.alias.presentation.fragments

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
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
import com.example.alias.domain.Team
import com.example.alias.presentation.contracts.navigator
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
        viewModel.parseWords(context!!)

        binding.teamName.text = viewModel.currentTeam.name
        binding.word.text = viewModel.nextWord()


        runTimer()
        setupOnClickListeners()
    }


    private fun onSkipWordPressed() {
        binding.imageButtonWordSkip.setOnClickListener {
            viewModel.skipWord(binding.word.toString())
            binding.word.text = viewModel.nextWord()
        }
    }

    private fun onGuessWordPressed() {
        binding.imageButtonWordAccept.setOnClickListener {
            viewModel.guessWord(binding.word.toString())
            binding.word.text = viewModel.nextWord()

            checkWinner()
        }
    }

    private fun setupOnClickListeners() {
        onSkipWordPressed()
        onGuessWordPressed()
    }

    private fun runTimer() {
        object : CountDownTimer(viewModel.gameTime, 1000){
            override fun onTick(p0: Long) {

                binding.timer.text = (p0 / 1000).toString()
            }

            override fun onFinish() {
                navigator().showPauseGameProcessFragment()
            }
        }.start()
    }

    private fun checkWinner() {
        if (viewModel.winScore == viewModel.currentTeam.result) {
            navigator().showGameFinishScreen()
        }
    }
}