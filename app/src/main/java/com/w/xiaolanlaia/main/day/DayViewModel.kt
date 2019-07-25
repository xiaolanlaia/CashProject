package com.w.xiaolanlaia.main.day

import android.view.View
import android.widget.Button
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.w.xiaolanlaia.R
import com.w.xiaolanlaia.entity.FragmentOneBean
import com.w.xiaolanlaia.util.CodeUtil.toast


class DayViewModel (val repository: DayRepository) : ViewModel(){

    val pay = MutableLiveData<Double>()
    val transferVisible = MutableLiveData<Boolean>()
    var income = MutableLiveData<Double>()
    var list = MutableLiveData<List<FragmentOneBean>>()
    var list1 = mutableListOf<FragmentOneBean>()
    //访问失败，请求退出Activity


    init {
        initData()
        transferVisible.value = false
    }


    private fun initData(){


        val fragmentOneBean = FragmentOneBean()


        fragmentOneBean.number = "2019.7.21"
        fragmentOneBean.type = 0
        fragmentOneBean.project = "买鸡蛋"
        fragmentOneBean.money = 6.50
        fragmentOneBean.time = 123456789
        fragmentOneBean.location = "123456789"


        val fragmentOneBean1 = FragmentOneBean()

        fragmentOneBean1.number = "2019.7.21"
        fragmentOneBean1.type = 1
        fragmentOneBean1.project = "工资"
        fragmentOneBean1.money = 3000.00
        fragmentOneBean1.time = 123456789
        fragmentOneBean1.location = "123456789"

        list1.add(0,fragmentOneBean)
        list1.add(1,fragmentOneBean1)



        list.value = list1
    }

    val cashDayClick = View.OnClickListener {
        when (it.id) {

            R.id.toolbar_transfer -> {

                transferVisible.value = !transferVisible.value!!

            }

        }
    }

}