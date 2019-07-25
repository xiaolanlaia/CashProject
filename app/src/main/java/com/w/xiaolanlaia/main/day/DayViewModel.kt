package com.w.xiaolanlaia.main.day

import android.app.Activity
import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cn.qqtheme.framework.picker.OptionPicker
import cn.qqtheme.framework.widget.WheelView
import com.w.xiaolanlaia.R
import com.w.xiaolanlaia.entity.FragmentOneBean


class DayViewModel (val repository: DayRepository) : ViewModel(){

    val pay = MutableLiveData<Double>()
    val transferVisible = MutableLiveData<Boolean>()
    var income = MutableLiveData<Double>()
    var list = MutableLiveData<List<FragmentOneBean>>()
    var list1 = mutableListOf<FragmentOneBean>()


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

            R.id.period_text ->{
                val arrayList = mutableListOf<String>()


                arrayList.add("今日")
                arrayList.add("最近一周")
                arrayList.add("最近一星期")
                arrayList.add("最近一个月")

                showPicker(it,arrayList.toTypedArray())
            }

        }
    }

    private fun showPicker(view: View, array : Array<String>){
        val optionPicker = OptionPicker(view.context as Activity,array)
        optionPicker.setTitleText("请选择时间")
        optionPicker.setTextSize(18)
        optionPicker.setCancelTextColor(Color.BLACK)
        optionPicker.setSubmitTextColor(Color.BLACK)
        optionPicker.setTitleTextSize(20)
        optionPicker.setLineSpaceMultiplier(3.5f)
        optionPicker.setTopLineColor(Color.TRANSPARENT)
        optionPicker.setDividerConfig(WheelView.DividerConfig().setVisible(false))
        optionPicker.setShadowColor(view.context.getColor(R.color.bottom_grey), 14)
        optionPicker.setTextColor(view.context.getColor(R.color.common_blue))
        optionPicker.setOffset(2)
        optionPicker.show()

        optionPicker.setOnOptionPickListener(object : OptionPicker.OnOptionPickListener(){
            override fun onOptionPicked(index: Int, item: String?) {
                view as TextView
                view.text = item
            }
        })


    }

}