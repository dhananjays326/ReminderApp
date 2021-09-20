package com.d.reminderapp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ReminderApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ReminderApp)
            modules(
                listOf(
                    viewDI,
                    apiModule

                )
            )
        }
    }
}