package com.eatnus.utils.api

import com.eatnus.App
import com.eatnus.utils.helper.AppPreferencesHelper
import com.google.gson.JsonObject
import com.koushikdutta.ion.Ion

//EatNUSAPI.kt
/**
 * To store information relating to EatNUSAPI.
 *
 * @author Joseph Lee
 */
class EatNUSAPI private constructor(var mIVLEAuthToken: String){
    private var ivleAuthToken: String = mIVLEAuthToken
    companion object {
        private lateinit var self: EatNUSAPI;
        private var ivleApiKey = "Eaq0m9m4QiT4Z9BbzhxqY"
        private var ivleAuthToken = AppPreferencesHelper().getAccessToken()
        val ivleLogin = "https://ivle.nus.edu.sg/api/login/?apikey=" + ivleApiKey
        val ivleLoginSuccess = "https://ivle.nus.edu.sg/api/login/login_result.ashx?apikey=$ivleApiKey&r=0"
        var ivleValidate = "https://ivle.nus.edu.sg/api/Lapi.svc/Validate?APIKey=$ivleApiKey&Token=$ivleAuthToken"

        /**
         * Configures app given authentication token.
         */
        fun authenticate(ivleAuthToken: String) {
            updateToken(ivleAuthToken)
            self = EatNUSAPI(ivleAuthToken)
            println("token $ivleAuthToken")
        }

        /**
         * Ensures variables using authToken are updated from SharedPrefs after receiving token
         * this takes care of the null pointer issue when app is relaunched after successful login.
         */
        fun updateToken(token: String) {
            ivleAuthToken = token
            ivleValidate = "https://ivle.nus.edu.sg/api/Lapi.svc/Validate?APIKey=$ivleApiKey&Token=$ivleAuthToken"
        }
        /**
         * To validate current token and update token if new token received.
         *
         * @return string based on validation result for action to be taken accordingly.
         */
        fun validate(): String {

            var result: JsonObject? = null
            try {
                result = Ion.with(App.context)
                        .load(ivleValidate)
                        //.setLogging("MyLogs", Log.VERBOSE)
                        .asJsonObject()
                        .get()
            } catch (ex: Exception) {
                println("Error " + ex.toString())
            }

            if (result == null) {   //no object returned
                return "Error"
            } else if (result!!.get("Success").toString().equals("true")) {

                var helper : AppPreferencesHelper = AppPreferencesHelper()

                if (!result!!.get("Token").getAsString().equals(helper.getAccessToken())) {
                    helper.setAccessToken(result!!.get("Token").getAsString())
                    updateToken(helper.getAccessToken()!!)
                }
                authenticate(helper.getAccessToken()!!)
                return "Successful"
            } else {  //validate unsuccessful
                return "Fail"
            }
        }
    }


}