package com.example.king.mytemplate

import android.app.Activity
import android.support.test.rule.ActivityTestRule
import com.example.king.mytemplate.di.AbstractInjector
import dagger.android.AndroidInjector

class InjectedActivityTestRule<T : Activity>(
    activityClass: Class<T>,
    private val injector: AbstractInjector,
    private val injection: (T) -> Unit)
    : ActivityTestRule<T>(activityClass, false, false) {

    override fun beforeActivityLaunched() {
        super.beforeActivityLaunched()
        setActivityInjector()
    }

    private fun setActivityInjector() {
        injector.injector = AndroidInjector<Any> {
            injection(it as T)
        }

    }
}