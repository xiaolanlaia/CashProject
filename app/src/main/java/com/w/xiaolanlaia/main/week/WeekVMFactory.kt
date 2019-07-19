package com.w.xiaolanlaia.main.week

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 *  @author  xiaolanlaia
 *
 *  @create  2019/7/19 15:30
 *
 */


class WeekVMFactory (val repository: WeekRepository) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WeekViewModel(repository) as T
    }
}