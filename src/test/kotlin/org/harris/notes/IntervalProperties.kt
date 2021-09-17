package org.harris.notes

import io.kotest.matchers.shouldBe
import io.kotest.property.checkAll
import io.kotest.property.exhaustive.exhaustive
import io.kotest.runner.junit4.StringSpec
import org.harris.notes.Interval.*

val intervals =
    listOf(
        Unison,
        AugmentedUnison,
        MinorSecond,
        MajorSecond,
        AugmentedSecond,
        MinorThird,
        MajorThird,
        PerfectFourth,
        AugmentedFourth,
        DiminishedFifth,
        PerfectFifth,
        MinorSixth,
        MajorSixth,
        DiminishedSeventh,
        MinorSeventh,
        MajorSeventh,
        PerfectOctave
    )

class IntervalProperties :
    StringSpec({
        "Inverting an interval twice results in starting interval" {
            checkAll(intervals.exhaustive()) { interval ->
                interval.invert().invert() shouldBe interval
            }
        }
    })
