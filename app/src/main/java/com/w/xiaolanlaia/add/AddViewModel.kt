package com.w.xiaolanlaia.add

import android.text.Editable
import android.text.TextUtils
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.w.xiaolanlaia.R
import com.w.xiaolanlaia.database.AppDataBase
import com.w.xiaolanlaia.database.projectDB.ProjectEntity
import com.w.xiaolanlaia.util.CodeUtil.toast
import com.w.xiaolanlaia.util.SimpleTextWatch

/**
 *  @author  xiaolanlaia
 *
 *  @create  2019/11/23 16:16
 *
 */


class AddViewModel (val repository: AddRepository) : ViewModel() {




    val sDao  = AppDataBase.instance.getProjectDao()

    val sList  = mutableListOf<ProjectEntity>()

    var sProjectNum = MutableLiveData<String>()
    var sTime       = MutableLiveData<String>()
    var sLocation   = MutableLiveData<String>()
    var sProject    = MutableLiveData<String>()
    var sType       = MutableLiveData<String>()
    var sMoney      = MutableLiveData<String>()


    val saveOnClickListener = View.OnClickListener {

        when(it.id){

            R.id.save_tv -> {

                if (checkEmpty()) return@OnClickListener

                sList.add(

                    ProjectEntity(
                        sDao.getAllProjects().size + 1,
                        sProjectNum.value,
                        sTime.value,
                        sLocation.value,
                        sProject.value,
                        sType.value,
                        sMoney.value
                    )

                )

                sDao.insertAll(sList)

                toast("kk")
            }

        }
    }








    private fun checkEmpty() : Boolean{

        Log.d("__sProjectNum.value","${sProjectNum.value}")

        if (
            TextUtils.isEmpty(sProjectNum.value) ||
            TextUtils.isEmpty(sTime.value)       ||
            TextUtils.isEmpty(sLocation.value)   ||
            TextUtils.isEmpty(sProject.value)    ||
            TextUtils.isEmpty(sType.value)       ||
            TextUtils.isEmpty(sMoney.value)){

            toast("请输入信息")
            return true
        }

        return false
    }


    val localTextChangeListener = object : SimpleTextWatch(){
        override fun afterTextChanged(s: Editable?) {
            sLocation.value = s.toString()
        }
    }

    val sortTextChangeListener = object : SimpleTextWatch(){
        override fun afterTextChanged(s: Editable?) {
            sProject.value = s.toString()
        }
    }

    val subdivisionTextChangeListener = object : SimpleTextWatch(){
        override fun afterTextChanged(s: Editable?) {
            sProject.value = s.toString()
        }
    }

    val typeTextChangeListener = object : SimpleTextWatch(){
        override fun afterTextChanged(s: Editable?) {
            sType.value = s.toString()
        }
    }

    val moneyTextChangeListener = object : SimpleTextWatch(){
        override fun afterTextChanged(s: Editable?) {
            sMoney.value = s.toString()
        }
    }

}