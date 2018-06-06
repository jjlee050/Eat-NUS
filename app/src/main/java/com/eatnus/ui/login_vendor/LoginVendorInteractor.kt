package com.eatnus.ui.login_vendor

import android.text.TextUtils

class LoginVendorInteractor: LoginVendorContract.Interactor{
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