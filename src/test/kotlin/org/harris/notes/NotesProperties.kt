package org.harris.notes

import io.kotest.matchers.shouldBe
import io.kotest.property.Exhaustive
import io.kotest.property.checkAll
import io.kotest.property.exhaustive.enum
import io.kotest.property.exhaustive.exhaustive
import io.kotest.property.exhaustive.ints
import io.kotest.runner.junit4.StringSpec

class NotesProperties :
    StringSpec({
        "Sharping and flating a note results in the original note pitch" {
            checkAll(notes.exhaustive()) { note ->
                note.sharp().flat().value() shouldBe note.value()
            }
        }

        "Flating and sharping a note results in the original note pitch" {
            checkAll(notes.exhaustive()) { note ->
                note.flat().sharp().value() shouldBe note.value()
            }
        }

        "A sharped note has a higher pitch except B" {
            checkAll(notes.exhaustive()) { note ->
                if (note == Pitch.B) {
                    note.sharp() == Pitch.C
                } else {
                    note.sharp().value() > note.value()
                }
            }
        }

        "A ftated note has a lower pitch except C" {
            checkAll(notes.exhaustive()) { note ->
                if (note == Pitch.C) {
                    note.flat() == Pitch.B
                } else {
                    note.flat().value() < note.value()
                }
            }
        }

        "measure semitones between a note and itself sharp n times to n semitones" {
            checkAll(notes.exhaustive(), Exhaustive.ints(0..12)) { note, distance ->
                var transposed = note

                for (d in 0 until distance) {
                    transposed = transposed.sharp()
                }

                if (distance == 12) {
                    note.absoluteDistance(transposed) shouldBe 0
                } else {
                    note.absoluteDistance(transposed) shouldBe distance
                }
            }
        }

        "measure semitones between a note and itself flat n times to n semitones" {
            checkAll(notes.exhaustive(), Exhaustive.ints(0..12)) { note, distance ->
                var transposed = note

                for (d in 0 until distance) {
                    transposed = transposed.flat()
                }

                if (distance == 12 || distance == 0) {
                    note.absoluteDistance(transposed) shouldBe 0
                } else {
                    note.absoluteDistance(transposed) shouldBe 12 - distance
                }
            }
        }

        "measure interval between a note and itself transposed by that interval to be that interval" {
            checkAll(
                listOf(
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
                ).exhaustive(),
                Exhaustive.enum<Interval>(),
            ) { note, interval ->
                val to = note.transpose(interval)
                // println("$note:$to:$interval")
                val resultingInterval = note.intervalTo(to)
                // println("$note:$to:$interval -> $resultingInterval")

                when (interval) {
                    Interval.MajorNinth -> resultingInterval shouldBe Interval.MajorSecond
                    Interval.PerfectEleventh -> resultingInterval shouldBe Interval.PerfectFourth
                    Interval.AugmentedEleventh -> resultingInterval shouldBe Interval.AugmentedFourth
                    Interval.MajorThirteenth -> resultingInterval shouldBe Interval.MajorSixth
                    Interval.PerfectOctave -> resultingInterval shouldBe Interval.Unison

                    Interval.DiminishedSeventh -> {
                        if (resultingInterval == Interval.MajorSixth || resultingInterval == Interval.DiminishedSeventh) {
                            resultingInterval shouldBe resultingInterval
                        }
                    }
                    Interval.MinorThird, Interval.AugmentedNinth, Interval.AugmentedSecond -> {
                        if (resultingInterval == Interval.MinorThird || resultingInterval == Interval.AugmentedSecond) {
                            resultingInterval shouldBe resultingInterval
                        }
                    }
                    Interval.MinorThirteenth, Interval.MinorSixth, Interval.AugmentedFifth -> {
                        if (resultingInterval == Interval.MinorThirteenth ||
                            resultingInterval == Interval.MinorSixth ||
                            resultingInterval == Interval.AugmentedFifth
                        ) {
                            resultingInterval shouldBe resultingInterval
                        }
                    }
                    Interval.Tritone, Interval.DiminishedFifth, Interval.AugmentedFourth -> {
                        if (resultingInterval == Interval.AugmentedFourth ||
                            resultingInterval == Interval.DiminishedFifth
                        ) {
                            resultingInterval shouldBe resultingInterval
                        }
                    }
                    Interval.MinorNinth, Interval.MinorSecond, Interval.AugmentedUnison -> {
                        if (resultingInterval == Interval.MinorNinth ||
                            resultingInterval == Interval.MinorSecond ||
                            resultingInterval == Interval.AugmentedUnison
                        ) {
                            resultingInterval shouldBe resultingInterval
                        }
                    }
                    else -> resultingInterval shouldBe interval
                }
            }
        }
    })
