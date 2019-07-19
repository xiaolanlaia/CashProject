package com.w.xiaolanlaia.base

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.w.xiaolanlaia.R


/**
 *  Create by xiaolanlaia on 2019/7/18
 */

abstract class BaseActivity : AppCompatActivity(), CommonMethod {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(initContentViewID())
        fitTransparentStatus()
        if (dyeStatus()) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = getColor(R.color.colorPrimary)
        } else {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }

        if (isLightStatus()) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        } else {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
        }
        onViewCreated()



    }
    open fun isLightStatus(): Boolean = false

    open fun onViewCreated() {}

}