package com.w.xiaolanlaia.main.day

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.w.xiaolanlaia.entity.FragmentOneBean
import java.lang.Exception

class DayViewModel (val repository: DayRepository) : ViewModel(){

    var list = MutableLiveData<List<FragmentOneBean>>()
    var list1 = mutableListOf<FragmentOneBean>()

    init {
        initData()
    }


    fun initData(){


        val fragmentOneBean = FragmentOneBean()


        fragmentOneBean.number = "2019.7.21"
        fragmentOneBean.type = 0
        fragmentOneBean.project = "买鸡蛋"
        fragmentOneBean.money = "6.5"
        fragmentOneBean.time = 123456789
        fragmentOneBean.location = "123456789"


        val fragmentOneBean1 = FragmentOneBean()

        fragmentOneBean1.number = "2019.7.21"
        fragmentOneBean1.type = 1
        fragmentOneBean1.project = "工资"
        fragmentOneBean1.money = "3000"
        fragmentOneBean1.time = 123456789
        fragmentOneBean1.location = "123456789"

        list1.add(0,fragmentOneBean)
        list1.add(1,fragmentOneBean1)

        list.value = list1
    }

}