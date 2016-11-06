package com.sys1yagi.counterpoint.validator.rule

import com.sys1yagi.counterpoint.Interval
import com.sys1yagi.counterpoint.validator.exception.WholeNoteCounterPointInvalidException

interface WholeNoteCounterPointRule {

    @Throws(WholeNoteCounterPointInvalidException::class)
    fun validation(intervals: List<Interval>)
}