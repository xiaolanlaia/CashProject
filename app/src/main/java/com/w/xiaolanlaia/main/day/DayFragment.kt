package com.w.xiaolanlaia.main.day

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders

import com.w.xiaolanlaia.R
import com.w.xiaolanlaia.databinding.CashDayBinding
import com.w.xiaolanlaia.base.BaseMVVMFragment

class DayFragment : BaseMVVMFragment<CashDayBinding, DayViewModel>(){
    override fun initContentViewID(): Int = R.layout.cash_day

    override fun initViewModel(): DayViewModel = ViewModelProviders.of(activity as FragmentActivity, DayVMFactory(
        DayRepository()
    )
    ).get(DayViewModel::class.java)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindView.vm=vm


    }
}