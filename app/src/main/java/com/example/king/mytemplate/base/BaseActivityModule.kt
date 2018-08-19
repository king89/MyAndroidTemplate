package com.example.king.mytemplate.base

import android.arch.lifecycle.ViewModel
import com.example.king.mytemplate.di.annotation.ActivityScoped
import com.example.king.mytemplate.di.annotation.ActivityScopedFactory
import dagger.Binds
import dagger.Module
import javax.inject.Inject
import javax.inject.Provider

@Module
abstract class BaseActivityModule {
    @Binds
    @ActivityScoped
    @ActivityScopedFactory
    abstract fun bindViewModelFactory(viewModelFactory: ActivityViewModelFactory): ViewModelFactory
}


@ActivityScoped
@Suppress("UNCHECKED_CAST")
class ActivityViewModelFactory @Inject constructor(
        viewModel: MutableMap<Class<out BaseActivityViewModel>, Provider<BaseActivityViewModel>>
) : ViewModelFactory(viewModel as Map<Class<out ViewModel>, Provider<ViewModel>>)