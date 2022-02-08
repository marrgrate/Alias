package com.example.alias.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.alias.databinding.FragmentModeMenuBinding
import com.example.alias.databinding.FragmentOnlineModeBinding
import com.example.alias.presentation.contracts.navigator
import java.lang.RuntimeException

class OnlineModeFragment : Fragment() {
    private var _binding: FragmentOnlineModeBinding? = null
    private val binding: FragmentOnlineModeBinding
        get() = _binding ?: throw RuntimeException("FragmentOnlineModeBinding == null!")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentOnlineModeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
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
