package com.sys1yagi.counterpoint.validator

import com.sys1yagi.counterpoint.Interval
import com.sys1yagi.counterpoint.PitchConverter
import org.junit.Before
import org.junit.Test

class ValidatorTest {


    lateinit var validator: Validator

    @Before
    fun setUp() {
        validator = Validator()
    }

    @Test
    fun checkValidWholeNotesCounterPoint() {

        val intervals = listOf(
                Interval.create("C4", "C5"),
                Interval.create("D4", "F4")
        )
        //validator.checkValidWholeNotesCounterPoint()
    }

}