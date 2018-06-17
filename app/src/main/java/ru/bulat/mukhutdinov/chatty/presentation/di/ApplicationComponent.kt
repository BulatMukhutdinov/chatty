package ru.bulat.mukhutdinov.chatty.presentation.di

import dagger.Component
import ru.bulat.mukhutdinov.chatty.presentation.module.main.contact.ContactFragment
import ru.bulat.mukhutdinov.chatty.presentation.module.main.contactfeed.ContactFeedFragment
import javax.inject.Singleton


@Singleton
@Component(modules = [(ApplicationModule::class)])
interface ApplicationComponent {

    fun inject(fragment: ContactFeedFragment)

    fun inject(fragment: ContactFragment)
}