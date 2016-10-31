package com.sys1yagi.counterpoint

import com.sys1yagi.counterpoint.exception.InvalidPitchNameException

object PitchConverter {
    @Throws(InvalidPitchNameException::class)
    fun stringToPitch(pitchName: String): Pitch {
        val regex = ".*?([0-9]+)".toRegex()

        regex.find(pitchName)?.let{
            val level = it.groupValues[1]
            return Pitch(PitchNameConverter.stringToPitchName(pitchName), level.toInt())
        } ?: run {
            throw InvalidPitchNameException(pitchName)
        }
    }
}