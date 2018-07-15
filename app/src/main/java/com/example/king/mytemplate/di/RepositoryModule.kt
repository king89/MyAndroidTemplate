package com.example.king.mytemplate.di

import android.app.Application
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import com.example.king.mytemplate.data.BaseUrl
import com.example.king.mytemplate.data.ItemDataSource
import com.example.king.mytemplate.data.Local
import com.example.king.mytemplate.data.Remote
import com.example.king.mytemplate.data.local.ItemDAO
import com.example.king.mytemplate.data.local.ItemDataBase
import com.example.king.mytemplate.data.local.LocalItemDataSource
import com.example.king.mytemplate.data.remote.RemoteRetrofitItemDataSource
import com.example.king.mytemplate.model.ItemMapper
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

/*
Can add this class in different flavor
 */
@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    @Local
    abstract fun provideItemLocalDataSource(
            dataSource: LocalItemDataSource): ItemDataSource

    @Binds
    @Singleton
    @Remote
    abstract fun provideItemRemoteDataSource(
            dataSource: RemoteRetrofitItemDataSource): ItemDataSource

    @Module
    companion object {
        @Singleton
        @Provides
        @JvmStatic
        open fun provideDb(context: Application): ItemDataBase {
            return Room.databaseBuilder(
                    context.applicationContext,
                    ItemDataBase::class.java,
                    "item.db").build()
        }

        @Singleton
        @Provides
        @JvmStatic
        open fun provideItemDao(db: ItemDataBase): ItemDAO {
            return db.itemsDao()
        }


        @Singleton
        @Provides
        @BaseUrl
        @JvmStatic
        open fun providerBaseUrl(): String {
            return "http://127.0.0.1/"
        }

        @Singleton
        @Provides
        @JvmStatic
        open fun providerOkHttpClient(): OkHttpClient {
            return OkHttpClient().newBuilder()
                    .build()
        }
    }
}
