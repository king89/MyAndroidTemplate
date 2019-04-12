package com.example.king.mytemplate.di

object AppComponentProvider {
    //temporary way to pass the application component to here
    lateinit var moduleComponent: AppComponent

    fun init(appComponent: AppComponent): AppComponent {
        moduleComponent = appComponent
        return moduleComponent
    }
}