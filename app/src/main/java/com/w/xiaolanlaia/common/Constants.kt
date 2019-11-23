package com.w.xiaolanlaia.common

import com.w.xiaolanlaia.BuildConfig


/**
 *  @author  xiaolanlaia
 *
 *  @create  2019/7/21 9:12
 *
 */
internal interface Constants{

    object SP {

        const val MEDIATOR_ACTIVITY_TYPE = "mediator_activity_type"

        const val PAY = "pay"
        const val INCOME = "income"

        const val environment = BuildConfig.ENVIRONMENT
    }
}

