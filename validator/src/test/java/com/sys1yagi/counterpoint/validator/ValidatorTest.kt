package com.sys1yagi.counterpoint.validator

import com.sys1yagi.counterpoint.Interval
import com.sys1yagi.counterpoint.Pitch
import com.sys1yagi.counterpoint.PitchConverter
import org.junit.Before
import org.junit.Test

class ValidatorTest {

    fun createInterval(base: String, counter: String) =
            Interval(
                    PitchConverter.stringToPitch(base),
                    PitchConverter.stringToPitch(counter)
            )


    lateinit var validator: Validator

    @Before
    fun setUp() {
        validator = Validator()
    }

    @Test
    fun checkValidWholeNotesCounterPoint() {

        val intervals = listOf(
                createInterval("C4", "C5"),
                createInterval("D4", "F4")
        )
        //validator.checkValidWholeNotesCounterPoint()
    }

}