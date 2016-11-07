package com.sys1yagi.counterpoint.validator.rule

import com.sys1yagi.counterpoint.Interval
import com.sys1yagi.counterpoint.validator.exception.WholeNoteCounterPointInvalidException
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class Perfect8thContraryMotionRuleTest {

    lateinit var rule: Perfect8thContraryMotionRule

    @Before
    fun setUp() {
        rule = Perfect8thContraryMotionRule()
    }

    @Test
    fun valid() {
        run {
            val intervals = listOf(
                    Interval.create("C4", "E4"),
                    Interval.create("B3", "B4")
            )
            rule.validation(intervals)
        }
        run {
            val intervals = listOf(
                    Interval.create("B2", "D4"),
                    Interval.create("C3", "C4")
            )
            rule.validation(intervals)
        }
    }

    @Test(expected = WholeNoteCounterPointInvalidException::class)
    fun hidden8thUp() {
        val intervals = listOf(
                Interval.create("C4", "E4"),
                Interval.create("D4", "D5")
        )
        rule.validation(intervals)
    }

    @Test(expected = WholeNoteCounterPointInvalidException::class)
    fun hidden8thDown() {
        val intervals = listOf(
                Interval.create("C4", "B4"),
                Interval.create("A3", "A4")
        )
        rule.validation(intervals)
    }
}