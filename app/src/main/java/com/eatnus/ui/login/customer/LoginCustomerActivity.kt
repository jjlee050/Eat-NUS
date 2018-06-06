package com.eatnus.ui.login.customer

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.webkit.*
import android.widget.Toast
import com.eatnus.R
import com.eatnus.ui.login.customer.contract.LoginCustomerContract
import com.eatnus.utils.helper.AppPreferencesHelper
import com.eatnus.utils.api.EatNUSAPI
import com.eatnus.utils.javascript.LoginCustomerJavascriptInterface
import kotlinx.android.synthetic.main.activity_login_customer.*

//LoginCustomerActivity.kt
/**
 * View Class to handle login customer activity page.
 *
 * @author Joseph Lee
 */
class LoginCustomerActivity : AppCompatActivity(), LoginCustomerContract.View {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_customer)

        if(EatNUSAPI.validate().equals("Successful").not()) {
            setWebView()
        }
        else{
            Log.d("Eat@NUSAPI", AppPreferencesHelper().getAccessToken())
        }
    }

    /**
     * Set up web view to access ivle login page for NUS Student and Staff.
     */
    @SuppressLint("SetJavaScriptEnabled")
    override fun setWebView(){
        loginWebView.settings.javaScriptEnabled = true
        loginWebView.addJavascriptInterface(LoginCustomerJavascriptInterface(), "HtmlViewer")

        loginWebView.loadUrl(EatNUSAPI.ivleLogin)

        loginWebView.webViewClient = object: WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                //this sets webview to gone ONLY if not the login page to IVLE
                if (url.equals(EatNUSAPI.ivleLogin).not()) {
                    view.visibility = View.GONE

                    // Validate user, extract token from html and redirects to landing page
                    if (url == EatNUSAPI.ivleLoginSuccess) {
                        view.loadUrl("javascript:window.HtmlViewer.showHTML" +
                                "('&lt;html&gt;'+document.getElementsByTagName('html')[0].innerHTML+'&lt;/html&gt;');")
                        redirectUserToMainPage()

                    } else {  //in case anything else happens
                        Log.d("Eat@NUS", "Something is wrong!")
                    }

                }
            }
            //if there's connection issue or some other error
            override fun onReceivedError(view: WebView, request: WebResourceRequest, error: WebResourceError) {
                view.visibility = View.GONE
                notifyInternet(view)
            }
        }
    }

    /**
     * Redirect user to the customer main page.
     */
    fun redirectUserToMainPage(){
        Toast.makeText(this@LoginCustomerActivity, "Success", Toast.LENGTH_LONG).show()
    }

    /**
     * TO notify user that there is no internet connection in the phone.
     */
    fun notifyInternet(view: WebView){
        val notifyInternet = Snackbar.make(
                view,
                "Internet please",
                Snackbar.LENGTH_INDEFINITE
        ).setAction("Retry", View.OnClickListener() {
            fun onClick() {
                val launchLoginActivity = Intent(this@LoginCustomerActivity, this@LoginCustomerActivity.javaClass)
                launchLoginActivity.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
                startActivity(launchLoginActivity)
                finish()
            }
        })
        notifyInternet.show()
    }
}