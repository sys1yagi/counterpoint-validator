package com.sys1yagi.counterpoint


class Interval(val base: Pitch, val counter: Pitch) {

    companion object{
        const val INTERVAL_MAJOR_3TH = 4
        const val INTERVAL_PERFECT_4TH = 5
        const val INTERVAL_PERFECT_5TH = 7
        const val INTERVAL_MAJOR_6TH = 9
        const val INTERVAL_MINOR_6TH = 8
        const val INTERVAL_PERFECT_8TH = 12
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
            0, INTERVAL_MAJOR_3TH, INTERVAL_PERFECT_5TH, INTERVAL_MAJOR_6TH -> {
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
        val basePos = base.pos()
        val counterPos = counter.pos()
        Math.abs(basePos - counterPos)
    }

    val isPerfect4th by lazy {
        normalizationIntervalInt == INTERVAL_PERFECT_4TH
    }

    val isPerfect5th by lazy {
        normalizationIntervalInt == INTERVAL_PERFECT_5TH
    }

    val isPerfect8th by lazy {
        normalizationIntervalInt == 0
    }

    override fun toString(): String {
        return "${base.name}${base.level}, ${counter.name}${counter.level}"
    }

}