package com.hyc.usercenter.presenter

import com.hyc.baselibrary.ext.execute
import com.hyc.baselibrary.presenter.BasePresenter
import com.hyc.baselibrary.rx.BaseSubscriber
import com.hyc.usercenter.service.impl.UserServiceImpl
import com.hyc.usercenter.presenter.view.RegisterView


class RegisterPresenter : BasePresenter<RegisterView>() {
    fun register(mobile: String, verifyCode: String ,pwd: String) {
        //业务逻辑
        val userService = UserServiceImpl()
        userService.register(mobile,  pwd,verifyCode)
            .execute(object :BaseSubscriber<Boolean>(){
                override fun onNext(t: Boolean) {
                    mView.onRegisterResult(t)
                }
            })
    }
}