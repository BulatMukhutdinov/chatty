package ru.bulat.mukhutdinov.chatty.presentation.module.base

import androidx.annotation.CallSuper

interface BasePresenter<View, Router> {
    var view: View?

    var router: Router?

    fun onActivityCreated()

    @CallSuper
    fun onDestroyView() {
        view = null
        router = null
    }

}