package com.w.xiaolanlaia.util.widget

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import com.w.xiaolanlaia.R
import com.w.xiaolanlaia.util.SizeUtil

/**
 *  @author  xiaolanlaia
 *
 *  @create  2019/7/22 8:12
 *
 */


class AppToolbar : RelativeLayout{

    private lateinit var view : View

    private lateinit var title : TextView

    private lateinit var saveTv : TextView

    private lateinit var back : ImageView

    private lateinit var addIv : ImageView

    private lateinit var transfer : ImageView

    private lateinit var status : View

    private var lastTime = 0L

    private var style = 0


    constructor(context : Context?) : super(context)

    constructor(context : Context, attrs : AttributeSet) : super(context,attrs){

        view = LayoutInflater.from(context).inflate(R.layout.include_toolbar,this)

        status = view.findViewById(R.id.toolbar_status_height)
        title = view.findViewById(R.id.toolbar_title)
        back = view.findViewById(R.id.toolbar_back)
        addIv = view.findViewById(R.id.add_iv)
        transfer = view.findViewById(R.id.toolbar_transfer)
        saveTv = view.findViewById(R.id.save_tv)


        //获取自定义属性
        val typeArray = context.obtainStyledAttributes(attrs,R.styleable.AppToolbar)

        style = typeArray.getInt(R.styleable.AppToolbar_toolbar_style,0)

        when(style){

            0 -> dayToolbar()

            1 -> mediatorToolbar()

            2 -> titleAndBack()


        }


        back.setOnClickListener {

            if (System.currentTimeMillis() - lastTime > 1000L){
                Toast.makeText(context,"再点击一次退出应用",Toast.LENGTH_SHORT).show()
                lastTime = System.currentTimeMillis()

            }else{
                (view.context as Activity).finish()

            }

        }


        typeArray.recycle()

    }

    private fun titleAndBack(){
        back.visibility = View.VISIBLE
        title.visibility = View.VISIBLE
    }

    private fun dayToolbar(){
        back.visibility = View.VISIBLE
        transfer.visibility = View.VISIBLE
        addIv.visibility = View.VISIBLE
        title.visibility = View.VISIBLE
    }

    private fun mediatorToolbar(){
        back.visibility = View.VISIBLE
        title.visibility = View.VISIBLE
        saveTv.visibility = View.VISIBLE


    }

    fun setTitleStyle(style : Int){

    }

    fun fitTransparentStatus(){

        val statusHeight = SizeUtil.getStatusHeight(this.context)
        val statusLayoutParams = status.layoutParams
        statusLayoutParams.height = statusHeight
        status.layoutParams = statusLayoutParams
        //增加整体Toolbar的高度
        val viewLayoutParams = view.layoutParams
        viewLayoutParams.height += statusHeight
        view.layoutParams = viewLayoutParams
    }

    fun setBackOnClickListener(listener: OnClickListener){

        back.setOnClickListener(listener)
    }

    fun setTransferOnClickListener(listener : OnClickListener){
        transfer.setOnClickListener(listener)
    }

    fun setAddOnClickListener(listener: OnClickListener){

        addIv.setOnClickListener(listener)
    }

    fun setSaveOnClickListener(listener: OnClickListener){

        saveTv.setOnClickListener(listener)
    }


    companion object{

        /**
         * 绑定数据转换点击事件
         */
        @BindingAdapter("transferOnClick")
        @JvmStatic
        fun setTransferOnClick(view : AppToolbar,listener : OnClickListener){
            view.setTransferOnClickListener(listener)
        }

        /**
         * 新建按钮绑定点击事件
         */
        @BindingAdapter("addOnClick")
        @JvmStatic
        fun setAddOnClick(view : AppToolbar,listener : OnClickListener){
            view.setAddOnClickListener(listener)
        }
        /**
         * 保存按钮绑定点击事件
         */
        @BindingAdapter("saveOnClick")
        @JvmStatic
        fun setSaveOnClick(view : AppToolbar,listener : OnClickListener){
            view.setSaveOnClickListener(listener)
        }


    }


}