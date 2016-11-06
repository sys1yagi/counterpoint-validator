package com.sys1yagi.counterpoint.validator.rule

import com.sys1yagi.counterpoint.Interval
import com.sys1yagi.counterpoint.validator.exception.WholeNoteCounterPointInvalidException

class Perfect5Rule : WholeNoteCounterPointRule {

    override fun validation(intervals: List<Interval>) {
        intervals
                .map { it.normalizationIntervalInt }
                .zip(
                        intervals.drop(1).map { it.normalizationIntervalInt }
                ).forEachIndexed { i, pair ->

            if (pair.first == Interval.INTERVAL_PERFECT_5 && pair.second == Interval.INTERVAL_PERFECT_5) {
                throw WholeNoteCounterPointInvalidException("Consecutive perfect fifth. pos=$i")
            }
        }
    }
}