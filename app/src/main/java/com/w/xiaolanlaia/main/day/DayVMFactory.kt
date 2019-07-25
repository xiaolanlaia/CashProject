package com.w.xiaolanlaia.main.day

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DayVMFactory (private val repository: DayRepository) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DayViewModel(repository) as T
    }
}