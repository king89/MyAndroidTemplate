package com.example.king.mytemplate.ui.main

import dagger.Module
import com.example.king.mytemplate.di.ActivityScoped
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import com.example.king.mytemplate.di.FragmentScoped



@Module
abstract class MainModule {
    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun mainFragment(): DetailFragment

    @Provides
    @ActivityScoped
    fun provideString(): String {
        return "this is the injected string"
    }
}