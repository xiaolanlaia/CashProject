package com.w.xiaolanlaia.main.add

import android.text.Editable
import androidx.lifecycle.ViewModel
import com.w.xiaolanlaia.util.SimpleTextWatch

/**
 *  @author  xiaolanlaia
 *
 *  @create  2019/11/23 16:16
 *
 */


class AddViewModel (val repository: AddRepository) : ViewModel() {



    val projectNumTextChangeListener = object : SimpleTextWatch(){
        override fun afterTextChanged(s: Editable?) {

        }

    }
}