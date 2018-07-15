package com.example.king.mytemplate.data.local

import com.example.king.mytemplate.data.ItemDataSource
import com.example.king.mytemplate.model.ItemMapper
import com.example.king.mytemplate.model.MyItem
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalItemDataSource @Inject constructor(
        val itemDAO: ItemDAO,
        val itemMapper: ItemMapper
) : ItemDataSource {

    override fun getDataList(): Single<List<MyItem>> {
        return itemDAO.getItems().toObservable()
                .flatMapIterable { it }
                .map { itemMapper.mapToMyItem(it) }
                .toList()
    }
}