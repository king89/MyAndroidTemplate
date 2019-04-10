package com.example.king.mytemplate.domain.data.remote

import com.example.king.mytemplate.domain.data.BaseUrl
import com.example.king.mytemplate.domain.data.ItemDataSource
import com.example.king.mytemplate.domain.model.ItemMapper
import com.example.king.mytemplate.domain.model.MyItem
import io.reactivex.Completable
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteRetrofitItemDataSource @Inject constructor(
        @BaseUrl baseUrl: String,
        val itemMapper: ItemMapper,
        httpClient: OkHttpClient
) : ItemDataSource {
    override fun cacheDataList(data: List<MyItem>): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDataList(): Single<List<MyItem>> {
        return api.getLists().singleOrError()
    }

    private val api: ItemApi = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(ItemApi::class.java)

}