package ru.bulat.mukhutdinov.chatty.presentation.di

import dagger.Component
import ru.bulat.mukhutdinov.chatty.presentation.module.main.contact.ContactFragment
import ru.bulat.mukhutdinov.chatty.presentation.module.main.contactfeed.ContactFeedFeedFragment
import javax.inject.Singleton


@Singleton
@Component(modules = [(ApplicationModule::class)])
interface ApplicationComponent {

    fun inject(fragment: ContactFeedFeedFragment)

    fun inject(fragment: ContactFragment)
}