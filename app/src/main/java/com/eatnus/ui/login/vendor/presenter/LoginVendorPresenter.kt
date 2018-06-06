package com.eatnus.ui.login.vendor.presenter

import com.eatnus.ui.login.vendor.interactor.LoginVendorInteractor
import com.eatnus.ui.login.vendor.contract.LoginVendorContract

//LoginVendorPresenter.kt
/**
 * Presenter class to handle login vendor.
 *
 * @author Joseph Lee
 */
class LoginVendorPresenter(mLoginView: LoginVendorContract.View): LoginVendorContract.Presenter, LoginVendorContract.Interactor.OnLoginFinishedListener {
    private var loginView: LoginVendorContract.View = mLoginView
    private var loginInteractor: LoginVendorContract.Interactor = LoginVendorInteractor()

    /**
     * To pass information to the interactor to handle login.
     */
    override fun login(name: String, password: String) {
        loginInteractor.login(name, password, this)
    }

    /**
     * When username is empty.
     */
    override fun onEmptyUsernameError() {
        loginView.showLoginError("Please enter a username.")
    }

    /**
     * When password is empty.
     */
    override fun onEmptyPasswordError() {
        loginView.showLoginError("Please enter a password.")
    }

    /**
     * When user enter incorrect prefix
     */
    override fun onPrefixError(){
        loginView.showLoginError("Invalid prefix. Please enter a valid prefix (e.g. nusstu, nusstf, stall name)")
    }
    /**
     * When User enter incorrect username.
     */
    override fun onUserNameError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * When User enter incorrect password.
     */
    override fun onPasswordError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * When User login successfully.
     */
    override fun onSuccess() {
        //This will not be shown.
        loginView.showLoginError("Success")
    }

}