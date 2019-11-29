package com.w.xiaolanlaia.util

import android.widget.Toast
import com.w.xiaolanlaia.common.MyApplication.Companion.context

/**
 *  @author  xiaolanlaia
 *
 *  @create  2019/11/25 15:13
 *
 */


object ToastHelper {

    private var toast : Toast? = null


    fun show(str : String){

        if (toast == null){

            Toast.makeText(context,str,Toast.LENGTH_SHORT).show()
        }

    }

    fun show(str: String,type : Int){
        if (toast == null){

            Toast.makeText(context,str,Toast.LENGTH_LONG).show()
        }
    }


}