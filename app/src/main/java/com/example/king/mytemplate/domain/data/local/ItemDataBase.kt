package com.example.king.mytemplate.domain.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [Item::class], version = 1)
abstract class ItemDataBase : RoomDatabase() {
    abstract fun itemsDao(): ItemDAO

}