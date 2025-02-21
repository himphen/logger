package com.himphen.logger

import com.google.common.truth.Truth.assertThat
import com.himphen.logger.Logger.DEBUG
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class AndroidLogAdapterTest {

    @Test
    fun isLoggable() {
        val logAdapter = AndroidLogAdapter()

        assertThat(logAdapter.isLoggable(DEBUG, "tag")).isTrue()
    }

    @Test
    fun log() {
        val formatStrategy = mock(FormatStrategy::class.java)
        val logAdapter = AndroidLogAdapter(formatStrategy)

        logAdapter.log(DEBUG, null, "message")

        verify(formatStrategy).log(DEBUG, null, "message")
    }

}