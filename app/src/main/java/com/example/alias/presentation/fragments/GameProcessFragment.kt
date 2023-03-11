package com.example.alias.presentation.fragments

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.StackView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.alias.databinding.FragmentGameProcessBinding
import com.example.alias.domain.entities.Game
import com.example.alias.presentation.contracts.navigator
import com.example.alias.presentation.viewmodels.GameProcessViewModel
import com.yuyakaido.android.cardstackview.CardStackView
import java.lang.RuntimeException
import java.util.*

class GameProcessFragment : Fragment() {
    private lateinit var viewModel: GameProcessViewModel
    private var _binding: FragmentGameProcessBinding? = null
    private lateinit var stackView: CardStackView
    private val binding: FragmentGameProcessBinding
        get() = _binding ?: throw RuntimeException("FragmentGameProcessBinding == null!")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameProcessBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[GameProcessViewModel::class.java]
        viewModel.parseWords(requireContext())

        stackView = binding.stackView

        binding.teamName.text = viewModel.currentTeam.name




        //runTimer()
        //setupOnClickListeners()
    }

    /*private fun onSkipWordPressed() {
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
    }*/

   /* private fun setupOnClickListeners() {
        onSkipWordPressed()
        onGuessWordPressed()
    }*/

  /*  private fun runTimer() {
        object : CountDownTimer(viewModel.gameTime, 1000){
            override fun onTick(p0: Long) {
                val seconds = (p0 / 1000)
                val minutes = seconds / 60
                val secs = seconds % 60
                binding.timer.text = "$minutes : $secs"
            }

            override fun onFinish() {
                navigator().showPauseGameProcessFragment()
            }
        }.start()
    }

    private fun checkWinner() {
        if (viewModel.winScore == viewModel.currentTeam.result) {
            Game.winner = viewModel.currentTeam.name
            parentFragmentManager.clearBackStack("game")
            viewModel.closeGame()
            navigator().showGameFinishScreen()
        }
    }*/
}