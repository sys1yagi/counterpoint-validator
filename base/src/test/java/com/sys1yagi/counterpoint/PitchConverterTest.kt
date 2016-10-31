package com.sys1yagi.counterpoint

import com.sys1yagi.counterpoint.exception.InvalidPitchNameException
import org.junit.Test
import org.assertj.core.api.Assertions.assertThat

class PitchConverterTest{

    @Test
    fun convertSuccess(){
        val pitch = PitchConverter.stringToPitch("C4")
        assertThat(pitch.name).isEqualTo(Pitch.Name.C)
        assertThat(pitch.level).isEqualTo(4)

        val pitch2 = PitchConverter.stringToPitch("DF10")
        assertThat(pitch2.name).isEqualTo(Pitch.Name.DF)
        assertThat(pitch2.level).isEqualTo(10)
    }

    @Test(expected = InvalidPitchNameException::class)
    fun convertFailed(){
        PitchConverter.stringToPitch("C")
    }
}