package com.sys1yagi.counterpoint.validator.rule

import com.sys1yagi.counterpoint.Interval
import com.sys1yagi.counterpoint.validator.exception.WholeNoteCounterPointInvalidException

class Perfect8thConsecutiveRule : WholeNoteCounterPointRule {

    override fun validation(intervals: List<Interval>) {
        val origin = intervals.map { it.intervalInt }
        val diff1 = intervals.drop(1).map { it.intervalInt }
        val diff2 = intervals.drop(2).map { it.intervalInt }

        origin.zip(diff1).forEachIndexed { i, pair ->
            check(i, pair.first, pair.second)
        }
        origin.zip(diff2).forEachIndexed { i, pair ->
            check(i, pair.first, pair.second)
        }
    }

    private fun check(index: Int, first: Int, second: Int) {
        if (first == Interval.INTERVAL_PERFECT_8 && second == Interval.INTERVAL_PERFECT_8) {
            throw WholeNoteCounterPointInvalidException("Consecutive perfect 8th. pos=$index")
        }
    }
}