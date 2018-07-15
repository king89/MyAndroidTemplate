package com.example.king.mytemplate.data.remote

import com.example.king.mytemplate.data.BaseUrl
import com.example.king.mytemplate.data.ItemDataSource
import com.example.king.mytemplate.model.ItemMapper
import com.example.king.mytemplate.model.MyItem
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteRetrofitItemDataSource @Inject constructor(
        @BaseUrl baseUrl: String,
        val itemMapper: ItemMapper,
        httpClient: OkHttpClient
) : ItemDataSource {
    override fun getDataList(): Single<List<MyItem>> {
        return api.getLists()
                .flatMapIterable { it }
                .map { itemMapper.mapToMyItem(it) }
                .toList()
    }

    private val api: ItemApi = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ItemApi::class.java)

}