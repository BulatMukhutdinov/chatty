package ru.bulat.mukhutdinov.chatty.presentation.module.main.contact

import ru.bulat.mukhutdinov.chatty.domain.ContactInteractor
import ru.bulat.mukhutdinov.chatty.presentation.module.base.BasePresenterImpl
import ru.bulat.mukhutdinov.chatty.presentation.module.main.MainRouter
import ru.bulat.mukhutdinov.chatty.presentation.module.main.contact.contract.ContactPresenter
import ru.bulat.mukhutdinov.chatty.presentation.module.main.contact.contract.ContactView
import javax.inject.Inject

class ContactPresenterImpl @Inject constructor(private val contactInteractor: ContactInteractor) : BasePresenterImpl<ContactView, MainRouter>(), ContactPresenter {

    override fun onActivityCreated() {

    }
}