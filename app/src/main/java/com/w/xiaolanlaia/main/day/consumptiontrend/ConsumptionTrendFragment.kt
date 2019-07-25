package com.w.xiaolanlaia.main.day.consumptiontrend

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.w.xiaolanlaia.R
import com.w.xiaolanlaia.base.BaseMVVMFragment
import com.w.xiaolanlaia.databinding.FragmentConsumptionTrendBinding
import com.w.xiaolanlaia.main.day.DayRepository
import com.w.xiaolanlaia.main.day.DayVMFactory
import com.w.xiaolanlaia.main.day.DayViewModel

/**
 *  @author  xiaolanlaia
 *
 *  @create  2019/7/25 13:55
 *
 */


class ConsumptionTrendFragment : BaseMVVMFragment<FragmentConsumptionTrendBinding,DayViewModel>(){
    override fun initContentViewID(): Int = R.layout.fragment_consumption_trend

    companion object{
        const val TYPE_THREE = 3
        const val TYPE_FOUR = 4
        const val TYPE_FIVE = 5

        fun newInstance(type : Int) : ConsumptionTrendFragment{
            val fragment = ConsumptionTrendFragment()
            val bundle = Bundle()
            bundle.putInt("type",type)
            fragment.arguments = bundle
            return fragment

        }
    }
    private var type = 0
    override fun initViewModel(): DayViewModel {
        type = arguments!!.getInt("type",3)
        return ViewModelProviders.of(activity!!,DayVMFactory(DayRepository())).get(
            "Day${type}",DayViewModel::class.java
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}