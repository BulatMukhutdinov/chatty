package ru.bulat.mukhutdinov.chatty.domain

import ru.bulat.mukhutdinov.chatty.domain.entity.ContactEntity
import javax.inject.Inject

class ContactInteractor @Inject constructor(private val contactRepository: ContactRepository) {

    fun contacts(): List<ContactEntity> = contactRepository.contacts()
}