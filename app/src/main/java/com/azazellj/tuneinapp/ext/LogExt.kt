package com.azazellj.tuneinapp.ext

import android.util.Log
import com.azazellj.tuneinapp.BuildConfig


fun logForDebug(
    tag: String? = null,
    message: String? = null,
    t: Throwable? = null,
) {
    if (BuildConfig.DEBUG) {
        Log.e(tag, message, t)
    }
}