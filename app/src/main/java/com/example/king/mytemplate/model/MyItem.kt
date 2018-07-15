package com.example.king.mytemplate.model

import com.example.king.mytemplate.data.local.Item
import java.io.Serializable
import javax.inject.Inject

data class MyItem(val title: String = "",
        val description: String = "") : Serializable

class ItemMapper @Inject constructor() {
    fun mapToMyItem(item: Item): MyItem {
        return MyItem(item.mTitle, item.mDescription)
    }
}