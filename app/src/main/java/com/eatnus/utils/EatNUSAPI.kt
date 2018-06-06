package com.eatnus.utils

class EatNUSAPI{
    companion object {
        var ivleApiKey = "Eaq0m9m4QiT4Z9BbzhxqY"
        var ivleAuthToken = AuthToken.token
        var ivleLogin = "https://ivle.nus.edu.sg/api/login/?apikey=" + ivleApiKey
        val ivleLoginSuccess = "https://ivle.nus.edu.sg/api/login/login_result.ashx?apikey=$ivleApiKey&r=0"
        val ivleValidate = "https://ivle.nus.edu.sg/api/Lapi.svc/Validate?APIKey=$ivleApiKey&Token=$ivleAuthToken"

    }
}