package com.example.alias.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.alias.data.GameRepositoryImpl
import com.example.alias.domain.GetDictionariesUseCase

class DictionariesViewModel : ViewModel() {
    private var repository = GameRepositoryImpl

    private val getDictionariesUseCase = GetDictionariesUseCase(repository)

    val dictionaries = getDictionariesUseCase.getDictionaries()
}