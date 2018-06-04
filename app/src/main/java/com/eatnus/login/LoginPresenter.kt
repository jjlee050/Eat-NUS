package com.eatnus.login

import android.support.annotation.NonNull
import java.util.*

class LoginPresenter : LoginContract.Presenter {

    private lateinit var mLoginView : LoginContract.View

    fun TasksPresenter(){
        mLoginView.setPresenter(this)
    }

    override fun start() {
    }

    override fun checkTypeOfUser(name: Optional<String>) {
        //name.map( val x! => x)
        //Check prefix
    }
}