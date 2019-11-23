package com.w.xiaolanlaia.main.add

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.w.xiaolanlaia.R
import com.w.xiaolanlaia.base.BaseMVVMFragment
import com.w.xiaolanlaia.databinding.FragmentAddBinding

/**
 *  @author  xiaolanlaia
 *
 *  @create  2019/11/23 16:15
 *
 */


class AddFragment : BaseMVVMFragment<FragmentAddBinding,AddViewModel>() {
    override fun initViewModel(): AddViewModel = ViewModelProviders.of(
        this,AddVMFactory(AddRepository())).get(AddViewModel::class.java
    )

    override fun initContentViewID(): Int = R.layout.fragment_add

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews.vm = vm


    }
}