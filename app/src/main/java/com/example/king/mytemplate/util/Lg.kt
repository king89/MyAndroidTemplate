package com.example.king.mytemplate.util

import android.util.Log

object Lg {
    fun d(msg: String) {
        Log.d(TAG, msg)
    }

    fun e(msg: String, e: Throwable) {
        Log.e(TAG, msg, e)
    }

    private const val TAG = "MyTemplate"
}