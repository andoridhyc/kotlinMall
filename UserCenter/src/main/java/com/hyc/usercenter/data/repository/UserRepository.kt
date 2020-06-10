package com.hyc.usercenter.data.repository

import com.hyc.baselibrary.data.net.RetrofitFactory
import com.hyc.baselibrary.data.protocol.BaseResp
import com.hyc.usercenter.data.api.UserApi
import com.hyc.usercenter.data.protocol.RegisterReq
import rx.Observable


class UserRepository {
    fun register(  mobile: String,
                   pwd: String,
                   verifyCode: String): Observable<BaseResp<String>> {
      return  RetrofitFactory
            .create(UserApi::class.java)
            .register(RegisterReq(mobile,pwd,verifyCode))
    }
}