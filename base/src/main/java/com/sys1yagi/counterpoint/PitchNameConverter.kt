package com.sys1yagi.counterpoint

import com.sys1yagi.counterpoint.exception.InvalidPitchNameException

object PitchNameConverter {

    @Throws(Exception::class)
    fun stringToPitchName(pitchName: String): PitchName {
        if (pitchName.isEmpty()) {
            throw InvalidPitchNameException("empty")
        }
        return pitchName.toUpperCase().let {
            when (it[0]) {
                'C' -> {
                    return PitchName.C
                }
                'D' -> {
                    if (it[1] == 'F') {
                        PitchName.DF
                    } else {
                        PitchName.D
                    }
                }
                'E' -> {
                    if (it[1] == 'F') {
                        PitchName.EF
                    } else {
                        PitchName.E
                    }
                }
                'F' -> {
                    PitchName.F
                }
                'G' -> {
                    if (it[1] == 'F') {
                        PitchName.GF
                    } else {
                        PitchName.G
                    }
                }
                'A' -> {
                    if (it[1] == 'F') {
                        PitchName.AF
                    } else {
                        PitchName.A
                    }
                }
                'B' -> {
                    if (it[1] == 'F') {
                        PitchName.BF
                    } else {
                        PitchName.B
                    }
                }
                else -> {
                    throw InvalidPitchNameException(pitchName)
                }
            }
        }
    }
}
