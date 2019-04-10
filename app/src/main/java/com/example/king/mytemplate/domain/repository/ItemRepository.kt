package com.example.king.mytemplate.domain.repository

import com.example.king.mytemplate.domain.data.ItemDataSource
import com.example.king.mytemplate.domain.data.Local
import com.example.king.mytemplate.domain.data.Remote
import com.example.king.mytemplate.domain.model.MyItem
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

interface ItemRepository {
    //Can combine as one method, use local as cache
    fun getLocalDataList(): Single<List<MyItem>>

    fun getRemoteDataList(): Single<List<MyItem>>

    fun cacheDataList(list: List<MyItem>): Completable

}

class ItemRepositoryImpl @Inject constructor(
        @Local val localDataSource: ItemDataSource,
        @Remote val remoteDataSource: ItemDataSource
) : ItemRepository {
    override fun getRemoteDataList(): Single<List<MyItem>> = remoteDataSource.getDataList()

    override fun getLocalDataList(): Single<List<MyItem>> = localDataSource.getDataList()

    override fun cacheDataList(list: List<MyItem>): Completable {
        return localDataSource.cacheDataList(list)
    }
}