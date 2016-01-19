package com.cypressworks.kotlinplayground

import android.content.Context
import javax.inject.Inject

class Foo @Inject constructor(
        val c: Context,
        val b: Bar
) {

    fun bar() = "Hello from Foo"
}

class Bar @Inject constructor() {
    fun hello() = "Hello from Bar"
}
