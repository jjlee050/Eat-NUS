package com.eatnus.ui.login

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.eatnus.R
import com.eatnus.ui.login.customer.LoginCustomerActivity
import com.eatnus.ui.login.vendor.LoginVendorActivity
import kotlinx.android.synthetic.main.activity_login.*

//LoginActivity.kt
/**
 * View Class to handle login activity page.
 *
 * @author Joseph Lee
 */
class LoginActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginCustomerButton.setOnClickListener(this)
        loginVendorButton.setOnClickListener(this)
    }

    override fun onClick(v: View){
        when(v.id){
            R.id.loginCustomerButton -> {
                val loginCustomerActivity = Intent(this@LoginActivity, LoginCustomerActivity::class.java)
                startActivity(loginCustomerActivity)
                finish()
            }
            R.id.loginVendorButton -> {
                val loginVendorActivity = Intent(this@LoginActivity, LoginVendorActivity::class.java)
                startActivity(loginVendorActivity)
                finish()
            }
        }
    }

}