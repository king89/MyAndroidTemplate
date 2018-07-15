package com.example.king.mytemplate.data

import java.lang.annotation.Documented
import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier
@Documented
@Retention(RUNTIME)
annotation class Remote
