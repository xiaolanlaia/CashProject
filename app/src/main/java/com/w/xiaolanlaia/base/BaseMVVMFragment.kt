package com.w.xiaolanlaia.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.w.xiaolanlaia.R


/**
 *  @author  xiaolanlaia
 *
 *  @create  2019/7/18 16:17
 *
 */


abstract class BaseMVVMFragment<VSB : ViewDataBinding, VM : ViewModel> : Fragment(), CommonMethod {

    lateinit var bindViews : VSB
    lateinit var vm : VM


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(initContentViewID(),container,false)
        bindViews = DataBindingUtil.bind(v)!!
        vm = initViewModel()
        bindViews.lifecycleOwner = this
        return  v
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fitTransparentStatus()
        //设置状态背景栏颜色
        if (dyeStatus()) {
            activity?.let {
                it.window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                it.window.statusBarColor = it.getColor(R.color.colorPrimary)
            }
        } else {
            activity?.window?.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
    }

    abstract fun initViewModel(): VM
}