package com.example.king.mytemplate.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.king.mytemplate.base.BaseActivityViewModel
import com.example.king.mytemplate.domain.usecase.GetListUseCase
import com.example.king.mytemplate.domain.model.MyItem
import com.example.king.mytemplate.util.Allopen
import com.example.king.mytemplate.util.Lg
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@Allopen
class MainActivityViewModel @Inject constructor(private val getListUseCase: GetListUseCase) :
    BaseActivityViewModel() {
    private val _dataList = MutableLiveData<List<MyItem>>()
    val dataList: LiveData<List<MyItem>> = _dataList

    fun getList() {
        getListUseCase.execute()
            .subscribeOn(Schedulers.io())
            .subscribe({
                Lg.d("${it}")
                _dataList.postValue(it.toMutableList())
            }, {
                Lg.e("error", it)
            })
            .apply { disposable.add(this) }
    }
}
