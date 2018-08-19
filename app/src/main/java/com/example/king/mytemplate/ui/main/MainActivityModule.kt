package com.example.king.mytemplate.ui.main

import com.example.king.mytemplate.base.BaseActivityModule
import com.example.king.mytemplate.base.BaseActivityViewModel
import com.example.king.mytemplate.di.annotation.ActivityScoped
import com.example.king.mytemplate.di.annotation.ActivityViewModelKey
import com.example.king.mytemplate.di.annotation.FragmentScoped
import com.example.king.mytemplate.domain.usecase.GetListUseCase
import com.example.king.mytemplate.domain.usecase.GetListUseCaseImpl
import com.example.king.mytemplate.ui.main.fragment.MainFragment
import com.example.king.mytemplate.ui.main.fragment.MainFragmentModule
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module(includes = [BaseActivityModule::class])
abstract class MainActivityModule {
    @FragmentScoped
    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    internal abstract fun mainFragment(): MainFragment

    @Binds
    @IntoMap
    @ActivityScoped
    @ActivityViewModelKey(MainActivityViewModel::class)
    abstract fun provideMainActivityViewModel(
            viewModel: MainActivityViewModel): BaseActivityViewModel

    @Binds
    @ActivityScoped
    abstract fun provideGetListUsecase(useCaseImpl: GetListUseCaseImpl): GetListUseCase

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