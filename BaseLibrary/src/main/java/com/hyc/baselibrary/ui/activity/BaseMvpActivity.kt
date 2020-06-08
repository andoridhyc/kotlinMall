package com.hyc.baselibrary.ui.activity

import com.hyc.baselibrary.presenter.BasePresenter
import com.hyc.baselibrary.presenter.view.BaseView

open class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {
    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onError() {

    }

    lateinit var mPersenter:T
}