package com.example.king.mytemplate.di

import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector_Factory

//every module has its own internal Injector
internal object Injector : AbstractInjector() {
    override lateinit var injector: AndroidInjector<*>

    init {
        val maps = AppComponentProvider.moduleComponent.injectorFactoriesMap()
        injector = DispatchingAndroidInjector_Factory
            .newDispatchingAndroidInjector<Any>(maps, emptyMap())
    }

}