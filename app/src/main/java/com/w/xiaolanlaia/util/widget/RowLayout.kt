package com.w.xiaolanlaia.util.widget

import android.content.Context
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
    private lateinit var leftTV : TextView
    private lateinit var rightET : EditText
    private lateinit var rightTV : TextView

    var rowStyle : Int = 0


    constructor(context: Context) : super(context)

    constructor(context: Context,attr : AttributeSet) : super(context,attr){

        view = LayoutInflater.from(context).inflate(R.layout.row_layout,this)
        leftTV = view.findViewById(R.id.left_tv)
        rightET = view.findViewById(R.id.right_et)
        rightTV = view.findViewById(R.id.right_tv)

        val typeArray = context.obtainStyledAttributes(attr,R.styleable.RowLayout)

        leftTV.text = typeArray.getString(R.styleable.RowLayout_left_text)

        rowStyle = typeArray.getInt(R.styleable.RowLayout_row_layout_style,0)

        when(rowStyle) {

            0 -> {
                rightEdit()
            }

            1 -> {

                rightText()
            }
        }

        typeArray.recycle()



    }

    fun rightEdit(){

        leftTV.visibility = View.VISIBLE
        rightET.visibility = View.VISIBLE
        rightTV.visibility = View.GONE
    }

    fun rightText(){

        leftTV.visibility = View.VISIBLE
        rightET.visibility = View.GONE
        rightTV.visibility = View.VISIBLE
    }


}