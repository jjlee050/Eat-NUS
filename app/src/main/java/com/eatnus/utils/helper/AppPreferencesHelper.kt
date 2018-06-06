package com.eatnus.utils.helper

import android.content.Context
import android.content.SharedPreferences
import com.eatnus.App

//AppPreferencesHelper.kt
/**
 * Helper class to access shared preferences easily.
 *
 * @author Joseph Lee
 */
class AppPreferencesHelper(): PreferencesHelper {
    private val mPrefs: SharedPreferences = App.context!!.getSharedPreferences("preferences", Context.MODE_PRIVATE)
    private val PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"

    /**
     * Retrieve ivle access token in SharedPreferences.
     *
     * @return ivle access token inside shared preferences.
     */
    override fun getAccessToken(): String? {
        return mPrefs?.getString(PREF_KEY_ACCESS_TOKEN, null)
    }

    /**
     * Set ivle access token inside SharedPreferences.
     *
     * @return outcome of putting token inside shared preferences.
     */
    override fun setAccessToken(accessToken: String): Boolean {
        return mPrefs.edit().putString(PREF_KEY_ACCESS_TOKEN, accessToken).commit()
    }
}

