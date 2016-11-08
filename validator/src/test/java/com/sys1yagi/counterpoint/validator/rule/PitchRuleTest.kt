package com.sys1yagi.counterpoint.validator.rule

import com.sys1yagi.counterpoint.Interval
import com.sys1yagi.counterpoint.validator.exception.WholeNoteCounterPointInvalidException
import org.junit.Before
import org.junit.Test

class PitchRuleTest {
    lateinit var rule: PitchRule

    @Before
    fun setUp() {
        rule = PitchRule()
    }

    @Test
    fun valid() {
        val intervals = listOf(
                Interval.create("C4", "D4"),
                Interval.create("D4", "E4"),
                Interval.create("E4", "G4"),
                Interval.create("G4", "B4"),
                Interval.create("C4", "G4")
        )
        rule.validation(intervals)
    }

    @Test(expected = WholeNoteCounterPointInvalidException::class)
    fun invalid() {
        val intervals = listOf(
                Interval.create("C4", "C5"),
                Interval.create("D4", "E4"),
                Interval.create("E4", "G4"),
                Interval.create("G4", "B4"),
                Interval.create("C4", "G4")
        )
        rule.validation(intervals)
    }
}