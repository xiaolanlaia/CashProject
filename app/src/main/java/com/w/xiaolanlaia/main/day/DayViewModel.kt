package com.w.xiaolanlaia.main.day

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Color
import android.icu.math.BigDecimal
import android.icu.util.Calendar
import android.view.View
import android.view.View.OnClickListener
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cn.qqtheme.framework.picker.OptionPicker
import cn.qqtheme.framework.widget.WheelView
import com.w.xiaolanlaia.R
import com.w.xiaolanlaia.common.Constants
import com.w.xiaolanlaia.common.MediatorActivity
import com.w.xiaolanlaia.entity.FragmentOneBean
import org.jetbrains.anko.startActivity
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
class DayViewModel (val repository: DayRepository) : ViewModel(){

    companion object {

        const val DAY = 0
        const val WEEK = 1
        const val MONTH = 2
        const val YEAR = 3
        const val ALL = 4
        const val AUTO = 5

        const val DAY_TEXT = "天"
        const val WEEK_TEXT = "周"
        const val MONTH_TEXT = "月"
        const val YEAR_TEXT = "年"
        const val ALL_TEXT = "全部"
        const val AUTO_TEXT = "自定义"
    }

    val pay = MutableLiveData<Double>()
    val transferVisible = MutableLiveData<Boolean>()
    var income = MutableLiveData<Double>()
    var list = MutableLiveData<List<FragmentOneBean>>()
    var periodText = MutableLiveData<String>()
    var addDay = 0
    var dayType = 0
    var selectPickerPosition = 0
    var list1 = mutableListOf<FragmentOneBean>()

    var incomeValue = MutableLiveData<String>()
    var expendValue = MutableLiveData<String>()
    var totalCalculateValue = MutableLiveData<String>()


    init {
        initData()
        periodText.value = calculateDay(0)
        transferVisible.value = false
    }

    fun init(){

        addDay = 0

    }


    private fun initData(){


        val fragmentOneBean = FragmentOneBean()


        fragmentOneBean.number = "2019721" + Date().time
        fragmentOneBean.type = 0
        fragmentOneBean.project = "买鸡蛋"
        fragmentOneBean.money = 6.50
        fragmentOneBean.time = 123456789
        fragmentOneBean.location = "123456789"


        val fragmentOneBean1 = FragmentOneBean()

        fragmentOneBean1.number = "2019721" + Date().time
        fragmentOneBean1.type = 1
        fragmentOneBean1.project = "工资"
        fragmentOneBean1.money = 3000.00
        fragmentOneBean1.time = 123456789
        fragmentOneBean1.location = "123456789"

        list1.add(0,fragmentOneBean)
        list1.add(1,fragmentOneBean1)


        val expend = list1.filter { it.type == 0}

        expend.forEachIndexed { index, item ->

            totalExpend = calculateMoney(item.money).toString()


        }

        val income = list1.filter { it.type == 1 }

        income.forEachIndexed { index, item ->

            totalIncomne = calculateMoney(item.money).toString()
        }

        expendValue.value = totalExpend

        incomeValue.value = totalIncomne


        totalCalculateValue.value = subtract(totalIncomne.toDouble(),totalExpend.toDouble()).toString()

        list.value = list1
    }


    var totalExpend = ""
    var totalIncomne = ""
    fun calculateMoney(v1: Double?): Double {
        val b1 = BigDecimal(v1.toString())
        return b1.toDouble()
    }

    fun subtract(v1: Double, v2: Double): Double {
        val b1 = BigDecimal(v1.toString())
        val b2 = BigDecimal(v2.toString())
        return b1.subtract(b2).toDouble()
    }

    val cashDayClick = OnClickListener {
        when (it.id) {

            R.id.toolbar_transfer -> {

                transferVisible.value = !transferVisible.value!!

            }

            R.id.add_iv -> {


                it.context.startActivity<MediatorActivity>(Pair(Constants.SP.MEDIATOR_ACTIVITY_TYPE,MediatorActivity.TYPE_ADD))
            }

            R.id.left_ward_tv ->{

                dayType(false)

            }

            R.id.right_ward_tv ->{

                dayType(true)

            }

            R.id.period_text ->{
                val arrayList = mutableListOf<String>()

                arrayList.add(DAY_TEXT)
                arrayList.add(WEEK_TEXT)
                arrayList.add(MONTH_TEXT)
                arrayList.add(YEAR_TEXT)
                arrayList.add(ALL_TEXT)
                arrayList.add(AUTO_TEXT)

                showPicker(it,arrayList.toTypedArray())
            }

        }
    }

    fun dayType(type : Boolean){

        when(dayType) {

            DAY -> {

                if (type){
                    periodText.value = calculateDay(++addDay)
                }else{
                    periodText.value = calculateDay(--addDay)
                }

            }

            WEEK -> {

                if (type){
                    periodText.value = calculateWeek(++addDay)
                }else{
                    periodText.value = calculateWeek(--addDay)
                }

            }

            MONTH -> {

                if (type){
                    periodText.value = getMonthDate(++addDay)
                }else{
                    periodText.value = getMonthDate(--addDay)
                }

            }

            YEAR -> {

                if (type){
                    periodText.value = calculateYear(++addDay)
                }else{
                    periodText.value = calculateYear(--addDay)
                }

            }

            ALL -> {

//                if (type){
//                    periodText.value = calculateDay(++addDay)
//                }else{
//                    periodText.value = calculateDay(--addDay)
//                }

            }

            AUTO -> {

//                if (type){
//                    periodText.value = calculateDay(++addDay)
//                }else{
//                    periodText.value = calculateDay(--addDay)
//                }

            }


        }
    }


    private fun showPicker(view: View, array : Array<String>){

        init()

        val optionPicker = OptionPicker(view.context as Activity,array)
        optionPicker.setTitleText("请选择时间")
        optionPicker.setTextSize(18)
        optionPicker.setCancelTextColor(Color.BLACK)
        optionPicker.setSubmitTextColor(Color.BLACK)
        optionPicker.setTitleTextSize(20)
        optionPicker.setLineSpaceMultiplier(3.5f)
        optionPicker.setTopLineColor(Color.TRANSPARENT)
        optionPicker.setDividerConfig(WheelView.DividerConfig().setVisible(false))
        optionPicker.setShadowColor(view.context.getColor(R.color.color_hint_grey), 14)
        optionPicker.setTextColor(view.context.getColor(R.color.color_common_blue))
        optionPicker.setOffset(2)
        optionPicker.show()

        optionPicker.setOnOptionPickListener(object : OptionPicker.OnOptionPickListener(){

            override fun onOptionPicked(index: Int, item: String?) {
                view as TextView
                selectPickerPosition = index

                when(item){

                    DAY_TEXT ->{

                        dayType = DAY
                        view.text = calculateDay(0)

                    }

                    WEEK_TEXT ->{

                        dayType = WEEK
                        view.text = calculateWeek(0)

                    }

                    MONTH_TEXT ->{

                        dayType = MONTH
                        view.text = getMonthDate(0)
                    }

                    YEAR_TEXT ->{

                        dayType = YEAR
                        view.text = calculateYear(0)
                    }

                    ALL_TEXT ->{

                        dayType = ALL
                        view.text = item
                    }

                    AUTO_TEXT ->{

                        dayType = AUTO
                        view.text = item
                    }
                }
            }
        })
    }

    /**
     * 获取当前日期
     */
    private fun calculateDay(addDays : Int) : String{

        val calendar = Calendar.getInstance()

        calendar.add(Calendar.DATE, addDays) //计算

        val date = calendar.time

        val simpleDateFormat = SimpleDateFormat("yyyy.MM.dd")

        return simpleDateFormat.format(date)

    }

    /**
     * 获取周区间日期
     */
    private fun calculateWeek(addWeeks: Int) : String{

        val calendar = Calendar.getInstance()
        val simpleDateFormat = SimpleDateFormat("yyyy.MM.dd")

        //一星期开始的第一天
        calendar.set(Calendar.DAY_OF_WEEK,2) //计算

        calendar.add(Calendar.DATE,addWeeks * 7)

        val firstDate = calendar.time



        //一星期的最后一天
        val lastCalendar = Calendar.getInstance()

        lastCalendar.set(Calendar.DAY_OF_WEEK,1) //计算

        lastCalendar.add(Calendar.DATE,addWeeks * 7 + 7)

        val lastDate = lastCalendar.time

        return "${simpleDateFormat.format(firstDate)} - ${simpleDateFormat.format(lastDate)}"
    }


    /**
     * 获取月区间日期
     */
    fun getMonthDate(addMonth : Int) : String{

        val calendar = Calendar.getInstance()

        calendar.add(Calendar.MONTH, addMonth) //计算

        val date = calendar.time

        val simpleDateFormat = SimpleDateFormat("yyyy.MM")

        return simpleDateFormat.format(date)

    }


    /**
     * 获取年份
     */
    fun calculateYear(addYear : Int) : String{

        val calendar = Calendar.getInstance()

        calendar.add(Calendar.YEAR, addYear) //计算

        val date = calendar.time

        val simpleDateFormat = SimpleDateFormat("yyyy")

        return simpleDateFormat.format(date)
    }

    /**
     * 获取全部
     */
    fun getAllDate(): String{
        return "k"
    }

    /**
     * 自定义
     */
    fun getCustomDate(): String{
        return "k"

    }

}