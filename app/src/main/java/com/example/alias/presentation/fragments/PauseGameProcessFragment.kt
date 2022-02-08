package com.example.alias.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.alias.databinding.FragmentOnlineModeBinding
import com.example.alias.databinding.FragmentPauseGameProcessBinding
import com.example.alias.presentation.contracts.navigator
import java.lang.RuntimeException

class PauseGameProcessFragment : Fragment() {
    private var _binding: FragmentPauseGameProcessBinding? = null
    private val binding: FragmentPauseGameProcessBinding
        get() = _binding ?: throw RuntimeException("FragmentPauseGameProcessBinding == null!")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPauseGameProcessBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onStartGamePressed()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

    private fun onStartGamePressed() {
        binding.buttonStartGame.setOnClickListener { navigator().showGameProcessScreen() }
    }
}