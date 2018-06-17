package ru.bulat.mukhutdinov.chatty.presentation.module.main.contactfeed.contract

import ru.bulat.mukhutdinov.chatty.domain.entity.ContactEntity
import ru.bulat.mukhutdinov.chatty.presentation.module.base.BaseView

interface ContactFeedView : BaseView {

    fun showContacts(contacts: List<ContactEntity>)
}