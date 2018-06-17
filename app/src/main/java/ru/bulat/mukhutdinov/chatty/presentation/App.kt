package ru.bulat.mukhutdinov.chatty.presentation

import android.app.Application
import ru.bulat.mukhutdinov.chatty.presentation.di.ApplicationComponent
import ru.bulat.mukhutdinov.chatty.presentation.di.ApplicationModule
import ru.bulat.mukhutdinov.chatty.presentation.di.DaggerApplicationComponent

class App : Application() {

    companion object Instance {
        lateinit var instance: App
            private set
    }

    val component: ApplicationComponent = initDaggerComponent()

    override fun onCreate() {
        super.onCreate()

        instance = this
    }

    private fun initDaggerComponent(): ApplicationComponent {
        return DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
    }
}