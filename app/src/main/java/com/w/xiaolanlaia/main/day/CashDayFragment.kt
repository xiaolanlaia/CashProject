package com.w.xiaolanlaia.main.day

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders

import com.w.xiaolanlaia.R
import com.w.xiaolanlaia.databinding.CashDayBinding
import com.w.xiaolanlaia.base.BaseMVVMFragment

class CashDayFragment : BaseMVVMFragment<CashDayBinding, CashDayViewModel>(){
    override fun initContentViewID(): Int = R.layout.cash_day

    override fun initViewModel(): CashDayViewModel = ViewModelProviders.of(activity as FragmentActivity, CashDayVMFactory(
        CashDayRepository()
    )
    ).get(CashDayViewModel::class.java)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindView.vm=vm


    }
}