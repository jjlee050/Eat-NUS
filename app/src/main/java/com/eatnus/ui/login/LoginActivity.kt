package com.eatnus.ui.login

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.eatnus.R
import com.eatnus.ui.login_customer.LoginCustomerActivity
import com.eatnus.ui.login_vendor.LoginVendorActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btn_login_customer.setOnClickListener(this)
        btn_login_vendor.setOnClickListener(this)
    }

    override fun onClick(v: View){
        when(v.id){
            R.id.btn_login_customer -> {
                var loginCustomerActivity = Intent(this@LoginActivity, LoginCustomerActivity::class.java)
                startActivity(loginCustomerActivity)
                finish()
            }
            R.id.btn_login_vendor -> {
                var loginVendorActivity = Intent(this@LoginActivity, LoginVendorActivity::class.java)
                startActivity(loginVendorActivity)
                finish()
            }
        }
    }

}