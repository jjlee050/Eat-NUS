package com.eatnus.login

import android.support.annotation.NonNull
import com.google.common.base.Optional

class LoginPresenter : LoginContract.Presenter {

    private lateinit var mLoginView : LoginContract.View

    fun TasksPresenter(){
        mLoginView.setPresenter(this)
    }

    override fun start() {
    }

    override fun isValidUserPrefix(name: Optional<String>): Boolean {
        if(!name.isPresent){
            return false
        }
        else{
        }
        return true
    }
}