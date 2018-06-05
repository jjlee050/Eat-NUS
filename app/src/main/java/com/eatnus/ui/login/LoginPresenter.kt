package com.eatnus.ui.login

class LoginPresenter (var mLoginView: LoginContract.View): LoginContract.Presenter, LoginContract.Interactor.OnLoginFinishedListener {
    private var loginView: LoginContract.View = mLoginView
    private var loginInteractor: LoginInteractor = LoginInteractor()

    override fun login(name: String, password: String) {
        loginInteractor.login(name, password, this)
    }
    override fun onEmptyUsernameError() {
        loginView.showLoginError("Please enter a username.")
    }

    override fun onEmptyPasswordError() {
        loginView.showLoginError("Please enter a password.")
    }

    override fun onPrefixError(){
        loginView.showLoginError("Invalid prefix. Please enter a valid prefix (e.g. nusstu, nusstf, stall name)")
    }

    override fun onUserNameError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPasswordError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSuccess() {
        //This will not be shown.
        loginView.showLoginError("Success")
    }

}