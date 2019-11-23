package com.w.xiaolanlaia.util

import android.content.Context
import android.view.View

/**
 *  @author  xiaolanlaia
 *
 *  @create  2019/7/23 8:25
 *
 */


object SizeUtil {

    fun getStatusHeight(context: Context): Int {

        val statusHeightId = context.applicationContext.resources.getIdentifier("status_bar_height", "dimen", "android")
        return context.applicationContext.resources.getDimensionPixelSize(statusHeightId)
    }
}
    /**
     * 使View适配状态栏
     *
     * 将View的高度加上状态栏的高度
     */

    fun View.fitTransparentStatus(){

        val statusHeight = SizeUtil.getStatusHeight(this.context)
        val lp = this.layoutParams
        layoutParams.height += statusHeight
        this.layoutParams = lp
    }
