package ru.bulat.mukhutdinov.chatty.domain

import ru.bulat.mukhutdinov.chatty.domain.entity.ContactEntity

interface ContactRepository {

    fun contacts(): List<ContactEntity>
}