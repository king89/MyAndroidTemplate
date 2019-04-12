package com.example.king.mytemplate.util

import android.arch.lifecycle.ViewModel
import android.support.v4.app.Fragment
import com.example.king.mytemplate.base.BaseActivityViewModel
import com.example.king.mytemplate.base.BaseFragmentViewModel
import com.example.king.mytemplate.base.ViewModelFactory
import com.example.king.mytemplate.ui.main.fragment.MainFragment
import dagger.android.AndroidInjector
import dagger.android.AndroidInjector.Factory
import dagger.android.DispatchingAndroidInjector
import dagger.android.DispatchingAndroidInjector_Factory
import javax.inject.Provider

object ViewModelTestUtil {
    fun <T : BaseActivityViewModel> createActivityViewModelFactory(viewModel: T): ViewModelFactory {
        return object : ViewModelFactory(emptyMap()) {
            override fun <T : ViewModel> create(viewModelClass: Class<T>): T {
                if (viewModelClass.isAssignableFrom(viewModel.javaClass)) {
                    @Suppress("UNCHECKED_CAST")
                    return viewModel as T
                }
                throw IllegalArgumentException("Unknown view model class " + viewModelClass)
            }
        }
    }

    fun <T : BaseFragmentViewModel> createFragmentViewModelFactory(viewModel: T): ViewModelFactory {
        return object : ViewModelFactory(emptyMap()) {
            override fun <T : ViewModel> create(viewModelClass: Class<T>): T {
                if (viewModelClass.isAssignableFrom(viewModel.javaClass)) {
                    @Suppress("UNCHECKED_CAST")
                    return viewModel as T
                }
                throw IllegalArgumentException("Unknown view model class " + viewModelClass)
            }
        }
    }

    fun <T : android.app.Fragment> createTestFrameworkFragmentInjector(
        classType: Class<T>,
        fragmentInjector: ((T) -> Unit)? = null): DispatchingAndroidInjector<android.app.Fragment> {
        return DispatchingAndroidInjector_Factory
            .newDispatchingAndroidInjector<android.app.Fragment>(mapOf(
                (classType to Provider {
                    AndroidInjector.Factory<T> {
                        AndroidInjector<T> {
                            fragmentInjector?.invoke(it)
                        }
                    }
                })
            ) as Map<Class<*>, Provider<AndroidInjector.Factory<*>>>,
                emptyMap())
    }

    fun <T : Fragment> createTestSupportFragmentInjector(
        classType: Class<T>,
        fragmentInjector: ((T) -> Unit)? = null): DispatchingAndroidInjector<Fragment> {
        return DispatchingAndroidInjector_Factory
            .newDispatchingAndroidInjector<Fragment>(mapOf(
                (classType to Provider {
                    AndroidInjector.Factory<T> {
                        AndroidInjector<T> {
                            fragmentInjector?.invoke(it)
                        }
                    }
                })
            ) as Map<Class<*>, Provider<AndroidInjector.Factory<*>>>,
                emptyMap())
    }


    fun <T : android.app.Fragment> createTestFragmentInjectorEntry(
        classType: Class<T>,
        fragmentInjector: ((T) -> Unit)? = null
    ): Map<Class<*>, Provider<AndroidInjector.Factory<*>>> {
        return mapOf(
            (classType to Provider {
                AndroidInjector.Factory<T> {
                    AndroidInjector<T> {
                        fragmentInjector?.invoke(it)
                    }
                }
            })
        ) as Map<Class<*>, Provider<AndroidInjector.Factory<*>>>
    }

    fun combineInjectorEntry(
        vararg maps: Map<Class<*>, Provider<AndroidInjector.Factory<*>>>): DispatchingAndroidInjector<android.app.Fragment> {
        val newMap = mutableMapOf<Class<*>, Provider<AndroidInjector.Factory<*>>>()
        maps.forEach {
            newMap.putAll(it)
        }
        return DispatchingAndroidInjector_Factory
            .newDispatchingAndroidInjector<android.app.Fragment>(newMap, emptyMap())
    }


    fun <T : Fragment> createTestSupportFragmentInjectorEntry(
        classType: Class<T>,
        fragmentInjector: ((T) -> Unit)? = null
    ): Map<Class<*>, Provider<AndroidInjector.Factory<*>>> {
        return mapOf(
            (classType to Provider {
                AndroidInjector.Factory<T> {
                    AndroidInjector<T> {
                        fragmentInjector?.invoke(it)
                    }
                }
            })
        ) as Map<Class<*>, Provider<AndroidInjector.Factory<*>>>
    }

    fun combineSupportInjectorEntry(
        vararg maps: Map<Class<*>, Provider<AndroidInjector.Factory<*>>>): DispatchingAndroidInjector<Fragment> {
        val newMap = mutableMapOf<Class<*>, Provider<AndroidInjector.Factory<*>>>()
        maps.forEach {
            newMap.putAll(it)
        }
        return DispatchingAndroidInjector_Factory
            .newDispatchingAndroidInjector<Fragment>(newMap, emptyMap())
    }


}