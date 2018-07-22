package com.example.king.mytemplate.ui.main

import com.example.king.mytemplate.di.ActivityScoped
import com.example.king.mytemplate.di.FragmentScoped
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainModule {
    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun mainFragment(): MainFragment


    @Module
    companion object {
        @Provides
        @ActivityScoped
        @JvmStatic
        fun provideString(): String {
            return "this is the injected string"
        }

    }

}