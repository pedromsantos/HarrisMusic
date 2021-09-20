package org.harris.notes

import io.kotest.matchers.shouldBe
import io.kotest.property.checkAll
import io.kotest.property.exhaustive.exhaustive
import io.kotest.runner.junit4.StringSpec
import org.harris.notes.Interval.AugmentedFourth
import org.harris.notes.Interval.AugmentedSecond
import org.harris.notes.Interval.AugmentedUnison
import org.harris.notes.Interval.DiminishedFifth
import org.harris.notes.Interval.DiminishedSeventh
import org.harris.notes.Interval.MajorSecond
import org.harris.notes.Interval.MajorSeventh
import org.harris.notes.Interval.MajorSixth
import org.harris.notes.Interval.MajorThird
import org.harris.notes.Interval.MinorSecond
import org.harris.notes.Interval.MinorSeventh
import org.harris.notes.Interval.MinorSixth
import org.harris.notes.Interval.MinorThird
import org.harris.notes.Interval.PerfectFifth
import org.harris.notes.Interval.PerfectFourth
import org.harris.notes.Interval.PerfectOctave
import org.harris.notes.Interval.Unison

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
