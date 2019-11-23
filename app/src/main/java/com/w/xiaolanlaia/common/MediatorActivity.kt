package com.w.xiaolanlaia.common

import android.view.View
import com.w.xiaolanlaia.R
import com.w.xiaolanlaia.base.BaseActivity
import com.w.xiaolanlaia.main.add.AddFragment
import kotlinx.android.synthetic.main.activity_mediator.*
import kotlinx.android.synthetic.main.include_toolbar.*
import kotlinx.android.synthetic.main.include_toolbar.view.*

/**
 *  @author  xiaolanlaia
 *
 *  @create  2019/11/23 15:23
 *
 */


class MediatorActivity : BaseActivity(){

    var type = 0
    override fun initContentViewID(): Int  = R.layout.activity_mediator

    override fun isLightStatus(): Boolean = true

    override fun onViewCreated() {
        super.onViewCreated()

        mediator_toolbar.setBackOnClickListener(View.OnClickListener {
            finish()
        })


        type = intent.getIntExtra(Constants.SP.MEDIATOR_ACTIVITY_TYPE,0)

        val translation = supportFragmentManager.beginTransaction()

        when(type) {

            TYPE_ADD -> {

                toolbar_title.text = "新增"
                translation.replace(R.id.mediator_content,AddFragment(),"addFragment").commit()



            }

        }
    }

    override fun fitTransparentStatus() {
        mediator_toolbar.fitTransparentStatus()
    }

    companion object {

        const val TYPE_ADD = 0
    }


}