package com.eatnus.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.webkit.*
import android.widget.Toast
import com.eatnus.R
import kotlinx.android.synthetic.main.activity_login.*
import android.content.Context.MODE_PRIVATE
import com.eatnus.App
import android.content.SharedPreferences
import com.eatnus.utils.AuthToken


class LoginActivity : AppCompatActivity(), LoginContract.View{
    private lateinit var loginPresenter: LoginPresenter

    var ivleApiKey = "Eaq0m9m4QiT4Z9BbzhxqY"
    var ivleAuthToken = AuthToken.token
    var ivleLogin = "https://ivle.nus.edu.sg/api/login/?apikey=" + ivleApiKey
    val ivleLoginSuccess = "https://ivle.nus.edu.sg/api/login/login_result.ashx?apikey=$ivleApiKey&r=0"
    val ivleValidate = "https://ivle.nus.edu.sg/api/Lapi.svc/Validate?APIKey=$ivleApiKey&Token=$ivleAuthToken"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginPresenter = LoginPresenter(this)

        val loginWebView = findViewById(R.id.webview_login) as WebView
        loginWebView.settings.javaScriptEnabled = true
        loginWebView.addJavascriptInterface(MyJavaScriptInterface(), "HtmlViewer")

        loginWebView.loadUrl(ivleLogin)


        loginWebView.webViewClient = object: WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {

                //this sets webview to gone ONLY if not the login page to IVLE
                if (!url.equals(ivleLogin)) {
                    view.setVisibility(View.GONE);

                    /*  user validated
                        extract token from html
                        redirects to landing page
                    */
                    if (url.equals(ivleLoginSuccess)) {
                        view.loadUrl("javascript:window.HtmlViewer.showHTML" +
                                "('&lt;html&gt;'+document.getElementsByTagName('html')[0].innerHTML+'&lt;/html&gt;');");
                        Toast.makeText(this@LoginActivity, "Success", Toast.LENGTH_LONG).show()

                    } else {  //in case anything else happens
                        Log.d("Eat@NUS", "Something is wrong!");
                    }

                }

            }

            //if there's connection issue or some other error
            override fun onReceivedError(view: WebView, request: WebResourceRequest, error: WebResourceError) {
                view.setVisibility(View.GONE)

                var notifyInternet = Snackbar.make(view, "Internet please", Snackbar.LENGTH_INDEFINITE) as Snackbar
                notifyInternet.setAction("Retry", View.OnClickListener() {
                    fun onClick(v: View) {
                        var launchLoginActivity = Intent(this@LoginActivity, this@LoginActivity.javaClass) as Intent
                        startActivity(launchLoginActivity)
                        finish()
                    }
                });
                notifyInternet.show();
            }

        };
    }


    override fun showLoginError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    //for extracting html source code and saving token to SharedPrefs
    private class MyJavaScriptInterface {
        @JavascriptInterface
        fun showHTML(html: String)
        {
            var handlerForJavascriptInterface: Handler = Handler()
            //code to use html content here
            handlerForJavascriptInterface.post(object: Runnable {
                override fun run()
                {
                    var splitTokens = html.split("<body>")
                    var token = splitTokens[1] as String
                    splitTokens = token.split("</body>");
                    var ivleToken = splitTokens[0] as String

                    AuthToken.setToken(ivleToken);
                    /*self = SynchroAPI(ivleAuthToken)
                    println("token $ivleAuthToken")
                    configureSelfSignedSSL()
                    configureIon()*/

                    //for debug
                    Log.d("Eat@NUS", ivleToken);
                }
            });
        }
    }    //configures app given authentication token

}