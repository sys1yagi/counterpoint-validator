package com.sys1yagi.counterpoint.validator.rule

import com.sys1yagi.counterpoint.Interval
import com.sys1yagi.counterpoint.validator.exception.WholeNoteCounterPointInvalidException
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class Perfect5thContraryMotionRuleTest {

    lateinit var rule: Perfect5thContraryMotionRule

    @Before
    fun setUp() {
        rule = Perfect5thContraryMotionRule()
    }

    @Test
    fun valid() {
        run {
            val intervals = listOf(
                    Interval.create("C4", "E4"),
                    Interval.create("B3", "F4")
            )
            rule.validation(intervals)
        }
        run {
            val intervals = listOf(
                    Interval.create("B3", "A4"),
                    Interval.create("C4", "G4")
            )
            rule.validation(intervals)
        }
    }

    @Test(expected = WholeNoteCounterPointInvalidException::class)
    fun hiddenFifthUp() {
        val intervals = listOf(
                Interval.create("C4", "E4"),
                Interval.create("D4", "A4")
        )
        rule.validation(intervals)
    }

    @Test(expected = WholeNoteCounterPointInvalidException::class)
    fun hiddenFifthDown() {
        val intervals = listOf(
                Interval.create("C4", "F4"),
                Interval.create("A3", "E4")
        )
        rule.validation(intervals)
    }
}