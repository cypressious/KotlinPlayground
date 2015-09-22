package com.cypressworks.kotlinplayground

import android.view.ViewGroup

fun setTransitionType(v: ViewGroup?, type: Int) {
    v?.layoutTransition?.enableTransitionType(type)
}