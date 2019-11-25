package com.w.xiaolanlaia.util

import android.text.Editable
import android.text.TextWatcher
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

open class SimpleTextWatch : TextWatcher{
    override fun afterTextChanged(s: Editable?) {}

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

}