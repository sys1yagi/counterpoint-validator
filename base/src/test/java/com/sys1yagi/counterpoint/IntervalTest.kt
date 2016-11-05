package com.sys1yagi.counterpoint

import org.assertj.core.api.Assertions.assertThat
import org.junit.Ignore
import org.junit.Test


class IntervalTest {

    @Test
    fun intervalInt() {
        run {
            val interval = Interval(
                    Pitch(Pitch.Name.C, 4),
                    Pitch(Pitch.Name.F, 4)
            )
            assertThat(interval.intervalInt).isEqualTo(5)
        }
        run {
            val interval = Interval(
                    Pitch(Pitch.Name.C, 4),
                    Pitch(Pitch.Name.G, 4)
            )
            assertThat(interval.intervalInt).isEqualTo(7)
        }
        run {
            val interval = Interval(
                    Pitch(Pitch.Name.C, 4),
                    Pitch(Pitch.Name.D, 5)
            )
            assertThat(interval.intervalInt).isEqualTo(14)
        }
    }

    @Test
    fun getTypeConsonance() {
        // 3
        run {
            val interval = Interval(
                    Pitch(Pitch.Name.C, 4),
                    Pitch(Pitch.Name.E, 4)
            )
            assertThat(interval.type).isEqualTo(Interval.Type.Consonance)
        }
        run {
            val interval = Interval(
                    Pitch(Pitch.Name.C, 4),
                    Pitch(Pitch.Name.E, 6)
            )
            assertThat(interval.type).isEqualTo(Interval.Type.Consonance)
        }

        // 5
        run {
            val interval = Interval(
                    Pitch(Pitch.Name.C, 4),
                    Pitch(Pitch.Name.G, 4)
            )
            assertThat(interval.type).isEqualTo(Interval.Type.Consonance)
        }

        // 6
        run {
            val interval = Interval(
                    Pitch(Pitch.Name.C, 4),
                    Pitch(Pitch.Name.A, 4)
            )
            assertThat(interval.type).isEqualTo(Interval.Type.Consonance)
        }

        // 8
        run {
            val interval = Interval(
                    Pitch(Pitch.Name.C, 4),
                    Pitch(Pitch.Name.C, 3)
            )
            assertThat(interval.type).isEqualTo(Interval.Type.Consonance)
        }
        run {
            val interval = Interval(
                    Pitch(Pitch.Name.C, 4),
                    Pitch(Pitch.Name.C, 5)
            )
            assertThat(interval.type).isEqualTo(Interval.Type.Consonance)
        }
    }

    @Test
    fun getTypeDissonance() {

        // 2
        run {
            val interval = Interval(
                    Pitch(Pitch.Name.C, 4),
                    Pitch(Pitch.Name.D, 4)
            )
            assertThat(interval.type).isEqualTo(Interval.Type.Dissonance)
        }

        // 4
        run {
            val interval = Interval(
                    Pitch(Pitch.Name.C, 4),
                    Pitch(Pitch.Name.F, 4)
            )
            assertThat(interval.type).isEqualTo(Interval.Type.Dissonance)
        }

        // 7
        run {
            val interval = Interval(
                    Pitch(Pitch.Name.C, 4),
                    Pitch(Pitch.Name.B, 4)
            )
            assertThat(interval.type).isEqualTo(Interval.Type.Dissonance)
        }

    }
}