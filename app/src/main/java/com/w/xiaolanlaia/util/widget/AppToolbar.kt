package com.w.xiaolanlaia.util.widget

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.w.xiaolanlaia.R

/**
 *  @author  xiaolanlaia
 *
 *  @create  2019/7/22 8:12
 *
 */


class AppToolbar : RelativeLayout{

    private lateinit var view : View

    private lateinit var title : TextView

    private lateinit var back : ImageView

    private lateinit var transfer : ImageView

    private lateinit var status : View

    constructor(context : Context?) : super(context)

    constructor(context : Context, attrs : AttributeSet) : super(context,attrs){

        view = LayoutInflater.from(context).inflate(R.layout.include_toolbar,this)

        status = view.findViewById(R.id.toolbar_status_height)
        title = view.findViewById(R.id.title)
        back = view.findViewById(R.id.toolbar_back)
        transfer = view.findViewById(R.id.transfer)

        //获取自定义属性
        var typeArray = context.obtainStyledAttributes(attrs,R.styleable.AppToolbar)
        var titleText = typeArray.getString(R.styleable.AppToolbar_toolbar_title)

        title.text = titleText

        var style = typeArray.getInt(R.styleable.AppToolbar_toolbar_style,0)

        when(style){

            0 -> dayToolbar()
        }


        typeArray.recycle()

    }

    fun dayToolbar(){

        back.visibility = View.VISIBLE
        transfer.visibility = View.VISIBLE
        title.visibility = View.VISIBLE
    }


}