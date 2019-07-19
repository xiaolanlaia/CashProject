package com.w.xiaolanlaia.main.year

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.w.xiaolanlaia.R
import com.w.xiaolanlaia.base.BaseMVVMFragment
import com.w.xiaolanlaia.databinding.CashYearBinding

/**
 *  @author  xiaolanlaia
 *
 *  @create  2019/7/19 15:41
 *
 */


class YearFragment : BaseMVVMFragment<CashYearBinding,YearViewModel>(){
    override fun initContentViewID(): Int  = R.layout.cash_year

    override fun initViewModel(): YearViewModel = ViewModelProviders.of(activity as FragmentActivity,YearVMFactory(
        YearRepository())).get(YearViewModel::class.java)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindView.vm = vm
    }
}