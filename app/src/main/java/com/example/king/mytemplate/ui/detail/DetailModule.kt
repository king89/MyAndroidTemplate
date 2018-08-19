package com.example.king.mytemplate.ui.main

import com.example.king.mytemplate.di.annotation.ActivityScoped
import com.example.king.mytemplate.di.annotation.FragmentScoped
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class DetailModule {
    @FragmentScoped
    @ContributesAndroidInjector
    protected
    abstract fun detailFragment(): DetailFragment

    @Module
    companion object {
        @Provides
        @ActivityScoped
        open fun provideString(): String {
            return "this is the injected string"
        }
    }

}