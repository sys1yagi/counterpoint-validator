package com.sys1yagi.counterpoint.validator.rule

import com.sys1yagi.counterpoint.Interval
import com.sys1yagi.counterpoint.validator.exception.WholeNoteCounterPointInvalidException

class PitchRule : WholeNoteCounterPointRule {
    override fun validation(intervals: List<Interval>) {
        val firstPitch = intervals.first().counter.pos()
        intervals.drop(1).find { firstPitch < it.counter.pos() }?.let {
            return
        }
        throw WholeNoteCounterPointInvalidException("Should not first note is highest pitch")
    }
}