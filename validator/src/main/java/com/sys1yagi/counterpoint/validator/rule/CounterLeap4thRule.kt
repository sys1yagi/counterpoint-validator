package com.sys1yagi.counterpoint.validator.rule

import com.sys1yagi.counterpoint.Interval
import com.sys1yagi.counterpoint.validator.exception.WholeNoteCounterPointInvalidException

class CounterLeap4thRule :WholeNoteCounterPointRule{
    override fun validation(intervals: List<Interval>) {
        val diff = intervals.drop(1)
        intervals.zip(diff).forEachIndexed { i, (first, second) ->
            if(second.isPerfect4th &&
                    (first.counter.isLeap(second.counter) || first.counter.isNotMotion(second.counter))){
                throw WholeNoteCounterPointInvalidException("Should do sequential progression to make the Perfect 4th: pos:$i")
            }
        }
    }
}