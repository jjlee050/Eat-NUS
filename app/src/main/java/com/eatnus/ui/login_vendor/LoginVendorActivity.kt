package com.eatnus.ui.login_vendor

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.eatnus.R
import kotlinx.android.synthetic.main.activity_login_vendor.*


class LoginVendorActivity : AppCompatActivity(), LoginVendorContract.View, View.OnClickListener {
    private lateinit var loginPresenter: LoginVendorPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_vendor)

        loginPresenter = LoginVendorPresenter(this)
        btn_login.setOnClickListener(this)
    }

    override fun showLoginError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_login -> loginPresenter?.login(et_username.text.toString(), et_password.text.toString())
        }
    }

}