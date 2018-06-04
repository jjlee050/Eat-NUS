package com.eatnus.login

import com.eatnus.core.BasePresenter
import com.eatnus.core.BaseView
import com.google.common.base.Optional

interface LoginContract {
    interface View : BaseView<Presenter> {

    }
    interface Presenter : BasePresenter
    {
        fun isValidUserPrefix(name: Optional<String>): Boolean
    }
}
