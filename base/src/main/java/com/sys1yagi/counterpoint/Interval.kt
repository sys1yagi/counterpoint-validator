package com.sys1yagi.counterpoint


class Interval(val base: Pitch, val counter: Pitch) {

    companion object{
        const val INTERVAL_MAJOR_3 = 4
        const val INTERVAL_PERFECT_4 = 5
        const val INTERVAL_PERFECT_5 = 7
        const val INTERVAL_MAJOR_6 = 9
        fun create(base:String, counter:String) = Interval(
                PitchConverter.stringToPitch(base),
                PitchConverter.stringToPitch(counter)
        )
    }

    // intervale memo
    // Perfect 4th 5
    // Perfect 5th 7

    enum class Type {
        Consonance,
        Dissonance
    }

    val type: Type by lazy {
        when (normalizationIntervalInt) {
            0, INTERVAL_MAJOR_3, INTERVAL_PERFECT_5, INTERVAL_MAJOR_6 -> {
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