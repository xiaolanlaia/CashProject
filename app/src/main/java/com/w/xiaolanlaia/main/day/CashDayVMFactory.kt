package com.w.xiaolanlaia.main.day

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class CashDayVMFactory (private val repository: CashDayRepository) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CashDayViewModel(repository) as T
    }
}