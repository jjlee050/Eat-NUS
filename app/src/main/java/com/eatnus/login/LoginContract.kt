package com.eatnus.login

import com.eatnus.core.BasePresenter
import com.eatnus.core.BaseView
import java.util.*

interface LoginContract {
    interface View : BaseView<Presenter> {

    }
    interface Presenter : BasePresenter
    {
        fun checkTypeOfUser(name: Optional<String>)
    }
}
