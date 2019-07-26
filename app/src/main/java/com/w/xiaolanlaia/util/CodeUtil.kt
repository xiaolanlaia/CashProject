package com.w.xiaolanlaia.util

import android.widget.Toast
import com.w.xiaolanlaia.common.MyApplication

/**
 *  @author  xiaolanlaia
 *
 *  @create  2019/7/23 10:08
 *
 */


object CodeUtil {

    fun toast(str:String){
        Toast.makeText(MyApplication.context,str,Toast.LENGTH_SHORT).show()
    }
}