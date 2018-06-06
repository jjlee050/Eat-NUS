package com.eatnus.ui.login_vendor

interface LoginVendorContract {
    interface View {
        fun showLoginError(msg: String)
    }

    interface Presenter {
        fun login(name: String, password: String)
    }

    interface Interactor {
        interface OnLoginFinishedListener {
            fun onEmptyUsernameError()

            fun onEmptyPasswordError()

            fun onPrefixError()

            fun onUserNameError()

            fun onPasswordError()

            fun onSuccess()
        }

        fun login(name: String, password: String, listener: OnLoginFinishedListener)
    }
}
