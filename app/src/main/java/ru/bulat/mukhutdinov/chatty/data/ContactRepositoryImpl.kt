package ru.bulat.mukhutdinov.chatty.data

import ru.bulat.mukhutdinov.chatty.data.dto.ContactDto
import ru.bulat.mukhutdinov.chatty.domain.ContactRepository
import ru.bulat.mukhutdinov.chatty.domain.entity.ContactEntity
import javax.inject.Inject

class ContactRepositoryImpl @Inject constructor() : ContactRepository {

    override fun contacts(): List<ContactEntity> {
        val contacts: MutableList<ContactEntity> = mutableListOf()
        for (contact in dummyContacts()) {
            contacts.add(ContactEntity(contact))
        }

        return contacts
    }

    private fun dummyContacts(): List<ContactDto> {
        val dummy: MutableList<ContactDto> = mutableListOf()

        dummy.add(ContactDto("https://api.adorable.io/avatars/80/abow@adoable.png", "Harold", "Sherron", arrayOf("My dog wants banana.")))
        dummy.add(ContactDto("https://api.adorable.io/avatars/80/abos@adoble.png", "Nakisha", "Rousey", arrayOf("Roses are red. Potatoes behave. This makes no sense. Microwave.")))
        dummy.add(ContactDto(null, "Berniece", "Fabela", arrayOf("When can the physiology stick an appeal?")))
        dummy.add(ContactDto("https://api.adorable.io/avatars/80/abo@avdoable.png", "Trinity", "Villanueva", arrayOf("Turn into a pie.")))
        dummy.add(ContactDto("https://api.adorable.io/avatars/80/abo@adeoable.png", "Freeda", "Milling", arrayOf("SHEEP.")))
        dummy.add(ContactDto("", "Shela", "Dorantes", arrayOf("I am a pig. Moo.")))
        dummy.add(ContactDto("https://api.adorable.io/avatars/80/abo@a3doable.png", "Kathey", "Rubel", arrayOf("Put the car in your brothers corn.")))
        dummy.add(ContactDto("https://api.adorable.io/avatars/80/abo@afdoable.png", "Janene", "Rodrigues", arrayOf("Good luck figuring these words out")))
        dummy.add(ContactDto("https://api.adorable.io/avatars/80/abo@agdoable.png", "Kia", "Morra", arrayOf("Remember, extremism in the nondefense of moderation is not a virtue.\" -- Peter Neumann, about usenet ")))
        dummy.add(ContactDto("https://api.adorable.io/avatars/80/abo@adoable.png", "Elsa", "Greb", arrayOf("Come on over here, baby, I want to do a thing with you")))
        dummy.add(ContactDto("https://api.adorable.io/avatars/80/abo@agdoable.png", "Valeria", "Dail", arrayOf("If you don't want your dog to have bad breath, do what I do: Pour a little Lavoris in the toilet.")))
        dummy.add(ContactDto("https://api.adorable.io/avatars/80/abo@a1doable.png", "Randy", "Vickrey", arrayOf("He's dead, Jim.")))

        return dummy
    }
}