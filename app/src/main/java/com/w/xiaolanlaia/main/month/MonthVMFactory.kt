package com.w.xiaolanlaia.main.month

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 *  @author  xiaolanlaia
 *
 *  @create  2019/7/19 15:15
 *
 */


@Suppress("UNCHECKED_CAST")
class MonthVMFactory (private val repository: MonthRepository) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MonthViewModel(repository) as T
    }
}