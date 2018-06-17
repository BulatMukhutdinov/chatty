package ru.bulat.mukhutdinov.chatty.presentation.module.base


abstract class BasePresenterImpl<View : BaseView, Router : BaseRouter> : BasePresenter<View, Router> {

    override var view: View? = null

    override var router: Router? = null
}