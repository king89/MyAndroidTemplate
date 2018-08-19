package com.example.king.mytemplate.ui.main.fragment

import com.example.king.mytemplate.base.BaseFragmentModule
import com.example.king.mytemplate.base.BaseFragmentViewModel
import com.example.king.mytemplate.di.annotation.FragmentScoped
import com.example.king.mytemplate.di.annotation.FragmentViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [BaseFragmentModule::class])
abstract class MainFragmentModule {

    @Binds
    @IntoMap
    @FragmentScoped
    @FragmentViewModelKey(MainFragmentViewModel::class)
    abstract fun provideMainFragmentViewModel(
            viewModel: MainFragmentViewModel): BaseFragmentViewModel
}