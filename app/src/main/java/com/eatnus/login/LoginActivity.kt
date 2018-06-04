package com.eatnus.login

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.eatnus.R
import com.google.common.base.Optional
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar!!.hide()
        btn_login.setOnClickListener(this)
    }
    
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_login -> {
                val name  = et_username.text.toString()
                val password = et_password.text.toString()
                System.out.println(name.length)
                loginPresenter = LoginPresenter()
                if(!loginPresenter.isValidUserPrefix(Optional.fromNullable(name)))
                    Toast.makeText(this, "Invalid username prefix", Toast.LENGTH_SHORT).show()
            }
        }
    }
}