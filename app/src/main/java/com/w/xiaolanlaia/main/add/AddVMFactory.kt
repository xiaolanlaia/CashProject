package com.w.xiaolanlaia.main.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

/**
 *  @author  xiaolanlaia
 *
 *  @create  2019/11/23 16:17
 *
 */


class AddVMFactory (val repository: AddRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AddViewModel(repository) as T
    }
}