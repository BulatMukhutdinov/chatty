package ru.bulat.mukhutdinov.chatty.presentation.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.bulat.mukhutdinov.chatty.data.ContactRepositoryImpl
import ru.bulat.mukhutdinov.chatty.domain.ContactInteractor
import ru.bulat.mukhutdinov.chatty.domain.ContactRepository
import ru.bulat.mukhutdinov.chatty.presentation.App
import ru.bulat.mukhutdinov.chatty.presentation.module.main.contact.ContactPresenterImpl
import ru.bulat.mukhutdinov.chatty.presentation.module.main.contact.contract.ContactPresenter
import ru.bulat.mukhutdinov.chatty.presentation.module.main.contactfeed.ContactFeedPresenterImpl
import ru.bulat.mukhutdinov.chatty.presentation.module.main.contactfeed.contract.ContactFeedPresenter
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: App) {

    @Provides
    @Singleton
    @ForApplication
    fun provideApplicationContext(): Context {
        return application
    }

    @Provides
    fun provideContactFeedPresenter(interactor: ContactInteractor): ContactFeedPresenter {
        return ContactFeedPresenterImpl(interactor)
    }

    @Provides
    fun provideContactPresenter(interactor: ContactInteractor): ContactPresenter {
        return ContactPresenterImpl(interactor)
    }

    @Provides
    @Singleton
    fun provideContactRepository(repository: ContactRepositoryImpl): ContactRepository {
        return repository
    }
}