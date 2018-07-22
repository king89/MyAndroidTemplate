package com.example.king.mytemplate.ui.main

import android.arch.lifecycle.MutableLiveData
import com.example.king.mytemplate.base.BaseViewModel
import com.example.king.mytemplate.domain.usecase.GetListUseCase
import com.example.king.mytemplate.model.MyItem
import com.example.king.mytemplate.util.Lg
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(private val getListUseCase: GetListUseCase) :
        BaseViewModel() {
    var dataList = MutableLiveData<MutableList<MyItem>>()
    fun getList() {
        getListUseCase.execute()
                .subscribeOn(Schedulers.io())
                .subscribe({
            Lg.d("${it}")
            dataList.postValue(it.toMutableList())
        }, {
            Lg.e("error", it)
        })
    }
}
