package com.example.king.mytemplate.domain.data.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Single
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Update





@Dao
interface ItemDAO {
    /**
     * Select all items from the items table.
     *
     * @return all items.
     */
    @Query("SELECT * FROM items")
    fun getItems(): Single<List<Item>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTask(item: Item)

    /**
     * Update a task.
     *
     * @param task task to be updated
     * @return the number of tasks updated. This should always be 1.
     */
    @Update
    fun updateTask(item: Item): Int

}