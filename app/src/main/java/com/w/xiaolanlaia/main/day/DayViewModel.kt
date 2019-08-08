package com.w.xiaolanlaia.main.day

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Color
import android.icu.util.Calendar
import android.view.View
import android.view.View.OnClickListener
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cn.qqtheme.framework.picker.OptionPicker
import cn.qqtheme.framework.widget.WheelView
import com.w.xiaolanlaia.R
import com.w.xiaolanlaia.entity.FragmentOneBean
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*



@SuppressLint("SimpleDateFormat")
class DayViewModel (val repository: DayRepository) : ViewModel(){

    val pay = MutableLiveData<Double>()
    val transferVisible = MutableLiveData<Boolean>()
    var income = MutableLiveData<Double>()
    var list = MutableLiveData<List<FragmentOneBean>>()
    var periodText = MutableLiveData<String>()
    var addDay = 0
    var selectPickerPosition = 0
    var list1 = mutableListOf<FragmentOneBean>()


    init {
        initData()
        periodText.value = getDayDate()
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



        list.value = list1
    }

    val cashDayClick = OnClickListener {
        when (it.id) {

            R.id.toolbar_transfer -> {

                transferVisible.value = !transferVisible.value!!

            }

            R.id.left_ward_tv ->{

                addDay --

                transferPeriodDate()

            }

            R.id.right_ward_tv ->{

                addDay ++

                transferPeriodDate()

            }

            R.id.period_text ->{
                val arrayList = mutableListOf<String>()

                arrayList.add("天")
                arrayList.add("周")
                arrayList.add("月")
                arrayList.add("季")
                arrayList.add("年")
                arrayList.add("全部")
                arrayList.add("自定义")

                showPicker(it,arrayList.toTypedArray())
            }

        }
    }

    private fun transferPeriodDate() {

        when (selectPickerPosition) {

            0 -> {
                periodText.value = getDayDate()
            }
            1 -> {
                periodText.value = getWeekDate()

            }
            2 -> {
                periodText.value = getMonthDate()

            }
            3 -> {
                periodText.value = getQuarterDate()

            }
            4 -> {
                periodText.value = getYearDate()

            }
            5 -> {
                periodText.value = getAllDate()

            }
            6 -> {
                periodText.value = getCustomDate()

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
                    "天" ->{
                        view.text = getDayDate()

                    }
                    "周" ->{

                        view.text = getWeekDate()

                    }
                    "月" ->{
                        view.text = getMonthDate()
                    }
                    "季" ->{
                        view.text = getQuarterDate()
                    }
                    "年" ->{
                        view.text = getYearDate()
                    }
                    "全部" ->{
                        view.text = item
                    }
                    "自定义" ->{
                        view.text = item
                    }
                }
            }
        })
    }

    /**
     * 获取当前日期
     */
    fun getDayDate() : String{

        val time = LocalDateTime.now()
        val time2 = time.minusDays(1)


        val simpleDateFormat = SimpleDateFormat("yyyy.MM.dd")

        val date = Date(System.currentTimeMillis() + (addDay * 1000 * 60 * 60 * 24))

        return "${simpleDateFormat.format(date)}(天)"

    }

    /**
     * 获取周区间日期
     */
    fun getWeekDate(): String {

        val cal = Calendar.getInstance()
        cal.time = Date()

        //得到今天与星期一相隔几天
        var w = cal.get(Calendar.DAY_OF_WEEK) - 2
        if (w < 0)
            w = 0

        //将天数转换成毫秒数
        val dayToMill = w * 1000 * 60 * 60 * 24

        //周一的日期
        val simpleDateFormat = SimpleDateFormat("yyyy.MM.dd")
        val date = Date(System.currentTimeMillis() - dayToMill + 7 * addDay * 1000 * 60 * 60 * 24 )
        val firstDay = simpleDateFormat.format(date)

        //周日的日期
        val simpleDateFormat2 = SimpleDateFormat("dd")
        val date2 = Date(System.currentTimeMillis() + (6 - w + 7 * addDay) * 1000 * 60 * 60 * 24)
        val lastDay = simpleDateFormat2.format(date2)

        //组装日期
        return "$firstDay - $lastDay(周)"
    }

    /**
     * 获取月区间日期
     */
    fun getMonthDate() : String{


        val c = java.util.Calendar.getInstance()
        return "${c.get(java.util.Calendar.YEAR)}.${c.get(java.util.Calendar.MONTH) + 1}  (月)"

    }

    /**
     * 季度期间日期
     */
    fun getQuarterDate() : String{

        val simpleDateFormat = SimpleDateFormat("yyyy.MM")
        val date = Date(currentQuarterStartTime!!.time)
        val firstDay = simpleDateFormat.format(date)

        val simpleDateFormat2 = SimpleDateFormat("MM")
        val date2 = Date(currentQuarterEndTime!!.time)
        val lastDay = simpleDateFormat2.format(date2)

        return "$firstDay - $lastDay(季)"
    }

    /**
     * 获取年份
     */
    fun getYearDate() : String{
        val c = java.util.Calendar.getInstance()
        val currentYear = c.get(java.util.Calendar.YEAR)
        return "$currentYear(年)"
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

    private val longSdf = SimpleDateFormat("yyyy-MM-dd")
    private val shortSdf = SimpleDateFormat("yyyy-MM-dd")
    /**
     * 当前季度的开始时间，即2012-01-1 00:00:00
     * @return
     */
    private val currentQuarterStartTime: Date?
        get() {
            val c = java.util.Calendar.getInstance()
            val currentMonth = c.get(java.util.Calendar.MONTH) + 1
            var quarterStart: Date? = null
            try {
                when (currentMonth) {
                    in 1..3 -> c.set(currentMonth, 0)
                    in 4..6 -> c.set(currentMonth, 3)
                    in 7..9 -> c.set(currentMonth, 4)
                    in 10..12 -> c.set(currentMonth, 9)
                }
                c.set(java.util.Calendar.DATE, 1)
                println(c.time)
                quarterStart = longSdf.parse(shortSdf.format(c.time) + " 00:00:00")
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return quarterStart
        }

    /**
     * 当前季度的结束时间，即2012-03-31 23:59:59
     * @return
     */
    private val currentQuarterEndTime: Date?
        get() {
            val c = java.util.Calendar.getInstance()
            val currentMonth = c.get(java.util.Calendar.MONTH) + 1
            var quarterEnd: Date? = null
            try {
                when (currentMonth) {
                    in 1..3 -> {
                        c.set(java.util.Calendar.MONTH, 2)
                        c.set(java.util.Calendar.DATE, 31)
                    }
                    in 4..6 -> {
                        c.set(java.util.Calendar.MONTH, 5)
                        c.set(java.util.Calendar.DATE, 30)
                    }
                    in 7..9 -> {
                        c.set(java.util.Calendar.MONTH, 8)
                        c.set(java.util.Calendar.DATE, 30)
                    }
                    in 10..12 -> {
                        c.set(java.util.Calendar.MONTH, 11)
                        c.set(java.util.Calendar.DATE, 31)
                    }
                }
                quarterEnd = longSdf.parse(shortSdf.format(c.time) + " 23:59:59")
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return quarterEnd
        }

}