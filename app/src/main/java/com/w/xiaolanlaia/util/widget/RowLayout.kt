package com.w.xiaolanlaia.util.widget

import android.content.Context
import android.graphics.LinearGradient
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.w.xiaolanlaia.R

/**
 *  @author  xiaolanlaia
 *
 *  @create  2019/11/23 16:41
 *
 */


class RowLayout : LinearLayout {

    lateinit var view : View
    private lateinit var leftTv : TextView
    private lateinit var rightEt : EditText


    constructor(context: Context) : super(context)

    constructor(context: Context,attr : AttributeSet) : super(context,attr){

        view = LayoutInflater.from(context).inflate(R.layout.row_layout,this)
        leftTv = view.findViewById(R.id.left_tv)
        rightEt = view.findViewById(R.id.right_et)

        val typeArray = context.obtainStyledAttributes(attr,R.styleable.RowLayout)

        leftTv.text = typeArray.getString(R.styleable.RowLayout_left_text)



        typeArray.recycle()



    }
}