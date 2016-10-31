package com.sys1yagi.counterpoint

import org.assertj.core.api.Assertions.assertThat
import org.junit.Ignore
import org.junit.Test


class IntervalTest {

    @Ignore
    @Test
    fun getTypeConsonance() {
        // 3

        // 5
        run {
            val interval = Interval(
                    Pitch(Pitch.Name.C, 4),
                    Pitch(Pitch.Name.G, 4)
            )
            assertThat(interval.type).isEqualTo(Interval.Type.Consonance)
        }

        // 6

        // 8
    }

    @Ignore
    @Test
    fun getTypeDissonance() {

        // 2

        // 4
        run {
            val interval = Interval(
                    Pitch(Pitch.Name.C, 4),
                    Pitch(Pitch.Name.F, 4)
            )
            assertThat(interval.type).isEqualTo(Interval.Type.Dissonance)
        }

        // 7

    }
}