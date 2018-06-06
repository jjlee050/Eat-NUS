package com.eatnus.utils.helper

//PreferencesHelper.kt
/**
 * Interface for AppPreferencesHelper.
 *
 * @author Joseph Lee
 */
interface PreferencesHelper {

    fun getAccessToken(): String?

    fun setAccessToken(accessToken: String): Boolean?
}
