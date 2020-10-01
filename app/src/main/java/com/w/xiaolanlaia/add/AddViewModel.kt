package com.w.xiaolanlaia.add

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.icu.text.SimpleDateFormat
import android.os.Handler
import android.text.Editable
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.RelativeLayout
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cn.qqtheme.framework.picker.OptionPicker
import cn.qqtheme.framework.widget.WheelView
import com.w.xiaolanlaia.R
import com.w.xiaolanlaia.database.AppDataBase
import com.w.xiaolanlaia.database.projectDB.ProjectEntity
import com.w.xiaolanlaia.util.CodeUtil.toast
import com.w.xiaolanlaia.util.SimpleTextWatch
import com.w.xiaolanlaia.util.widget.wheel.PickCityUtil
import com.zaaach.citypicker.CityPicker
import com.zaaach.citypicker.adapter.OnPickListener
import com.zaaach.citypicker.model.City
import com.zaaach.citypicker.model.LocateState
import com.zaaach.citypicker.model.LocatedCity
import kotlinx.android.synthetic.main.add_time_row.view.*
import kotlinx.android.synthetic.main.row_layout.view.*
import org.jetbrains.anko.alignParentRight
import org.jetbrains.anko.centerHorizontally
import java.util.*

/**
 *  @author  xiaolanlaia
 *
 *  @create  2019/11/23 16:16
 *
 */


@Suppress("DEPRECATION")
class AddViewModel (val repository: AddRepository) : ViewModel() {




    val sDao  = AppDataBase.instance.getProjectDao()

    val sList  = mutableListOf<ProjectEntity>()

    var sProjectNum = MutableLiveData<String>()
    var sTime       = MutableLiveData<String>()
    var sType       = MutableLiveData<String>()
    var sSort       = MutableLiveData<String>()
    var sConcrete   = MutableLiveData<String>()
    var sMoney      = MutableLiveData<String>()

    val usageArray = arrayOf("收入","支出")
    val expendType = arrayOf(
        "1，餐费及食品",
        "2，交通",
        "3，水果",
        "4，非酒精饮料",
        "5，零食",
        "6，手机充值",
        "7，居家用品",
        "8，医疗保健",
        "9，保险",
        "10，燃气水电费",
        "11，文化",
        "12，服装鞋帽",
        "13，房租",
        "14，娱乐",
        "15，电子产品及相关",
        "16，家装、家庭设备及维修",
        "17，金融及相关",
        "18，酒精饮料"
    )




    val addFragmentClick = View.OnClickListener {

        when(it.id){

            R.id.save_tv -> {

//                sDao.deleteAll()

                if (checkEmpty()) return@OnClickListener

                sList.add(

                    ProjectEntity(
                        sDao.getAllProjects().size + 1,
                        sProjectNum.value,
                        sTime.value,
                        sSort.value,
                        sType.value,
                        sMoney.value
                    )

                )

                sDao.insertAll(sList)


                toast("保存成功")
            }

            R.id.time_row ->{
                PickCityUtil.showTimePickView(it.context) { s ->
                    sTime.value = s
                }
            }


            R.id.type_row -> {


                showPicker(it,"请选择借款期数",usageArray,1)


            }



            R.id.sort_row -> {
                showPicker(it,"请选择借款期数",expendType,2)
            }

        }
    }


    fun setTimeRow(timeStr : String,timeRow : View){


        val newDate = Date(timeStr.toLong())

        val wholeFormat = SimpleDateFormat("yyyy-MM-dd")
        val yearFormat = SimpleDateFormat("yyyy")
        val monthFormat = SimpleDateFormat("MM")
        val dayFormat = SimpleDateFormat("dd")
        val hourFormat = SimpleDateFormat("HH")
        val minuteFormat = SimpleDateFormat("mm")


        sTime.value = wholeFormat.format(newDate)
        timeRow.time_row_year.text = yearFormat.format(newDate)
        timeRow.time_row_month.text = monthFormat.format(newDate)
        timeRow.time_row_day.text = dayFormat.format(newDate)
        timeRow.time_row_hour.text = hourFormat.format(newDate)
        timeRow.time_row_minute.text = minuteFormat.format(newDate)

    }


    fun setLocation(context: Context){
        CityPicker.getInstance()
            .setFragmentManager((context as FragmentActivity).supportFragmentManager)  //此方法必须调用
            .enableAnimation(true)  //启用动画效果
            .setLocatedCity(LocatedCity("杭州", "浙江", "101210101")) //APP自身已定位的城市，默认为null（定位失败）
            .setHotCities(null)
            .setOnPickListener(object : OnPickListener {
                override fun onPick(position: Int, data: City) {

//                    sLocation.value = data.province + data.name

                }

                override fun onLocate() {
                    //开始定位，这里模拟一下定位
                    Handler().postDelayed({
                        //定位完成之后更新数据
                        CityPicker.getInstance()
                            .locateComplete(LocatedCity("深圳", "广东", "101280601"), LocateState.SUCCESS)
                    }, 2000)
                }
            })
            .show()
    }

    private fun showPicker(view: View, title : String, array: Array<String>,type : Int) {
        val optionPicker = OptionPicker(view.context as Activity, array)
        optionPicker.setTitleText(title)
        optionPicker.setTextSize(18)
        optionPicker.setCancelTextColor(Color.BLACK)
        optionPicker.setSubmitTextColor(Color.BLACK)
        optionPicker.setTitleTextSize(20)
        optionPicker.setLineSpaceMultiplier(3.5f)
        optionPicker.setTopLineColor(Color.TRANSPARENT)
        optionPicker.setDividerConfig(WheelView.DividerConfig().setVisible(false))
//        optionPicker.setShadowColor(view.context.getColor(R.color.picker_select_background), 14)
//        optionPicker.setTextColor(view.context.getColor(R.color.theme_color))
        optionPicker.setOffset(2)
        optionPicker.show()
        //设置上面三个View的布局（一定要在show()方法之后）
        val cancelButton = optionPicker.cancelButton
        val submitButton = optionPicker.submitButton
        val title = optionPicker.titleView
        val cancelLP = RelativeLayout.LayoutParams(cancelButton.layoutParams)
        val submitLP = RelativeLayout.LayoutParams(submitButton.layoutParams)
        val titleLP = RelativeLayout.LayoutParams(title.layoutParams)
        cancelLP.setMargins(30, 10, 0, 0)
        submitLP.setMargins(0, 10, 30, 0)
        titleLP.setMargins(0, 20, 0, 0)
        submitLP.alignParentRight()
        titleLP.centerHorizontally()
        cancelButton.layoutParams = cancelLP
        submitButton.layoutParams = submitLP
        title.layoutParams = titleLP
        //设置点击事件
        optionPicker.setOnOptionPickListener(object : OptionPicker.OnOptionPickListener() {
            override fun onOptionPicked(index: Int, item: String?) {

                view.right_tv.text = item

                when(type){

                    1 -> {
                        sType.value = item
                    }

                    2 -> {
                        sSort.value = item
                    }
                }

            }
        })
    }








    private fun checkEmpty() : Boolean{

        Log.d("__value-sProjectNum","${sProjectNum.value}")
        Log.d("__value-sTime","${sTime.value}")
        Log.d("__value-sType","${sType.value}")
        Log.d("__value-sSort","${sSort.value}")
        Log.d("__value-sConcrete","${sConcrete.value}")
        Log.d("__value-sMoney","${sMoney.value}")


        if (
            TextUtils.isEmpty(sProjectNum.value) ||
            TextUtils.isEmpty(sTime.value)       ||
            TextUtils.isEmpty(sType.value)       ||
            TextUtils.isEmpty(sSort.value)       ||
            TextUtils.isEmpty(sConcrete.value)   ||
            TextUtils.isEmpty(sMoney.value)){

            toast("请输入信息")
            return true
        }

        return false
    }


    val subdivisionTextChangeListener = object : SimpleTextWatch(){
        override fun afterTextChanged(s: Editable?) {
            sConcrete.value = s.toString()
        }
    }


    val moneyTextChangeListener = object : SimpleTextWatch(){
        override fun afterTextChanged(s: Editable?) {
            sMoney.value = s.toString()
        }
    }

}