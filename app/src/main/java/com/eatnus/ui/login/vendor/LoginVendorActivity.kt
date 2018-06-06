package com.eatnus.ui.login.vendor

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.eatnus.R
import com.eatnus.ui.login.vendor.contract.LoginVendorContract
import com.eatnus.ui.login.vendor.presenter.LoginVendorPresenter
import kotlinx.android.synthetic.main.activity_login_vendor.*

//LoginVendorActivity.kt
/**
 * View Class to handle login vendor activity page.
 *
 * @author Joseph Lee
 */
class LoginVendorActivity : AppCompatActivity(), LoginVendorContract.View, View.OnClickListener {
    private lateinit var loginPresenter: LoginVendorContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_vendor)

        loginPresenter = LoginVendorPresenter(this)
        loginButton.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.loginButton -> {
                loginPresenter.login(usernameEditText.text.toString(), passwordEditText.text.toString())
            }
        }
    }

    /**
     * Centralized method to show login error in a toast.
     */
    override fun showLoginError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}