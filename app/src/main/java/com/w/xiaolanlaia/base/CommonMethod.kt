package com.w.xiaolanlaia.base

/**
 *  Create by xiaolanlaia on 2019/7/18
 */
interface CommonMethod {


    fun initContentViewID() : Int

    /**
     * 适配透明状态栏
     */
    fun fitTransparentStatus(){}

    /**
     * 使状态栏为主题色，默认False
     */
    fun dyeStatus() : Boolean = false
}