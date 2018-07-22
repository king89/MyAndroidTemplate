package com.example.king.mytemplate.data.remote

import com.example.king.mytemplate.data.local.Item
import com.example.king.mytemplate.model.MyItem
import io.reactivex.Observable
import retrofit2.http.GET

interface ItemApi {
    @GET("posts")
    fun getLists():Observable<List<MyItem>>
}