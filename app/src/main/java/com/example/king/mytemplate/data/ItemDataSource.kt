package com.example.king.mytemplate.data

import com.example.king.mytemplate.model.MyItem
import io.reactivex.Single

interface ItemDataSource {
    fun getDataList(): Single<List<MyItem>>
}