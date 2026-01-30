package com.example.shift_intensive_cinema

import android.app.Application
import com.example.shift_intensive_cinema.di.cinemaAppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CinemaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CinemaApplication)
            modules(cinemaAppModule)
        }
    }
}
