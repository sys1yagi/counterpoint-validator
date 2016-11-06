package com.sys1yagi.counterpoint.validator.rule

import com.sys1yagi.counterpoint.Interval

interface WholeNoteCounterPointRule {

    fun validation(intervals: List<Interval>): Boolean
}