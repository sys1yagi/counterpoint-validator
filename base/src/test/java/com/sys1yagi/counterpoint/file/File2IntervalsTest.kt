package com.sys1yagi.counterpoint.file

import com.sys1yagi.counterpoint.Pitch
import com.sys1yagi.counterpoint.exception.InvalidPitchNameException
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.io.File
import java.io.FileNotFoundException

class File2IntervalsTest {

    @Test
    fun wholeNotesFromFile(){
        val intervals = File2Intervals.wholeNotesFromFile(File("../score/sample_invalid_counter_point.txt"))
        assertThat(intervals).isNotEmpty()
        assertThat(intervals.size).isEqualTo(10)

        val first = intervals[0]
        assertThat(first.base.name).isEqualTo(Pitch.Name.C)
        assertThat(first.counter.name).isEqualTo(Pitch.Name.C)
        assertThat(first.intervalInt).isEqualTo(12)
    }

    @Test(expected = FileNotFoundException::class)
    fun fileNotFound(){
        File2Intervals.wholeNotesFromFile(File("hoge/hoge"))
    }

    @Test(expected = InvalidPitchNameException::class)
    fun invalidPitchNameException(){
        File2Intervals.wholeNotesFromFile(File("../score/sample_invalid_format.txt"))
    }
}