package com.sys1yagi.counterpoint.file

import com.sys1yagi.counterpoint.Interval
import com.sys1yagi.counterpoint.exception.InvalidPitchNameException
import java.io.File
import java.io.FileNotFoundException

object File2Intervals {

    @Throws(FileNotFoundException::class, InvalidPitchNameException::class)
    fun wholeNotesFromFile(file: File): List<Interval> {
        return file.inputStream().bufferedReader().readLines().map {
            val pitches = it.split(",")
            Interval.create(
                    pitches[0], pitches[1]
            )
        }
    }
}