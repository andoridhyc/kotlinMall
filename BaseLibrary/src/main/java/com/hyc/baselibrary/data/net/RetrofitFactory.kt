package com.hyc.baselibrary.data.net

import com.hyc.baselibrary.common.BaseConstant

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * 创建一个单例工厂
 * */
object  RetrofitFactory {
    private val retrofit:Retrofit
    //创建一个json格式的 header 拦截器
    private val interceptor:Interceptor

    init {
        interceptor= Interceptor{
            val request = it.request()
                .newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("charset", "utf-8")
                .build()

            it.proceed(request)
        }
        retrofit=Retrofit.Builder()
            .baseUrl(BaseConstant.server_address)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .client(initClient())
            .build()
    }

    private fun initClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(initLogInterceptor())
            .connectTimeout(BaseConstant.TIME_OUT,TimeUnit.SECONDS)
            .readTimeout(BaseConstant.TIME_OUT,TimeUnit.SECONDS)
            .build()
    }

    //创建自定义日志拦截器
    private fun initLogInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level=HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    fun <T> create(service:Class<T>): T {
      return  retrofit.create(service)
    }
}