package ru.bulat.mukhutdinov.chatty.presentation.module.main.contactfeed.contract

import ru.bulat.mukhutdinov.chatty.presentation.module.base.BasePresenter
import ru.bulat.mukhutdinov.chatty.presentation.module.main.MainRouter
import ru.bulat.mukhutdinov.chatty.presentation.util.OnContactClickListener

interface ContactFeedPresenter : BasePresenter<ContactFeedView, MainRouter>, OnContactClickListener