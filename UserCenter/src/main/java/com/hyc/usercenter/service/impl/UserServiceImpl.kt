package com.hyc.usercenter.service.impl

import com.hyc.baselibrary.data.protocol.BaseResp
import com.hyc.baselibrary.rx.BaseException
import com.hyc.usercenter.data.repository.UserRepository
import rx.Observable
import rx.functions.Func1


class UserServiceImpl : UserService {
    override fun register(
        mobile: String,
        pwd: String,
        verifyCode: String
    ): Observable<Boolean> {
        val repository = UserRepository()

        return repository.register(mobile, pwd, verifyCode)
            .flatMap(object : Func1<BaseResp<String>, Observable<Boolean>> {
                override fun call(t: BaseResp<String>?): Observable<Boolean> {
                    if (t?.status != 0) {
                        return Observable.error(BaseException(t?.status ?: -1, t?.message ?: ""))
                    }
                    return Observable.just(true)
                }

            })
    }
}