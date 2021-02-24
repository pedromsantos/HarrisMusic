package org.harris.notes

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import io.kotest.matchers.shouldBe
import io.kotest.property.Exhaustive
import io.kotest.property.checkAll
import io.kotest.property.exhaustive.enum
import io.kotest.property.exhaustive.exhaustive
import io.kotest.property.exhaustive.ints
import io.kotest.runner.junit4.StringSpec
import org.harris.notes.Interval.*
import org.harris.notes.Pitch.*
import org.junit.Test

val notes = listOf(C, CSharp, DFlat, D, DSharp, EFlat, E, F, FSharp, GFlat, G, AFlat, A, ASharp, BFlat, B)

class NotesShould: StringSpec({
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
            if (note == B) {
                note.sharp() == C
            }
            else {
                note.sharp().value() > note.value()
            }
        }
    }

    "A ftated note has a lower pitch except C" {
        checkAll(notes.exhaustive()) { note ->
            if (note == C) {
                note.flat() == B
            }
            else {
                note.flat().value() < note.value()
            }
        }
    }

    "measure semitones between a note and itself sharp n times to n semitones" {
        checkAll(notes.exhaustive(), Exhaustive.ints(0..12)) { note, distance ->
            var transposed = note

            for(d in 0 until distance) {
                transposed = transposed.sharp()
            }

            if(distance == 12) {
                note.absoluteDistance(transposed) shouldBe 0
            }
            else {
                note.absoluteDistance(transposed) shouldBe distance
            }
        }
    }

    "measure semitones between a note and itself flat n times to n semitones" {
        checkAll(notes.exhaustive(), Exhaustive.ints(0..12)) { note, distance ->
            var transposed = note

            for(d in 0 until distance) {
                transposed = transposed.flat()
            }

            if(distance == 12 || distance == 0) {
                note.absoluteDistance(transposed) shouldBe 0
            }
            else {
                note.absoluteDistance(transposed) shouldBe 12 - distance
            }
        }
    }

    "measure interval between a note and itself transposed by that interval to be that interval" {
        checkAll(listOf(C, G, D, A, E, B, F, BFlat, EFlat, AFlat, DFlat, GFlat).exhaustive(), Exhaustive.enum<Interval>()) { note, interval ->
            val to = note.transpose(interval)
            println("$note:$to:$interval")
            val resultingInterval = note.intervalTo(to)
            println("$note:$to:$interval -> $resultingInterval")

            when(interval) {
                MajorNinth -> resultingInterval shouldBe MajorSecond
                PerfectEleventh -> resultingInterval shouldBe PerfectFourth
                AugmentedEleventh -> resultingInterval shouldBe AugmentedFourth
                MajorThirteenth -> resultingInterval shouldBe MajorSixth
                PerfectOctave -> resultingInterval shouldBe Unison

                DiminishedSeventh -> {
                    if(resultingInterval == MajorSixth || resultingInterval == DiminishedSeventh)
                        resultingInterval shouldBe resultingInterval
                }
                MinorThird, AugmentedNinth, AugmentedSecond -> {
                    if(resultingInterval == MinorThird || resultingInterval == AugmentedSecond)
                        resultingInterval shouldBe resultingInterval
                }
                MinorThirteenth, MinorSixth, AugmentedFifth -> {
                    if(resultingInterval == MinorThirteenth || resultingInterval == MinorSixth || resultingInterval == AugmentedFifth)
                        resultingInterval shouldBe resultingInterval
                }
                Tritone, DiminishedFifth , AugmentedFourth -> {
                    if(resultingInterval == AugmentedFourth || resultingInterval == DiminishedFifth)
                        resultingInterval shouldBe resultingInterval
                }
                MinorNinth, MinorSecond, AugmentedUnison -> {
                    if(resultingInterval == MinorNinth || resultingInterval == MinorSecond || resultingInterval == AugmentedUnison)
                        resultingInterval shouldBe resultingInterval
                }
                else -> resultingInterval shouldBe interval
            }
        }
    }
})

class NoteShould {

    @Test
    fun `transpose using a augmented ninth from G to A#`() {
        assertThat(G.transpose(AugmentedNinth), equalTo(ASharp))
    }

    @Test
    fun `transpose using a perfect eleventh from F to Bb`() {
        assertThat(F.transpose(PerfectFourth), equalTo(BFlat))
    }

    @Test
    fun `transpose using a augmented second from D to E#`() {
        assertThat(D.transpose(AugmentedSecond), equalTo(ESharp))
    }

    @Test
    fun `transpose using a minor third from G to Bb`() {
        assertThat(G.transpose(MinorThird), equalTo(BFlat))
    }

    @Test
    fun `transpose using a major third from G to B`() {
        assertThat(G.transpose(MajorThird), equalTo(B))
    }
}
