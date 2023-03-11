package com.example.alias.presentation.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.alias.data.GameRepositoryImpl

import com.example.alias.domain.usecases.ParseDictionariesNameUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private var repository = GameRepositoryImpl()
}