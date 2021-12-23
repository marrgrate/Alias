package com.example.alias.presentation.contracts

import androidx.annotation.StringRes

interface HasCustomTitle {

    @StringRes
    fun getTitleRes() : Int
}