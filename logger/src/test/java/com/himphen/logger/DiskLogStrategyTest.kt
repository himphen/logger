package com.himphen.logger

import android.os.Handler
import com.himphen.logger.Logger.DEBUG
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class DiskLogStrategyTest {

    @Test
    fun log() {
        val handler = mock(Handler::class.java)
        val logStrategy = DiskLogStrategy(handler)

        logStrategy.log(DEBUG, "tag", "message")

        verify(handler).sendMessage(handler.obtainMessage(DEBUG, "message"))
    }

}