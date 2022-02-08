package com.example.alias.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.alias.R
import com.example.alias.databinding.FragmentGameProcessBinding
import com.example.alias.databinding.FragmentModeMenuBinding
import com.example.alias.presentation.contracts.HasCustomTitle
import com.example.alias.presentation.contracts.navigator
import java.lang.RuntimeException

class ModeMenuFragment : Fragment(), HasCustomTitle {
    private var _binding: FragmentModeMenuBinding? = null
    private val binding: FragmentModeMenuBinding
        get() = _binding ?: throw RuntimeException("FragmentModeMenuBinding == null!")

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        _binding = FragmentModeMenuBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupOnClickListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

    override fun getTitleRes(): Int = R.string.mode_title

    private fun setupOnClickListeners() {
        onOfflineModePressed()
        onOnlineModePressed()
    }

    private fun onOfflineModePressed() {
        binding.buttonOffline.setOnClickListener { navigator().showTeamListScreen() }
    }

    private fun onOnlineModePressed() {
        binding.buttonNetwork.setOnClickListener { navigator().showOnlineModeScreen() }
    }
}