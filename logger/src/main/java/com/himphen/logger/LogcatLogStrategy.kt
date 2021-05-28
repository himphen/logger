package com.himphen.logger

import android.util.Log

/**
 * LogCat implementation for [LogStrategy]
 *
 * This simply prints out all logs to Logcat by using standard [Log] class.
 */
class LogcatLogStrategy : LogStrategy {
    override fun log(priority: Int, tag: String?, message: String) {
        var updatedTag = tag
        Utils.checkNotNull(message)
        if (tag == null) {
            updatedTag = DEFAULT_TAG
        }
        Log.println(priority, updatedTag, message)
    }

    companion object {
        const val DEFAULT_TAG = "NO_TAG"
    }
}