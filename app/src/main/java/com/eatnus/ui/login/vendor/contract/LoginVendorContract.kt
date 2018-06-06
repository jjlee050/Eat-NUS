package com.eatnus.ui.login.vendor.contract

//LoginVendorContract.kt
/**
 * Contract Interface to enforce for login vendor.
 *
 * @author Joseph Lee
 */
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
