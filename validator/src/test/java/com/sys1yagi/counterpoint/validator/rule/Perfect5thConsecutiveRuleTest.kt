package com.sys1yagi.counterpoint.validator.rule

import com.sys1yagi.counterpoint.Interval
import com.sys1yagi.counterpoint.validator.exception.WholeNoteCounterPointInvalidException
import org.junit.Before
import org.junit.Test

class Perfect5thConsecutiveRuleTest {

    lateinit var rule: Perfect5thConsecutiveRule

    @Before
    fun setUp() {
        rule = Perfect5thConsecutiveRule()
    }

    @Test
    fun valid() {
        val intervals = listOf(
                Interval.create("C4", "G4"),
                Interval.create("D4", "E4")
        )
        rule.validation(intervals)
    }

    @Test(expected = WholeNoteCounterPointInvalidException::class)
    fun samePitch() {
        val intervals = listOf(
                Interval.create("C4", "G4"),
                Interval.create("C4", "G4")
        )
        rule.validation(intervals)
    }

    @Test(expected = WholeNoteCounterPointInvalidException::class)
    fun consecutivePerfect5() {
        val intervals = listOf(
                Interval.create("C4", "G4"),
                Interval.create("D4", "A4")
        )
        rule.validation(intervals)
    }

    @Test(expected = WholeNoteCounterPointInvalidException::class)
    fun octave() {
        val intervals = listOf(
                Interval.create("C4", "G5"),
                Interval.create("D4", "A6")
        )
        rule.validation(intervals)
    }

    @Test(expected = WholeNoteCounterPointInvalidException::class)
    fun invalid() {
        val intervals = listOf(
                Interval.create("C4", "C5"),
                Interval.create("D4", "B4"),
                Interval.create("E4", "G5"),
                Interval.create("A4", "F5"),
                Interval.create("G4", "G5"),
                Interval.create("D4", "A4"), // perfect 5th
                Interval.create("F4", "C5"), // perfect 5th
                Interval.create("E4", "C5"),
                Interval.create("D4", "B4"),
                Interval.create("C4", "C5")
        )
        rule.validation(intervals)
    }

    @Test(expected = WholeNoteCounterPointInvalidException::class)
    fun invalid2() {
        val intervals = listOf(
                Interval.create("C4", "C5"),
                Interval.create("D4", "B4"),
                Interval.create("E4", "G5"),
                Interval.create("A4", "F5"),
                Interval.create("G4", "G5"),
                Interval.create("D4", "A4"), // perfect 5th
                Interval.create("E4", "C5"),
                Interval.create("F4", "C5"), // perfect 5th
                Interval.create("D4", "B4"),
                Interval.create("C4", "C5")
        )
        rule.validation(intervals)
    }
}