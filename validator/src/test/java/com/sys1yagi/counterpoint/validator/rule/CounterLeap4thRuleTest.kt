package com.sys1yagi.counterpoint.validator.rule

import com.sys1yagi.counterpoint.Interval
import com.sys1yagi.counterpoint.validator.exception.WholeNoteCounterPointInvalidException
import org.junit.Before
import org.junit.Test

class CounterLeap4thRuleTest {

    lateinit var rule: CounterLeap4thRule

    @Before
    fun setUp() {
        rule = CounterLeap4thRule()
    }

    @Test
    fun valid() {
        run {
            val intervals = listOf(
                    Interval.create("C4", "E4"),
                    Interval.create("C4", "F4")
            )
            rule.validation(intervals)
        }
        run {
            val intervals = listOf(
                    Interval.create("C4", "G4"),
                    Interval.create("C4", "F4")
            )
            rule.validation(intervals)
        }
    }

    @Test(expected = WholeNoteCounterPointInvalidException::class)
    fun invalid() {
        val intervals = listOf(
                Interval.create("C4", "C4"),
                Interval.create("C4", "F4")
        )
        rule.validation(intervals)
    }
}