package com.sys1yagi.counterpoint.validator

import com.sys1yagi.counterpoint.Interval
import com.sys1yagi.counterpoint.file.File2Intervals
import com.sys1yagi.counterpoint.validator.exception.WholeNoteCounterPointInvalidException
import com.sys1yagi.counterpoint.validator.rule.*
import java.io.File

class Validator {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val file = args[0]
            Validator().checkValidWholeNotesCounterPoint(
                    File2Intervals.wholeNotesFromFile(File(file))
            )
        }
    }

    @Throws(WholeNoteCounterPointInvalidException::class)
    fun checkValidWholeNotesCounterPoint(intervals: List<Interval>) {
        listOf(
                CounterLeap4thRule(),
                CounterLeapRule(),
                Perfect5thContraryMotionRule(),
                Perfect5thConsecutiveRule(),
                Perfect8thContraryMotionRule(),
                Perfect8thConsecutiveRule(),
                SameProgressionRule(),
                PitchRule()
        ).forEach {
            it.validation(intervals)
        }
    }
}

