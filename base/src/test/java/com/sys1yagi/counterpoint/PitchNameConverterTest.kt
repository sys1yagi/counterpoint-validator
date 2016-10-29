package com.sys1yagi.counterpoint

import com.sys1yagi.counterpoint.exception.InvalidPitchNameException
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PitchNameConverterTest {
    @Test
    fun stringToPitchNameValid() {
        
    }

    @Test
    fun lowerCase() {
        PitchNameConverter.stringToPitchName("c1")
    }

    @Test(expected = InvalidPitchNameException::class)
    fun stringToPitchNameInValid() {
        PitchNameConverter.stringToPitchName("V")
    }

    @Test(expected = InvalidPitchNameException::class)
    fun stringToPitchNameInEmpty() {
        PitchNameConverter.stringToPitchName("")
    }
}