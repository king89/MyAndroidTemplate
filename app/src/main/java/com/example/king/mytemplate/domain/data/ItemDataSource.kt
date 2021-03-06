package com.example.king.mytemplate.domain.data

import com.example.king.mytemplate.domain.model.MyItem
import io.reactivex.Completable
import io.reactivex.Single

interface ItemDataSource {
    fun getDataList(): Single<List<MyItem>>

    fun cacheDataList(data:List<MyItem>): Completable
}