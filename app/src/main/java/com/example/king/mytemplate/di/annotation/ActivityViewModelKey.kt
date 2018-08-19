package com.example.king.mytemplate.di.annotation

import com.example.king.mytemplate.base.BaseActivityViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER,
        AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ActivityViewModelKey(val value: KClass<out BaseActivityViewModel>)