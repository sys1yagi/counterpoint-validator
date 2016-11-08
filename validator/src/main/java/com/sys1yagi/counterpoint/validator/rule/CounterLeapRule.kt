package com.sys1yagi.counterpoint.validator.rule

import com.sys1yagi.counterpoint.Interval
import com.sys1yagi.counterpoint.validator.exception.WholeNoteCounterPointInvalidException

class CounterLeapRule : WholeNoteCounterPointRule {
    override fun validation(intervals: List<Interval>) {
        val origin = intervals.map { it.counter.pos() }
        val diff1 = intervals.drop(1).map { it.counter.pos() }
        origin.zip(diff1).forEachIndexed { i, (first, second) ->
            println(Math.abs(first-second))
            if(Math.abs(first-second) > Interval.INTERVAL_MINOR_6){
                throw WholeNoteCounterPointInvalidException("Leap major 6 or higher. pos=$i")
            }
        }

    }
}