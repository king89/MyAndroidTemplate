package com.example.king.mytemplate.domain.model

import com.example.king.mytemplate.domain.data.local.Item
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import javax.inject.Inject

data class MyItem(
        @SerializedName("title")
        val title: String = "",
        @SerializedName("body")
        val description: String = "") : Serializable

class ItemMapper @Inject constructor() {
    fun mapToMyItem(item: Item): MyItem {
        return MyItem(item.mTitle, item.mDescription)
    }
}