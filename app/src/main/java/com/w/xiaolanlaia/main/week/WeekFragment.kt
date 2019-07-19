package com.w.xiaolanlaia.main.week

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.w.xiaolanlaia.R
import com.w.xiaolanlaia.base.BaseMVVMFragment
import com.w.xiaolanlaia.databinding.CashWeekBinding

/**
 *  @author  xiaolanlaia
 *
 *  @create  2019/7/19 15:29
 *
 */


class WeekFragment : BaseMVVMFragment<CashWeekBinding,WeekViewModel>(){
    override fun initContentViewID(): Int = R.layout.cash_week

    override fun initViewModel(): WeekViewModel = ViewModelProviders.of(activity as FragmentActivity,WeekVMFactory(
        WeekRepository()
    )).get(WeekViewModel::class.java)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindView.vm = vm
    }
}