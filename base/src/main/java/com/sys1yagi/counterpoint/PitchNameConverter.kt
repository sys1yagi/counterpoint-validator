package com.sys1yagi.counterpoint

import com.sys1yagi.counterpoint.exception.InvalidPitchNameException

object PitchNameConverter {

    @Throws(InvalidPitchNameException::class)
    fun stringToPitchName(pitchName: String): Pitch.Name {
        if (pitchName.isEmpty()) {
            throw InvalidPitchNameException("empty")
        }
        return pitchName.toUpperCase().let {
            when (it[0]) {
                'C' -> {
                    return Pitch.Name.C
                }
                'D' -> {
                    if (it[1] == 'F') {
                        Pitch.Name.DF
                    } else {
                        Pitch.Name.D
                    }
                }
                'E' -> {
                    if (it[1] == 'F') {
                        Pitch.Name.EF
                    } else {
                        Pitch.Name.E
                    }
                }
                'F' -> {
                    Pitch.Name.F
                }
                'G' -> {
                    if (it[1] == 'F') {
                        Pitch.Name.GF
                    } else {
                        Pitch.Name.G
                    }
                }
                'A' -> {
                    if (it[1] == 'F') {
                        Pitch.Name.AF
                    } else {
                        Pitch.Name.A
                    }
                }
                'B' -> {
                    if (it[1] == 'F') {
                        Pitch.Name.BF
                    } else {
                        Pitch.Name.B
                    }
                }
                else -> {
                    throw InvalidPitchNameException(pitchName)
                }
            }
        }
    }
}
