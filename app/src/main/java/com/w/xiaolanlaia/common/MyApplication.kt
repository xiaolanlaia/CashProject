package com.w.xiaolanlaia.common

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.w.xiaolanlaia.util.widget.wheel.PickCityUtil
import kotlin.properties.Delegates

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

    var instance: MyApplication by Delegates.notNull()

    fun instance() = instance

}

    override fun onCreate() {
        super.onCreate()
        //初始化全局布局context
        context = this.applicationContext

        instance = this

        //  handleSSLHandshake();
        PickCityUtil.initPickView(context)


    }


}