package com.example.king.mytemplate.domain.data.remote

import com.example.king.mytemplate.domain.model.MyItem
import io.reactivex.Observable
import retrofit2.http.GET

interface ItemApi {
    @GET("posts")
    fun getLists():Observable<List<MyItem>>
}