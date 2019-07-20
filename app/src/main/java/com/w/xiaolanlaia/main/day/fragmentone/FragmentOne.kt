package com.w.xiaolanlaia.main.day.fragmentone

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.w.xiaolanlaia.R
import com.w.xiaolanlaia.base.BaseMVVMFragment
import com.w.xiaolanlaia.databinding.FragmentOneBinding
import com.w.xiaolanlaia.entity.FragmentOneBean
import com.w.xiaolanlaia.main.day.DayRepository
import com.w.xiaolanlaia.main.day.DayVMFactory
import com.w.xiaolanlaia.main.day.DayViewModel
import com.w.xiaolanlaia.main.day.fragmentone.adapter.FragmentOneAdapter

/**
 *  @author  xiaolanlaia
 *
 *  @create  2019/7/20 11:27
 *
 */


class FragmentOne : BaseMVVMFragment<FragmentOneBinding,DayViewModel>(){



    override fun initContentViewID(): Int  = R.layout.fragment_one

    companion object{
        const val TYPE_ONE = 0


        fun newInstance(type : Int) : FragmentOne{

            val fragment = FragmentOne()
            val bundle = Bundle()
            bundle.putInt("type",type)
            fragment.arguments = bundle
            return fragment


        }
    }

    private var type = 0
    override fun initViewModel(): DayViewModel {

        type = arguments!!.getInt("type",1)

        return ViewModelProviders.of(activity!!,DayVMFactory(DayRepository())).get(
            "Day${type}",DayViewModel::class.java
        )
    }

    lateinit var list : MutableList<FragmentOneBean>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var recyclerAdapter = FragmentOneAdapter()
        bindView.fragmentOneRecycler.adapter = recyclerAdapter


        vm.list.observe(this, Observer {
            recyclerAdapter.updataList(it as  MutableList<FragmentOneBean>)

        })

    }
}