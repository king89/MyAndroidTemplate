package com.example.king.mytemplate.di

import dagger.android.AndroidInjector.Factory
import javax.inject.Provider

interface HasInjectorMap {
    fun injectorFactoriesMap(): MutableMap<Class<*>, Provider<Factory<*>>>

}