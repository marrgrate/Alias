package com.example.alias.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.alias.databinding.FragmentPauseGameProcessBinding
import com.example.alias.presentation.contracts.navigator

class PauseGameProcessFragment : Fragment() {
    private lateinit var binding: FragmentPauseGameProcessBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPauseGameProcessBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onStartGamePressed()
    }

    fun onStartGamePressed() {
        binding.buttonStartGame.setOnClickListener { navigator().showGameProcessScreen() }
    }
}