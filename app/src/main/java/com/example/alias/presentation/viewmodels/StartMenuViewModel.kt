package com.example.alias.presentation.viewmodels

import android.widget.Button
import androidx.lifecycle.ViewModel

class StartMenuViewModel : ViewModel() {
    var onStartClickListener: ((Button) -> Unit)? = null
    var onShowRulesClickListener: ((Button) -> Unit)? = null
    var onExitClickListener: ((Button) -> Unit)? = null


}