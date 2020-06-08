package com.hyc.baselibrary.presenter

import com.hyc.baselibrary.presenter.view.BaseView
import com.hyc.baselibrary.ui.activity.BaseMvpActivity


open class BasePresenter<T:BaseView> {
    lateinit var mView:T
}