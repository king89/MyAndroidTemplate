package com.example.king.mytemplate.domain.repository

import com.example.king.mytemplate.data.ItemDataSource
import com.example.king.mytemplate.data.Local
import com.example.king.mytemplate.data.Remote
import com.example.king.mytemplate.model.MyItem
import io.reactivex.Single
import javax.inject.Inject

interface ItemRepository {
    //Can combine as one method, use local as cache
    fun getLocalDataList(): Single<List<MyItem>>
    fun getRemoteDataList(): Single<List<MyItem>>

}
class ItemRepositoryImpl @Inject constructor(
        @Local val localDataSource: ItemDataSource,
        @Remote val remoteDataSource: ItemDataSource
) : ItemRepository {
    override fun getRemoteDataList(): Single<List<MyItem>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLocalDataList(): Single<List<MyItem>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}