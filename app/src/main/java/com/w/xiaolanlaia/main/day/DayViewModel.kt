package com.w.xiaolanlaia.main.day

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.w.xiaolanlaia.entity.FragmentOneBean

class DayViewModel (val repository: DayRepository) : ViewModel(){

    val list = MutableLiveData<List<FragmentOneBean>>()
    var list2 = mutableListOf<FragmentOneBean>()

    init {
        initData()
    }
    fun initData(){
        val fragmentOneBean = FragmentOneBean()
        fragmentOneBean.number = "123456789"
        fragmentOneBean.type = "kk"
        fragmentOneBean.project = "consume"
        fragmentOneBean.money = "12580"
        fragmentOneBean.time = 123456789
        fragmentOneBean.location = "123456789"
        list2.add(fragmentOneBean)

        list.value = list2
    }

}