package com.sys1yagi.counterpoint


class Interval(val base: Pitch, val counter: Pitch) {

    // intervale memo
    // Perfect 4th 5
    // Perfect 5th 7

    enum class Type {
        Consonance,
        Dissonance
    }

    val type: Type by lazy {
        when (normalizationIntervalInt) {
            0, 4, 7, 9 -> {
                Type.Consonance
            }
            else -> {
                Type.Dissonance
            }
        }
    }

    val normalizationIntervalInt by lazy {
        intervalInt % 12
    }
    val intervalInt by lazy {
        val basePos = base.name.pos + base.level * 12
        val counterPos = counter.name.pos + counter.level * 12
        Math.abs(basePos - counterPos)
    }

}