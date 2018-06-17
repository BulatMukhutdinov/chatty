package ru.bulat.mukhutdinov.chatty.presentation.util

import ru.bulat.mukhutdinov.chatty.domain.entity.ContactEntity

interface OnContactClickListener {

    fun onClick(contact: ContactEntity)
}