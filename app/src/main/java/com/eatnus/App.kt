package com.eatnus

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
//App.kt
/**
 * The main application for the android project.
 *
 * @author Joseph Lee
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        App.context = this
    }

    companion object {

        var context: Context? = null
            private set
    }

}