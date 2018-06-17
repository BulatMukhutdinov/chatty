package ru.bulat.mukhutdinov.chatty.presentation.module.base

import androidx.lifecycle.LifecycleOwner

interface BaseView : LifecycleOwner {

    fun injectPresenter()
}