package com.w.xiaolanlaia.main.add

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.w.xiaolanlaia.R
import com.w.xiaolanlaia.base.BaseMVVMFragment
import com.w.xiaolanlaia.databinding.FragmentAddBinding
import kotlinx.android.synthetic.main.fragment_add_fragment.*
import kotlinx.android.synthetic.main.row_layout.view.*
import java.util.*

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

        project_num_row.right_et.text = SpannableStringBuilder(Date().time.toString())
        project_num_row.right_et.addTextChangedListener(vm.projectNumTextChangeListener)
    }
}