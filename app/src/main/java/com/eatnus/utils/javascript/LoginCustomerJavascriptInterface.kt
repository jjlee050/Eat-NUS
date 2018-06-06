package com.eatnus.utils.javascript

import android.os.Handler
import android.util.Log
import android.webkit.JavascriptInterface
import com.eatnus.utils.api.EatNUSAPI
import com.eatnus.utils.helper.AppPreferencesHelper

//LoginCustomerJavascriptInterface.kt
/**
 * Interface to handle javascript at login customer page.
 *
 * @author Joseph Lee
 */
class LoginCustomerJavascriptInterface {

    /**
     * Extract html source code and saving token to SharedPrefs.
     */
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

                var helper : AppPreferencesHelper = AppPreferencesHelper()
                helper.setAccessToken(ivleToken);
                EatNUSAPI.authenticate(ivleToken);

                //for debug
                Log.d("Eat@NUS", ivleToken);
            }
        });
    }
}