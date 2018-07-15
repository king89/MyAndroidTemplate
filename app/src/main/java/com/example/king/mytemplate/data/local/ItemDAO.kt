package com.example.king.mytemplate.data.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import io.reactivex.Single

@Dao
interface ItemDAO {
    /**
     * Select all items from the items table.
     *
     * @return all items.
     */
    @Query("SELECT * FROM items")
    fun getItems(): Single<List<Item>>
}