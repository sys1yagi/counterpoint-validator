package com.sys1yagi.counterpoint.validator.rule

import com.sys1yagi.counterpoint.Interval
import com.sys1yagi.counterpoint.validator.exception.WholeNoteCounterPointInvalidException

class Perfect8thContraryMotionRule : WholeNoteCounterPointRule {

    override fun validation(intervals: List<Interval>) {
        val diff1 = intervals.drop(1)
        intervals.zip(diff1).forEachIndexed { i, (first, second) ->
            if (second.isPerfect8th && !isContraryMotion(first, second)) {
                throw WholeNoteCounterPointInvalidException("Should contrary motion for perfect 5th.")
            }
        }
    }

    fun isContraryMotion(first: Interval, second: Interval): Boolean {
        val baseMotion = first.base.isUpDirection(second.base)
        val counterMotion = first.counter.isUpDirection(second.counter)
        return baseMotion != counterMotion;
    }
}