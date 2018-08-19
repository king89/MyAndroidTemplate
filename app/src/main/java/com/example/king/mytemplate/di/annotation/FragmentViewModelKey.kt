package com.example.king.mytemplate.di.annotation

import com.example.king.mytemplate.base.BaseFragmentViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER,
        AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class FragmentViewModelKey(val value: KClass<out BaseFragmentViewModel>)