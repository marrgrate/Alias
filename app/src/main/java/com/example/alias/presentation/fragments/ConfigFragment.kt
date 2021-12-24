package com.example.alias.presentation.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.alias.R
import com.example.alias.databinding.FragmentConfigBinding
import com.example.alias.presentation.contracts.HasCustomTitle
import com.example.alias.presentation.contracts.navigator
import com.example.alias.presentation.viewmodels.ConfigViewModel

class ConfigFragment : Fragment(), HasCustomTitle {
    private lateinit var binding: FragmentConfigBinding
    private lateinit var viewModel : ConfigViewModel


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
        viewModel = ViewModelProvider(this)[ConfigViewModel::class.java]

        onConfirmConfigPressed()

        //win score seekbar touch processing
        val seekBarScore = view.findViewById<SeekBar>(R.id.seekbar_words)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            seekBarScore.min = 10
        }
        val textViewWinScore = view.findViewById<TextView>(R.id.text_view_win_score)
        textViewWinScore.text = seekBarScore.progress.toString()
        seekBarChangeListener(seekBarScore, textViewWinScore)

        //playtime touch processing
        val seekBarTime = view.findViewById<SeekBar>(R.id.seekbar_time)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            seekBarTime.min = 30
        }
        val textViewPlaytime = view.findViewById<TextView>(R.id.text_view_playtime)
        textViewPlaytime.text = seekBarTime.progress.toString()
        seekBarChangeListener(seekBarTime, textViewPlaytime)
    }

    override fun getTitleRes(): Int = R.string.config_title

    private fun onConfirmConfigPressed() {
        binding.buttonConfirmConfig.setOnClickListener { navigator().showDictionariesScreen() }
    }

    private fun seekBarChangeListener(seekBar: SeekBar, textView: TextView) {
        seekBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                viewModel.setWinScore(seek.progress)
                textView.text = seekBar.progress.toString()
            }
        })
    }

}