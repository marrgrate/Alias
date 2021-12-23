package com.example.alias.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.alias.R
import com.example.alias.databinding.FragmentConfigBinding
import com.example.alias.presentation.contracts.HasCustomTitle
import com.example.alias.presentation.contracts.navigator

class ConfigFragment : Fragment(), HasCustomTitle {
    private lateinit var binding: FragmentConfigBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentConfigBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onConfirmConfigPressed()
    }

    override fun getTitleRes(): Int = R.string.config_title

    fun onConfirmConfigPressed() {
        binding.buttonConfirmConfig.setOnClickListener { navigator().showDictionariesScreen() }
    }
}