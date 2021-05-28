package com.himphen.logger

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CsvFormatStrategyTest {

    @Test
    fun log() {
        val formatStrategy = CsvFormatStrategy.newBuilder()
            .logStrategy(object : LogStrategy {
                override fun log(priority: Int, tag: String?, message: String) {
                    assertThat(tag).isEqualTo("PRETTY_LOGGER-tag")
                    assertThat(priority).isEqualTo(Logger.VERBOSE)
                    assertThat(message).contains("VERBOSE,PRETTY_LOGGER-tag,message")
                }
            })
            .build()

        formatStrategy.log(Logger.VERBOSE, "tag", "message")
    }

    @Test
    fun defaultTag() {
        val formatStrategy = CsvFormatStrategy.newBuilder()
            .logStrategy(object : LogStrategy {
                override fun log(priority: Int, tag: String?, message: String) {
                    assertThat(tag).isEqualTo("PRETTY_LOGGER")
                }
            })
            .build()

        formatStrategy.log(Logger.VERBOSE, null, "message")
    }

    @Test
    fun customTag() {
        val formatStrategy = CsvFormatStrategy.newBuilder()
            .tag("custom")
            .logStrategy(object : LogStrategy {
                override fun log(priority: Int, tag: String?, message: String) {
                    assertThat(tag).isEqualTo("custom")
                }

            })
            .build()

        formatStrategy.log(Logger.VERBOSE, null, "message")
    }
}
