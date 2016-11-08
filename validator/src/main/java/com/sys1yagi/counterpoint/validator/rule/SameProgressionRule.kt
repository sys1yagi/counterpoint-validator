package com.sys1yagi.counterpoint.validator.rule

import com.sys1yagi.counterpoint.Interval
import com.sys1yagi.counterpoint.validator.exception.WholeNoteCounterPointInvalidException

class SameProgressionRule : WholeNoteCounterPointRule {

    override fun validation(intervals: List<Interval>) {
        val pairs = intervals.zip(intervals.drop(1))
        pairs.zip(pairs.drop(2)).forEachIndexed { i, (first, second) ->
            if (first.first.counter.pos() == second.first.counter.pos()) {
                if (first.second.counter.pos() == second.second.counter.pos()) {
                    throw WholeNoteCounterPointInvalidException("Should not use same progression. pos: $i")
                }
            }
        }
    }
}