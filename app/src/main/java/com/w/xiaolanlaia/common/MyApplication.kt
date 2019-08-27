package com.w.xiaolanlaia.common

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import cn.com.superLei.aoparms.AopArms

/**
 *  @author  xiaolanlaia
 *
 *  @create  2019/7/23 17:46
 *
 */


class MyApplication : Application(){

companion object{
    @SuppressLint("StaticFieldLeak")
    lateinit var context: Context
}

    override fun onCreate() {
        super.onCreate()
        //初始化全局布局context
        context = this.applicationContext

        AopArms.init(this)
    }
}