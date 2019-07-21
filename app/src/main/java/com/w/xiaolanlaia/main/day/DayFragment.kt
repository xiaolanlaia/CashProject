package com.w.xiaolanlaia.main.day

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.ViewModelProviders

import com.w.xiaolanlaia.R
import com.w.xiaolanlaia.databinding.CashDayBinding
import com.w.xiaolanlaia.base.BaseMVVMFragment
import com.w.xiaolanlaia.main.day.fragmentone.FragmentOne
import kotlinx.android.synthetic.main.cash_day.*

class DayFragment : BaseMVVMFragment<CashDayBinding, DayViewModel>(){
    override fun initContentViewID(): Int = R.layout.cash_day

    override fun initViewModel(): DayViewModel =
        ViewModelProviders.of(this, DayVMFactory(DayRepository())).get(DayViewModel::class.java)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        day_view_page.adapter = DayPageAdapter((context as FragmentActivity).supportFragmentManager)
        day_tab_layout.setupWithViewPager(day_view_page)
        day_view_page.currentItem = 0


    }

    class DayPageAdapter(fm : FragmentManager?) : FragmentPagerAdapter(fm){

        private val fragments = mutableListOf<Fragment>()
        private val titles = mutableListOf<String>()

        init {

            titles.add("支出")
            titles.add("收入")
            titles.add("全部")
            fragments.add(FragmentOne.newInstance(FragmentOne.TYPE_ONE))
            fragments.add(FragmentOne.newInstance(FragmentOne.TYPE_TWO))
            fragments.add(FragmentOne.newInstance(FragmentOne.TYPE_THREE))
        }

        override fun getItem(position: Int): Fragment = fragments[position]

        override fun getCount(): Int = fragments.size

        override fun getPageTitle(position: Int): CharSequence? = titles[position]
    }
}