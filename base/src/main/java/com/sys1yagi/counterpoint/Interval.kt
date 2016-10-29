package com.sys1yagi.counterpoint


class Interval(val base: PitchName, val counter: PitchName) {
    enum class Type {
        Consonance,
        Dissonance
    }

    val type: Type by lazy {
        Type.Consonance
    }

    companion object {
        fun createInterval(base: PitchName, counter: PitchName): Interval {
            return Interval(base, counter)
        }
    }
}