package com.hyc.usercenter.service.impl

import rx.Observable


interface UserService {
    fun register(mobile:String,pwd:String,verifyCode:String): Observable<Boolean>
}