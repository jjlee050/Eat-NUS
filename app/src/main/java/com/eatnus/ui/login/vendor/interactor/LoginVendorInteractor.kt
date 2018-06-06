package com.eatnus.ui.login.vendor.interactor

import android.text.TextUtils
import com.eatnus.ui.login.vendor.contract.LoginVendorContract

//LoginVendorInteractor.kt
/**
 * Interactor class to handle login vendor.
 *
 * @author Joseph Lee
 */
class LoginVendorInteractor: LoginVendorContract.Interactor {

    /**
     * Validate vendor and admin accordingly.
     */
    override fun login(name: String, password: String, listener: LoginVendorContract.Interactor.OnLoginFinishedListener){
        if(TextUtils.isEmpty(name)){
            listener.onEmptyUsernameError()
            return
        }
        if(TextUtils.isEmpty(password)){
            listener.onEmptyPasswordError()
            return
        }
        if((!name.contains("nusstu")) && (!name.contains("nusstf"))){
            //Need to validate stall name and admin
            listener.onPrefixError()
            return
        }
        listener.onSuccess()
    }
}