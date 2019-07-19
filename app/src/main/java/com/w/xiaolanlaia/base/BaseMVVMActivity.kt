package com.w.xiaolanlaia.base


import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.w.xiaolanlaia.R

/**
 *  @author  xiaolanlaia
 *
 *  @create  2019/7/18 16:05
 *
 */


abstract class BaseMVVMActivity<VDB : ViewDataBinding,VM : ViewModel> : AppCompatActivity(),
    CommonMethod {

    lateinit var bindView : VDB
    lateinit var vm : VM


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        bindView = DataBindingUtil.setContentView(this,initContentViewID())
        bindView.lifecycleOwner = this
        vm = initViewModel()

        onMVVMCreated()
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
    }

    abstract fun initViewModel(): VM

    open fun isLightStatus(): Boolean = false

    /**
     * 创建bindView和ViewModel后，在OnCreate方法中继续做的事情
     */
    abstract fun onMVVMCreated()
}