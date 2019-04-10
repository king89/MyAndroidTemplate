package com.example.king.mytemplate.di

import android.app.Application
import android.arch.persistence.room.Room
import com.example.king.mytemplate.domain.data.BaseUrl
import com.example.king.mytemplate.domain.data.ItemDataSource
import com.example.king.mytemplate.domain.data.Local
import com.example.king.mytemplate.domain.data.Remote
import com.example.king.mytemplate.domain.data.local.ItemDAO
import com.example.king.mytemplate.domain.data.local.ItemDataBase
import com.example.king.mytemplate.domain.data.local.LocalItemDataSource
import com.example.king.mytemplate.domain.data.remote.RemoteRetrofitItemDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit.SECONDS
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
        fun provideDb(context: Application): ItemDataBase {
            return Room.databaseBuilder(
                    context.applicationContext,
                    ItemDataBase::class.java,
                    "item.db").build()
        }

        @Singleton
        @Provides
        @JvmStatic
        fun provideItemDao(db: ItemDataBase): ItemDAO {
            return db.itemsDao()
        }

        @Singleton
        @Provides
        @BaseUrl
        @JvmStatic
        fun providerBaseUrl(): String {
            return "http://jsonplaceholder.typicode.com/"
        }

        @Singleton
        @Provides
        @JvmStatic
        fun providerOkHttpClient(): OkHttpClient {
            val timeout = 5L
            return OkHttpClient().newBuilder()
                    .connectTimeout(timeout, SECONDS)
                    .readTimeout(timeout, SECONDS)
                    .writeTimeout(timeout, SECONDS)
                    .build()
        }
    }
}
