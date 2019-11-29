package com.w.xiaolanlaia.main.day.consumptionrecycler

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.w.xiaolanlaia.R
import com.w.xiaolanlaia.base.BaseMVVMFragment
import com.w.xiaolanlaia.databinding.FragmentConsumptionRecyclerBinding
import com.w.xiaolanlaia.entity.FragmentOneBean
import com.w.xiaolanlaia.main.day.DayRepository
import com.w.xiaolanlaia.main.day.DayVMFactory
import com.w.xiaolanlaia.main.day.DayViewModel
import com.w.xiaolanlaia.main.day.consumptionrecycler.adapter.FragmentOneAdapter

/**
 *  @author  xiaolanlaia
 *
 *  @create  2019/7/20 11:27
 *
 */


class ConsumptionRecyclerFragment : BaseMVVMFragment<FragmentConsumptionRecyclerBinding,DayViewModel>(){



    override fun initContentViewID(): Int  = R.layout.fragment_consumption_recycler

    companion object{
        const val TYPE_ZERO = 0
        const val TYPE_ONE = 1
        const val TYPE_TWO = 2


        fun newInstance(type : Int) : ConsumptionRecyclerFragment{

            val fragment = ConsumptionRecyclerFragment()
            val bundle = Bundle()
            bundle.putInt("type",type)
            fragment.arguments = bundle
            return fragment


        }
    }

    private var type = 0
    override fun initViewModel(): DayViewModel {

        type = arguments!!.getInt("type",0)

        return ViewModelProviders.of(activity!!,DayVMFactory(DayRepository())).get(
            "Day$type",DayViewModel::class.java
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViews.vm = vm
        val recyclerAdapter = FragmentOneAdapter()
        bindViews.fragmentOneRecycler.adapter = recyclerAdapter


        vm.list.observe(this, Observer {


            recyclerAdapter.updateList(type,it as  MutableList<FragmentOneBean>)

        })

    }
}