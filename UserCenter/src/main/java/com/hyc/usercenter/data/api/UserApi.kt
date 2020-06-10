package com.hyc.usercenter.data.api

import com.hyc.baselibrary.data.protocol.BaseResp
import com.hyc.usercenter.data.protocol.RegisterReq
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable


interface  UserApi{
    @POST("userCenter/register")
    fun register(@Body req:RegisterReq): Observable<BaseResp<String>>
}