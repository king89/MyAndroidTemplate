package com.example.king.mytemplate.base

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {
    val disposable: CompositeDisposable = CompositeDisposable()
}