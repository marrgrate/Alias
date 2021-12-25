package com.example.alias.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.alias.databinding.FragmentOnlineModeBinding
import com.example.alias.presentation.contracts.navigator

class OnlineModeFragment : Fragment() {
    private lateinit var binding: FragmentOnlineModeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentOnlineModeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    fun onCreateGamePressed() {
        binding.buttonCreate.setOnClickListener { //navigator().
        }
    }

    fun onJoinGamePressed() {
        binding.buttonJoin.setOnClickListener {

            //navigator().
        }
    }
}
