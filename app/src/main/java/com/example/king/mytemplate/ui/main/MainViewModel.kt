package com.example.king.mytemplate.ui.main

import android.arch.lifecycle.MutableLiveData
import com.example.king.mytemplate.base.BaseViewModel
import com.example.king.mytemplate.domain.usecase.GetListUseCase
import com.example.king.mytemplate.model.MyItem

class MainViewModel(private val getListUseCase: GetListUseCase) : BaseViewModel() {
    val dataList = MutableLiveData<List<MyItem>>()
    fun getList(){
        getListUseCase.execute()
    }
}
