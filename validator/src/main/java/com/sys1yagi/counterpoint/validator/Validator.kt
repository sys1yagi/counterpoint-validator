package com.sys1yagi.counterpoint.validator

import com.sys1yagi.counterpoint.PitchName

class Validator {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // data format
            // C4,G4
            // D4,C5
            println("moge")
        }
    }

    data class Pair(val base: PitchName, val counter: PitchName)

    fun checkValidWholeNotesCounterPoint(melody: List<Pair>) {

    }
}

