package com.hyc.baselibrary.ext

import com.hyc.baselibrary.rx.BaseSubscriber
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


fun <T> Observable<T>.execute(subscriber: BaseSubscriber<T>){
     this.observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
         .subscribe(subscriber)
}

