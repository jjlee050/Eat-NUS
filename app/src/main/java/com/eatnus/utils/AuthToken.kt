package com.eatnus.utils

import android.content.Context
import android.content.Context.*
import com.eatnus.App

object AuthToken {

    private val prefs = App.context!!.getSharedPreferences("preferences", Context.MODE_PRIVATE)
    private val editor = prefs.edit()

    val token: String
        get() = prefs.getString("ivleAuthToken", "Error")

    //given String token, saves in SharedPref
    fun setToken(token: String): Boolean {
        editor.putString("ivleAuthToken", token)
        editor.commit()
        return true
    }
}