package com.example.king.mytemplate.di

import com.example.king.mytemplate.domain.usecase.GetListUseCase
import com.example.king.mytemplate.domain.usecase.GetListUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
abstract class UseCaseModule {

    @Binds
    internal abstract fun provideGetDataListUseCase(useCase: GetListUseCaseImpl): GetListUseCase

}