package com.example.alias.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alias.R
import com.example.alias.databinding.FragmentDictionariesBinding
import com.example.alias.presentation.adapters.DictionariesAdapter
import com.example.alias.presentation.contracts.HasCustomTitle
import com.example.alias.presentation.contracts.navigator
import com.example.alias.presentation.viewmodels.DictionariesViewModel

class DictionariesFragment : Fragment(), HasCustomTitle {
    private lateinit var binding: FragmentDictionariesBinding
    private lateinit var viewModel: DictionariesViewModel
    private lateinit var dictionariesAdapter: DictionariesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDictionariesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[DictionariesViewModel::class.java]

        setupRecyclerView()
        onNextPressed()
    }

    override fun getTitleRes(): Int = R.string.dictionaries_title

    private fun setupRecyclerView() {
        with(binding.dictionariesList) {
            dictionariesAdapter = DictionariesAdapter(viewModel.dictionaries)
            adapter = dictionariesAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun onNextPressed() {
        binding.buttonNextDictionaries.setOnClickListener { navigator().showPauseGameProcessFragment() }
    }
}