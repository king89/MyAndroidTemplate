package com.example.king.mytemplate.data.local

import com.example.king.mytemplate.data.ItemDataSource
import com.example.king.mytemplate.model.ItemMapper
import com.example.king.mytemplate.model.MyItem
import com.example.king.mytemplate.util.Lg
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalItemDataSource @Inject constructor(
        val itemDAO: ItemDAO,
        val itemMapper: ItemMapper
) : ItemDataSource {
    override fun cacheDataList(data: List<MyItem>): Completable {
        return Completable.fromRunnable {
            data.forEach {
                Lg.d("insert item: $it")
                itemDAO.insertTask(Item(it.title, it.description))
            }
        }
    }

    override fun getDataList(): Single<List<MyItem>> {
        return itemDAO.getItems().toObservable()
                .flatMapIterable { it }
                .map {
                    Lg.d("get item: ${it.mTitle}, ${it.mDescription}")
                    itemMapper.mapToMyItem(it)
                }
                .toList()
    }
}