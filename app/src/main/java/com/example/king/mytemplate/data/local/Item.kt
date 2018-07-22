package com.example.king.mytemplate.data.local

import android.arch.persistence.room.Entity
import java.util.UUID.randomUUID
import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull
import android.support.annotation.Nullable
import java.util.UUID

@Entity(tableName = "items")
class Item(
        @Nullable
        @ColumnInfo(name = "title")
        var mTitle: String,

        @Nullable
        @ColumnInfo(name = "description")
        var mDescription: String,

        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "entryid")
        var mId: String,

        @ColumnInfo(name = "completed")
        var mCompleted: Boolean
) {
    /**
     * Use this constructor to create a new active Task.
     *
     * @param title       title of the task
     * @param description description of the task
     */
    @Ignore
    constructor(@Nullable title: String, @Nullable description: String) : this(title, description,
            UUID.randomUUID().toString(), false)

    /**
     * Use this constructor to create an active Task if the Task already has an id (copy of another
     * Task).
     *
     * @param title       title of the task
     * @param description description of the task
     * @param id          id of the task
     */
    @Ignore
    constructor(@Nullable title: String, @Nullable description: String, @NonNull id: String) : this(
            title, description, id, false)

    /**
     * Use this constructor to create a new completed Task.
     *
     * @param title       title of the task
     * @param description description of the task
     * @param completed   true if the task is completed, false if it's active
     */
    @Ignore
    constructor(@Nullable title: String, @Nullable description: String, completed: Boolean) : this(
            title, description, UUID.randomUUID().toString(), completed)

}