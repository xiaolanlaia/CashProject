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
import com.w.xiaolanlaia.util.SizeUtil
import java.util.*

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

    private var currentTime = 0L
    private var lastTime = 0L

    private var clickTime = 0


    constructor(context : Context?) : super(context)

    constructor(context : Context, attrs : AttributeSet) : super(context,attrs){

        view = LayoutInflater.from(context).inflate(R.layout.include_toolbar,this)

        status = view.findViewById(R.id.toolbar_status_height)
        title = view.findViewById(R.id.toolbar_title)
        back = view.findViewById(R.id.toolbar_back)
        transfer = view.findViewById(R.id.toolbar_transfer)

        //获取自定义属性
        val typeArray = context.obtainStyledAttributes(attrs,R.styleable.AppToolbar)
        val titleText = typeArray.getString(R.styleable.AppToolbar_toolbar_title)

        title.text = titleText

        val style = typeArray.getInt(R.styleable.AppToolbar_toolbar_style,0)

        when(style){

            0 -> dayToolbar()
        }


        back.setOnClickListener {

            if (clickTime == 0){
                lastTime = Date().time
                clickTime = 1


            }else{
                clickTime = 0
                currentTime = Date().time
                if (currentTime - lastTime > 1000L){

                    (view.context as Activity).finish()

                    lastTime = currentTime


                }
            }



        }


        typeArray.recycle()

    }

    private fun dayToolbar(){

        back.visibility = View.VISIBLE
        transfer.visibility = View.VISIBLE
        title.visibility = View.VISIBLE
    }

    fun fitTransparentStatus(){

        val statusHeight = SizeUtil.getStatusHeight(context)
        val statusLayoutParams = status.layoutParams
        statusLayoutParams.height = statusHeight
        status.layoutParams = statusLayoutParams
        //增加整体Toolbar的高度
        val viewLayoutParams = view.layoutParams
        viewLayoutParams.height += statusHeight
        view.layoutParams = viewLayoutParams
    }


}