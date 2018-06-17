package ru.bulat.mukhutdinov.chatty.presentation.module.main

import ru.bulat.mukhutdinov.chatty.domain.entity.ContactEntity
import ru.bulat.mukhutdinov.chatty.presentation.module.base.BaseRouter

interface MainRouter : BaseRouter {

    fun showContactFeed()

    fun showContact(contact: ContactEntity)
}