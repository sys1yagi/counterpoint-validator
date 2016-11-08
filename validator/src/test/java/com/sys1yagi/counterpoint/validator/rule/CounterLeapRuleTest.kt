package com.sys1yagi.counterpoint.validator.rule

import com.sys1yagi.counterpoint.Interval
import com.sys1yagi.counterpoint.validator.exception.WholeNoteCounterPointInvalidException
import org.junit.Before
import org.junit.Test

class CounterLeapRuleTest {

    lateinit var rule: CounterLeapRule

    @Before
    fun setUp() {
        rule = CounterLeapRule()
    }

    @Test
    fun valid() {
        val intervals = listOf(
                Interval.create("C4", "C4"),
                Interval.create("B3", "G4")
        )
        rule.validation(intervals)
    }

    @Test(expected = WholeNoteCounterPointInvalidException::class)
    fun invalidUp() {
        val intervals = listOf(
                Interval.create("C4", "C4"),
                Interval.create("B3", "A4")
        )
        rule.validation(intervals)
    }

    @Test(expected = WholeNoteCounterPointInvalidException::class)
    fun invalidDown() {
        val intervals = listOf(
                Interval.create("C4", "A4"),
                Interval.create("B3", "C4")
        )
        rule.validation(intervals)
    }
}