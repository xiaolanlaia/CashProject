package com.w.xiaolanlaia.main.day

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.baoyz.widget.PullRefreshLayout

import com.w.xiaolanlaia.R
import com.w.xiaolanlaia.databinding.CashDayBinding
import com.w.xiaolanlaia.base.BaseMVVMFragment
import com.w.xiaolanlaia.main.day.consumptionrecycler.ConsumptionRecyclerFragment
import com.w.xiaolanlaia.main.day.consumptiontrend.ConsumptionTrendFragment
import kotlinx.android.synthetic.main.cash_day.*

class DayFragment : BaseMVVMFragment<CashDayBinding, DayViewModel>(){
    override fun initContentViewID(): Int = R.layout.cash_day

    override fun initViewModel(): DayViewModel =
        ViewModelProviders.of(this, DayVMFactory(DayRepository())).get(DayViewModel::class.java)

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews.vm = vm

        //第一级TabLayout
        day_view_page.adapter = DayPageAdapter((context as FragmentActivity).supportFragmentManager)
        day_tab_layout.setupWithViewPager(day_view_page)
        day_view_page.currentItem = 0

        //第二级TabLayout
        trend_view_page.adapter = TrendPageAdapter((context as FragmentActivity).supportFragmentManager)
        transfer_tab_layout.setupWithViewPager(trend_view_page)
        trend_view_page.currentItem = 0

        vm.pay.observe(this, Observer {
            tv_pay.text = "￥$it"
        })

        bindViews.pullRefresh.setRefreshStyle(PullRefreshLayout.STYLE_RING)
        bindViews.pullRefresh.setOnRefreshListener {

            view.postDelayed({

                bindViews.pullRefresh.setRefreshing(false)

            },1500)
        }


        vm.transferVisible.observe(this, Observer {
            if (it){
                bindViews.transferTabLayout.visibility = View.VISIBLE
                bindViews.trendViewPage.visibility = View.VISIBLE
                bindViews.dayViewPage.visibility = View.GONE
            }else{
                bindViews.transferTabLayout.visibility = View.GONE
                bindViews.trendViewPage.visibility = View.GONE
                bindViews.dayViewPage.visibility = View.VISIBLE



            }
        })


    }

    override fun fitTransparentStatus() {
        super.fitTransparentStatus()
        day_toolbar.fitTransparentStatus()
    }

    class DayPageAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm){

        private val fragments = mutableListOf<Fragment>()
        private val titles = mutableListOf<String>()

        init {

            titles.add("支出")
            titles.add("收入")
            titles.add("全部")
            fragments.add(ConsumptionRecyclerFragment.newInstance(ConsumptionRecyclerFragment.TYPE_ZERO))
            fragments.add(ConsumptionRecyclerFragment.newInstance(ConsumptionRecyclerFragment.TYPE_ONE))
            fragments.add(ConsumptionRecyclerFragment.newInstance(ConsumptionRecyclerFragment.TYPE_TWO))
        }

        override fun getItem(position: Int): Fragment = fragments[position]

        override fun getCount(): Int = fragments.size

        override fun getPageTitle(position: Int): CharSequence? = titles[position]
    }

    class TrendPageAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm){
        private val trendFragments = mutableListOf<Fragment>()
        private val trendTitle = mutableListOf<String>()

        init{
            trendTitle.add("数据统计")
            trendTitle.add("趋势统计")
            trendTitle.add("类型统计")
            trendFragments.add(ConsumptionTrendFragment.newInstance(ConsumptionTrendFragment.TYPE_THREE))
            trendFragments.add(ConsumptionTrendFragment.newInstance(ConsumptionTrendFragment.TYPE_FOUR))
            trendFragments.add(ConsumptionTrendFragment.newInstance(ConsumptionTrendFragment.TYPE_FIVE))
        }

        override fun getItem(position: Int): Fragment = trendFragments[position]

        override fun getCount(): Int = trendFragments.size

        override fun getPageTitle(position: Int): CharSequence? = trendTitle[position]
    }
}