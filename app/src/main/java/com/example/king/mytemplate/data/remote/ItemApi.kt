package com.example.king.mytemplate.data.remote

import com.example.king.mytemplate.data.local.Item
import io.reactivex.Observable
import retrofit2.http.GET

interface ItemApi {
    @GET("items")
    fun getLists():Observable<List<Item>>
}