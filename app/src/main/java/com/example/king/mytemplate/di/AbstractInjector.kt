package com.example.king.mytemplate.di

import android.app.Activity
import android.app.Service
import android.content.BroadcastReceiver
import android.content.ContentProvider
import android.support.v4.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjection

//Can move this file to a common module

abstract class AbstractInjector {

    abstract var injector: AndroidInjector<*>

    open fun inject(activity: Activity) {
        (injector as AndroidInjector<Activity>).inject(activity)
    }

    open fun inject(fragment: Fragment) {
        //will get the support injector from activity if any, then get from application(should not get from application)
        AndroidSupportInjection.inject(fragment)
    }

    open fun inject(service: Service) {
        (injector as AndroidInjector<Service>).inject(service)
    }

    open fun inject(broadcastReceiver: BroadcastReceiver) {
        (injector as AndroidInjector<BroadcastReceiver>).inject(broadcastReceiver)
    }

    open fun inject(contentProvider: ContentProvider) {
        (injector as AndroidInjector<ContentProvider>).inject(contentProvider)
    }
}