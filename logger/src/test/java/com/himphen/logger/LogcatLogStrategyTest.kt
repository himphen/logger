package com.himphen.logger

import com.google.common.truth.Truth.assertThat
import com.himphen.logger.Logger.DEBUG
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLog

@RunWith(RobolectricTestRunner::class)
class LogcatLogStrategyTest {

    @Test
    fun log() {
        val logStrategy = LogcatLogStrategy()

        logStrategy.log(DEBUG, "tag", "message")

        val logItems = ShadowLog.getLogs()
        logItems.forEach {
            if (it.msg.equals("Instrumentation started!")) return@forEach
            assertThat(it.type).isEqualTo(DEBUG)
            assertThat(it.msg).isEqualTo("message")
            assertThat(it.tag).isEqualTo("tag")
        }
    }

    @Test
    fun logWithNullTag() {
        val logStrategy = LogcatLogStrategy()

        logStrategy.log(DEBUG, null, "message")

        val logItems = ShadowLog.getLogs()
        logItems.forEach {
            if (it.msg.equals("Instrumentation started!")) return@forEach
            assertThat(it.tag).isEqualTo(LogcatLogStrategy.DEFAULT_TAG)
        }
    }

}
