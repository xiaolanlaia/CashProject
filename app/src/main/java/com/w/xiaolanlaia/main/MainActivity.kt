package com.w.xiaolanlaia.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.w.xiaolanlaia.R
import com.w.xiaolanlaia.base.BaseActivity
import com.w.xiaolanlaia.main.day.DayFragment
import com.w.xiaolanlaia.main.month.MonthFragment
import com.w.xiaolanlaia.main.week.WeekFragment
import com.w.xiaolanlaia.main.year.YearFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 *  Create by xiaolanlaia on 2019/7/18
 */

class MainActivity : BaseActivity() {

    override fun initContentViewID(): Int  = R.layout.activity_main

    override fun isLightStatus(): Boolean = true

    override fun onViewCreated() {
        super.onViewCreated()

        mainFragmentManager = MainFragmentManager(supportFragmentManager,main_container.id)

        nav_view.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        nav_view.selectedItemId = 0



    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        when(item.itemId){
            R.id.day_item ->{
                mainFragmentManager.select(0)
                return@OnNavigationItemSelectedListener true
            }

            R.id.week_item -> {
                mainFragmentManager.select(1)
                return@OnNavigationItemSelectedListener true
            }

            R.id.month_item -> {
                mainFragmentManager.select(2)
                return@OnNavigationItemSelectedListener true
            }

            R.id.year_item -> {
                mainFragmentManager.select(3)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    lateinit var mainFragmentManager : MainFragmentManager

    class MainFragmentManager(private val fragmentManager: FragmentManager, private val containerId : Int){

        var lastFragment = 0
        var fragmentList = mutableListOf<Fragment>()

        init {
            fragmentList.add(DayFragment())
            fragmentList.add(WeekFragment())
            fragmentList.add(MonthFragment())
            fragmentList.add(YearFragment())
            fragmentManager.beginTransaction().replace(containerId,fragmentList[0]).commitAllowingStateLoss()
        }

        fun select(position : Int){
            val transaction = fragmentManager.beginTransaction()

            if(lastFragment != position){

                transaction.hide(fragmentList[lastFragment])

                if (!fragmentList[position].isAdded){
                    transaction.add(containerId,fragmentList[position])
                }

                transaction.show(fragmentList[position]).commitAllowingStateLoss()
                lastFragment = position
            }
        }
    }

}
