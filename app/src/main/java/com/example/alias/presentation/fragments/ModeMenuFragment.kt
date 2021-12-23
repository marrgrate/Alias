package com.example.alias.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.alias.R
import com.example.alias.databinding.FragmentModeMenuBinding
import com.example.alias.databinding.FragmentStartMenuBinding
import com.example.alias.presentation.contracts.HasCustomTitle
import com.example.alias.presentation.contracts.navigator

class ModeMenuFragment : Fragment(), HasCustomTitle {
    private lateinit var binding: FragmentModeMenuBinding

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FragmentModeMenuBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupOnClickListeners()
    }

    override fun getTitleRes(): Int = R.string.mode_title

    private fun setupOnClickListeners() {
        onOfflineModePressed()
        onOnlineModePressed()
    }

    fun onOfflineModePressed() {
        binding.buttonOffline.setOnClickListener { navigator().showTeamListScreen() }
    }

    fun onOnlineModePressed() {
        binding.buttonNetwork.setOnClickListener { navigator().showOnlineOptionScreen() }
    }
}