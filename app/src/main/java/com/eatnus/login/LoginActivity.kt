package com.eatnus.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.eatnus.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar!!.hide()
        btn_login.setOnClickListener(this)
    }
    
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_login -> {
                Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show()
                var name  = et_username.text.toString()
                var password = et_password.text.toString()
            }
        }
    }
}