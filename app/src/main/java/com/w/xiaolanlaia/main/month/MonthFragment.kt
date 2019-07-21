package com.w.xiaolanlaia.main.month

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.w.xiaolanlaia.R
import com.w.xiaolanlaia.base.BaseMVVMFragment
import com.w.xiaolanlaia.databinding.CashMonthBinding

/**
 *  @author  xiaolanlaia
 *
 *  @create  2019/7/19 15:14
 *
 */


class MonthFragment : BaseMVVMFragment<CashMonthBinding,MonthViewModel>(){
    override fun initContentViewID() : Int =  R.layout.cash_month

    override fun initViewModel(): MonthViewModel = ViewModelProviders.of(activity as FragmentActivity,MonthVMFactory(
        MonthRepository())).get(MonthViewModel::class.java)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews.vm = vm
    }
}