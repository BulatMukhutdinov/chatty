package ru.bulat.mukhutdinov.chatty.presentation.module.main.contactfeed

import ru.bulat.mukhutdinov.chatty.domain.ContactInteractor
import ru.bulat.mukhutdinov.chatty.domain.entity.ContactEntity
import ru.bulat.mukhutdinov.chatty.presentation.module.base.BasePresenterImpl
import ru.bulat.mukhutdinov.chatty.presentation.module.main.MainRouter
import ru.bulat.mukhutdinov.chatty.presentation.module.main.contactfeed.contract.ContactFeedPresenter
import ru.bulat.mukhutdinov.chatty.presentation.module.main.contactfeed.contract.ContactFeedView
import javax.inject.Inject

class ContactFeedPresenterImpl @Inject constructor(private val contactInteractor: ContactInteractor)
    : BasePresenterImpl<ContactFeedView, MainRouter>(), ContactFeedPresenter {

    override fun onActivityCreated() {
        view?.showContacts(contactInteractor.contacts())
    }

    override fun onClick(contact: ContactEntity) {
        router?.showContact(contact)
    }
}