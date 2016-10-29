package com.sys1yagi.counterpoint

import com.sys1yagi.counterpoint.exception.InvalidPitchNameException
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PitchNameConverterTest {
    @Test
    fun stringToPitchNameValid() {
        run {
            val pitchName = PitchNameConverter.stringToPitchName("C1")
            assertThat(pitchName).isEqualTo(PitchName.C)
        }
        run {
            val pitchName = PitchNameConverter.stringToPitchName("D1")
            assertThat(pitchName).isEqualTo(PitchName.D)
        }
        run {
            val pitchName = PitchNameConverter.stringToPitchName("DF4")
            assertThat(pitchName).isEqualTo(PitchName.DF)
        }
        run {
            val pitchName = PitchNameConverter.stringToPitchName("F4")
            assertThat(pitchName).isEqualTo(PitchName.F)
        }
        run {
            val pitchName = PitchNameConverter.stringToPitchName("GF4")
            assertThat(pitchName).isEqualTo(PitchName.GF)
        }
        run {
            val pitchName = PitchNameConverter.stringToPitchName("G8")
            assertThat(pitchName).isEqualTo(PitchName.G)
        }
        run {
            val pitchName = PitchNameConverter.stringToPitchName("AF3")
            assertThat(pitchName).isEqualTo(PitchName.AF)
        }
        run {
            val pitchName = PitchNameConverter.stringToPitchName("A4")
            assertThat(pitchName).isEqualTo(PitchName.A)
        }
        run {
            val pitchName = PitchNameConverter.stringToPitchName("BF4")
            assertThat(pitchName).isEqualTo(PitchName.BF)
        }
        run {
            val pitchName = PitchNameConverter.stringToPitchName("B2")
            assertThat(pitchName).isEqualTo(PitchName.B)
        }
    }

    @Test
    fun lowerCase() {
        val pitchName = PitchNameConverter.stringToPitchName("c1")
        assertThat(pitchName).isEqualTo(PitchName.C)
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