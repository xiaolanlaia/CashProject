package com.w.xiaolanlaia.main.year

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 *  @author  xiaolanlaia
 *
 *  @create  2019/7/19 15:41
 *
 */


class YearVMFactory (val repository: YearRepository) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return YearViewModel(repository) as T
    }
}