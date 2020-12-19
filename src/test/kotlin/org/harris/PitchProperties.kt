package org.harris

import io.kotest.matchers.shouldBe
import io.kotest.property.Exhaustive
import io.kotest.property.checkAll
import io.kotest.property.exhaustive.enum
import io.kotest.property.exhaustive.exhaustive
import io.kotest.property.exhaustive.ints
import io.kotest.runner.junit4.StringSpec

val pitches = listOf(
    Pitch.C,
    Pitch.G,
    Pitch.D,
    Pitch.A,
    Pitch.E,
    Pitch.B,
    Pitch.F,
    Pitch.BFlat,
    Pitch.EFlat,
    Pitch.AFlat,
    Pitch.DFlat,
    Pitch.GFlat,
    Pitch.FSharp,
    Pitch.CSharp,
    Pitch.GSharp,
    Pitch.DSharp,
    Pitch.ASharp
)

class PitchProperties: StringSpec({
    "Sharping and flating a note results in the original note pitch" {
        checkAll(pitches.exhaustive()) { pitch ->
            pitch.sharp().flat().value() shouldBe pitch.value()
        }
    }

    "Flating and sharping a note results in the original note pitch" {
        checkAll(pitches.exhaustive()) { pitch ->
            pitch.flat().sharp().value() shouldBe pitch.value()
        }
    }

    "A sharped note has a higher pitch except B" {
        checkAll(pitches.exhaustive()) { pitch ->
            if (pitch == Pitch.B) {
                pitch.sharp() == Pitch.C
            } else {
                pitch.sharp().value() > pitch.value()
            }
        }
    }

    "A ftated note has a lower pitch except C" {
        checkAll(pitches.exhaustive()) { pitch ->
            if (pitch == Pitch.C) {
                pitch.flat() == Pitch.B
            } else {
                pitch.flat().value() < pitch.value()
            }
        }
    }

    "semitones between a note and itself sharp n times is n semitones" {
        checkAll(pitches.exhaustive(), Exhaustive.ints(0..12)) { pitch, distance ->
            var transposed = pitch

            for (d in 0 until distance) {
                transposed = transposed.sharp()
            }

            if (distance == 12) {
                pitch.absoluteDistance(transposed) shouldBe 0
            } else {
                pitch.absoluteDistance(transposed) shouldBe distance
            }
        }
    }

    "semitones between a note and itself flat n times is n semitones" {
        checkAll(pitches.exhaustive(), Exhaustive.ints(0..12)) { pitch, distance ->
            var transposed = pitch

            for (d in 0 until distance) {
                transposed = transposed.flat()
            }

            if (distance == 12 || distance == 0) {
                pitch.absoluteDistance(transposed) shouldBe 0
            } else {
                pitch.absoluteDistance(transposed) shouldBe 12 - distance
            }
        }
    }

    "interval between a note and itself transposed by an interval is the interval with some exceptions" {
        checkAll(pitches.exhaustive(), Exhaustive.enum<Interval>()) { pitch, interval ->
            val to = pitch.transpose(interval)
            val resultingInterval = pitch.intervalTo(to)

            when (pitch) {
                Pitch.CSharp, Pitch.DSharp, Pitch.FSharp, Pitch.GSharp, Pitch.ASharp ->
                    if (interval == Interval.MinorSecond) {
                        resultingInterval shouldBe Interval.AugmentedUnison
                    }
                Pitch.E, Pitch.B, Pitch.BFlat, Pitch.AFlat, Pitch.DFlat, Pitch.GFlat ->
                    if (interval == Interval.AugmentedSecond) {
                        resultingInterval shouldBe Interval.MinorThird
                    }
                Pitch.EFlat ->
                    if (interval == Interval.DiminishedFifth) {
                        resultingInterval shouldBe Interval.AugmentedFourth
                    }
                else -> when (interval) {
                    Interval.Tritone -> resultingInterval shouldBe Interval.DiminishedFifth
                    Interval.DiminishedSeventh -> resultingInterval shouldBe Interval.MajorSixth
                    Interval.PerfectOctave -> resultingInterval shouldBe Interval.Unison
                    Interval.MinorNinth -> resultingInterval shouldBe Interval.MinorSecond
                    Interval.MajorNinth -> resultingInterval shouldBe Interval.MajorSecond
                    Interval.AugmentedNinth -> resultingInterval shouldBe Interval.AugmentedSecond
                    Interval.PerfectEleventh -> resultingInterval shouldBe Interval.PerfectFourth
                    Interval.AugmentedEleventh -> resultingInterval shouldBe Interval.AugmentedFourth
                    Interval.MinorThirteenth -> resultingInterval shouldBe Interval.MinorSixth
                    Interval.MajorThirteenth -> resultingInterval shouldBe Interval.MajorSixth
                    else -> resultingInterval shouldBe interval
                }
            }
        }
    }
})