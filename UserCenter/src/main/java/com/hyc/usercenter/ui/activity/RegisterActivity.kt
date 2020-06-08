package com.hyc.usercenter.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hyc.baselibrary.ui.activity.BaseMvpActivity
import com.hyc.usercenter.R
import com.hyc.usercenter.presenter.RegisterPresenter
import com.hyc.usercenter.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop
import org.jetbrains.anko.startActivity

import org.jetbrains.anko.toast

class RegisterActivity :BaseMvpActivity<RegisterPresenter>(),RegisterView{
    override fun onRegisterResult(result: Boolean) {
        toast("注册成功")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        mPersenter= RegisterPresenter()
        mPersenter.mView=this
        mRegisterBtn.setOnClickListener {
            mPersenter.register("","")
        }
    }
}