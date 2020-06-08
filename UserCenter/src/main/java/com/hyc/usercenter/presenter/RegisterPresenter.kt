package com.hyc.usercenter.presenter

import com.hyc.baselibrary.presenter.BasePresenter
import com.hyc.baselibrary.presenter.view.BaseView
import com.hyc.usercenter.presenter.view.RegisterView

class RegisterPresenter : BasePresenter<RegisterView>() {
    fun register(mobile:String,verifyCode:String){
        //业务逻辑

        mView.onRegisterResult(true)
    }
}