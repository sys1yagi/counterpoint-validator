package com.sys1yagi.counterpoint


class Interval(val base: Pitch, val counter: Pitch) {
    enum class Type {
        Consonance,
        Dissonance
    }

    val type: Type by lazy {
        when (normalizationIntervalInt) {
            3, 5, 6, 8 -> {
                Type.Consonance
            }
            else -> {
                Type.Dissonance
            }
        }
    }

    val normalizationIntervalInt by lazy {
        1
    }
    val intervalInt by lazy {
        // TODO
        // 半音で数字を出す
        // PitchNameを定数にせず、数値を持つようにする
        1
    }
}