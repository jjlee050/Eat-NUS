package com.eatnus.ui.login.customer.contract

import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView

//LoginCustomerContract.kt
/**
 * Contract Interface to enforce for login customer.
 *
 * @author Joseph Lee
 */
interface LoginCustomerContract {
    interface View{
        fun setWebView()
    }
}