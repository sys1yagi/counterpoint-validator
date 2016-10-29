package com.sys1yagi.counterpoint

import com.sys1yagi.counterpoint.exception.InvalidPitchNameException

object PitchNameConverter {

    @Throws(Exception::class)
    fun stringToPitchName(pitchName: String): PitchName {
        if (pitchName.isEmpty()) {
            throw InvalidPitchNameException("empty")
        }
        when (pitchName[0]) {
            'C' -> {

            }
            'D' -> {

            }
            'E' -> {

            }
            'F' -> {

            }
            'G' -> {

            }
            'H' -> {

            }
        }
        throw InvalidPitchNameException(pitchName)
    }
}
