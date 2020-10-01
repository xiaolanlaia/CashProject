package com.w.xiaolanlaia.add

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.w.xiaolanlaia.R
import com.w.xiaolanlaia.base.BaseMVVMFragment
import com.w.xiaolanlaia.databinding.FragmentAddBinding
import com.w.xiaolanlaia.util.widget.AppToolbar
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add_fragment.*
import kotlinx.android.synthetic.main.fragment_add_fragment.view.*
import kotlinx.android.synthetic.main.include_toolbar.view.*
import kotlinx.android.synthetic.main.row_layout.view.*
import java.util.*

/**
 *  @author  xiaolanlaia
 *
 *  @create  2019/11/23 16:15
 *
 */


class AddFragment : BaseMVVMFragment<FragmentAddBinding, AddViewModel>() {



    override fun initViewModel(): AddViewModel = ViewModelProviders.of(
        this, AddVMFactory(AddRepository())
    ).get(
        AddViewModel::class.java
    )

    override fun initContentViewID(): Int = R.layout.fragment_add

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews.vm = vm


        val mediaToolbar = activity!!.findViewById<AppToolbar>(R.id.mediator_toolbar)

        mediaToolbar.save_tv.setOnClickListener(vm.addFragmentClick)
        fragment_add.time_row.setOnClickListener(vm.addFragmentClick)
        fragment_add.type_row.setOnClickListener(vm.addFragmentClick)
        fragment_add.sort_row.setOnClickListener(vm.addFragmentClick)


        project_num_row.right_tv.text = SpannableStringBuilder(Date().time.toString())

        vm.sProjectNum.value = project_num_row.right_tv.text.toString()


//        vm.setTimeRow(project_num_row.right_tv.text.toString(),time_row)


        subdivision_row.right_et.addTextChangedListener(vm.subdivisionTextChangeListener)

        money_row.right_et.addTextChangedListener(vm.moneyTextChangeListener)

        vm.sTime.observe(this,androidx.lifecycle.Observer {

            time_row.right_tv.text = it

        })



    }

}