package com.eatnus.ui.login

import android.text.TextUtils

class LoginInteractor: LoginContract.Interactor{
    override fun login(name: String, password: String, listener: LoginContract.Interactor.OnLoginFinishedListener){
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