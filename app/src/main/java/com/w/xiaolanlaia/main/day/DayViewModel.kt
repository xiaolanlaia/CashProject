package com.w.xiaolanlaia.main.day

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.w.xiaolanlaia.entity.FragmentOneBean


class DayViewModel (val repository: DayRepository) : ViewModel(){

    val pay = MutableLiveData<Double>()
    var income = MutableLiveData<Double>()
    var list = MutableLiveData<List<FragmentOneBean>>()
    var list1 = mutableListOf<FragmentOneBean>()
    //访问失败，请求退出Activity
    val requestError = MutableLiveData<Boolean>()

    init {
        initData()
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

//        val payList = list1.filter {
//            it.type == 0
//        }
//
//        payList.forEachIndexed { index, item ->
//
//            pay.value = item.money
//        }
//
//        val incomeList = list1.filter {
//            it.type == 1
//        }
//
//        incomeList.forEachIndexed { index, item ->
//            income.value = income.value?.plus(item.money!!)
//        }

        list.value = list1
    }

}