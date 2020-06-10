package com.hyc.baselibrary.data.protocol

//响应的接收类
class BaseResp<out T> (val status:Int,val message:String,val data:T)