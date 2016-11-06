package com.sys1yagi.counterpoint.validator.rule

import com.sys1yagi.counterpoint.Interval
import com.sys1yagi.counterpoint.validator.exception.WholeNoteCounterPointInvalidException
import org.junit.Assert.*
import org.junit.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before

class Perfect5RuleTest {

    lateinit var rule: Perfect5Rule

    @Before
    fun setUp() {
        rule = Perfect5Rule()
    }

    @Test
    fun valid() {

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

    //オクターブ

    @Test(expected = WholeNoteCounterPointInvalidException::class)
    fun invalid(){
        val intervals = listOf(
                Interval.create("C4","C5"),
                Interval.create("D4","B4"),
                Interval.create("E4","G5"),
                Interval.create("A4","F5"),
                Interval.create("G4","G5"),
                Interval.create("D4","A4"),
                Interval.create("F4","C5"),
                Interval.create("E4","C5"),
                Interval.create("D4","B4"),
                Interval.create("C4","C5")
        )
        rule.validation(intervals)
    }

    // 1個はさむ
}