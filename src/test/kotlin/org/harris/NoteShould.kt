package org.harris

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import io.kotest.matchers.shouldBe
import io.kotest.property.Exhaustive
import io.kotest.property.checkAll
import io.kotest.property.exhaustive.enum
import io.kotest.property.exhaustive.exhaustive
import io.kotest.property.exhaustive.ints
import io.kotest.runner.junit4.StringSpec
import org.harris.Interval.*
import org.harris.Note.*
import org.junit.Test

val notes = listOf<Note>(C, D, E, F, G, A, B)

class NotesShould: StringSpec({
    "Sharping and flating a note results in the original note pitch" {
        checkAll(notes.exhaustive()) { note ->
            note.sharp().flat().pitch() shouldBe note.pitch()
        }
    }

    "Flating and sharping a note results in the original note pitch" {
        checkAll(notes.exhaustive()) { note ->
            note.flat().sharp().pitch() shouldBe note.pitch()
        }
    }

    "A sharped note has a higher pitch except B" {
        checkAll(notes.exhaustive()) { note ->
            if (note == B) {
                note.sharp() == C
            }
            else {
                note.sharp().pitch() > note.pitch()
            }
        }
    }

    "A ftated note has a lower pitch except C" {
        checkAll(notes.exhaustive()) { note ->
            if (note == C) {
                note.flat() == B
            }
            else {
                note.flat().pitch() < note.pitch()
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

    "measure interval between a note and itself transposed by an interval to be the transposing interval" {
        checkAll(listOf(C, G, D, A, E, B, F).exhaustive(), Exhaustive.enum<Interval>()) { note, interval ->
            val to = note.transpose(interval)
            val resultingInterval = note.intervalBetween(to)
            println("$note:$to:$interval -> $resultingInterval")

            when(note) {
                B -> if (interval == MinorThird) {
                    resultingInterval shouldBe AugmentedSecond
                }
                else -> when(interval) {
                    Tritone -> resultingInterval shouldBe DiminishedFifth
                    DiminishedSeventh -> resultingInterval shouldBe MajorSixth
                    PerfectOctave -> resultingInterval shouldBe Unison
                    MinorNinth -> resultingInterval shouldBe MinorSecond
                    MajorNinth -> resultingInterval shouldBe MajorSecond
                    AugmentedNinth -> resultingInterval shouldBe AugmentedSecond
                    PerfectEleventh -> resultingInterval shouldBe PerfectFourth
                    AugmentedEleventh -> resultingInterval shouldBe AugmentedFourth
                    MinorThirteenth -> resultingInterval shouldBe MinorSixth
                    MajorThirteenth -> resultingInterval shouldBe MajorSixth
                    else -> resultingInterval shouldBe interval
                }
            }
        }
    }
})

class NaturalNoteShould {

    @Test
    fun `sharp C to C sharp`() {
        assertThat(C.sharp(), equalTo(C.sharp()))
    }

    @Test
    fun `sharp C sharp to D`() {
        assertThat(CSharp.sharp(), equalTo(D))
    }

    @Test
    fun `sharp D flat to D`() {
        assertThat(DFlat.sharp(), equalTo(D))
    }

    @Test
    fun `sharp D to D sharp`() {
        assertThat(D.sharp(), equalTo(DSharp))
    }

    @Test
    fun `sharp D sharp to E`() {
        assertThat(DSharp.sharp(), equalTo(E))
    }

    @Test
    fun `sharp E flat to E`() {
        assertThat(EFlat.sharp(), equalTo(E))
    }

    @Test
    fun `sharp E to F`() {
        assertThat(E.sharp(), equalTo(F))
    }

    @Test
    fun `sharp F to F sharp`() {
        assertThat(F.sharp(), equalTo(FSharp))
    }

    @Test
    fun `sharp F sharp to G`() {
        assertThat(FSharp.sharp(), equalTo(G))
    }

    @Test
    fun `sharp G flat to G`() {
        assertThat(GFlat.sharp(), equalTo(G))
    }

    @Test
    fun `sharp G to G sharp`() {
        assertThat(G.sharp(), equalTo(GSharp))
    }

    @Test
    fun `sharp G sharp to A`() {
        assertThat(GSharp.sharp(), equalTo(A))
    }

    @Test
    fun `sharp A flat to A`() {
        assertThat(AFlat.sharp(), equalTo(A))
    }

    @Test
    fun `sharp A to A sharp`() {
        assertThat(A.sharp(), equalTo(ASharp))
    }

    @Test
    fun `sharp A sharp to B`() {
        assertThat(ASharp.sharp(), equalTo(B))
    }

    @Test
    fun `sharp B flat to B`() {
        assertThat(BFlat.sharp(), equalTo(B))
    }

    @Test
    fun `sharp B to C`() {
        assertThat(B.sharp(), equalTo(C))
    }

    @Test
    fun `flat C to B`() {
        assertThat(C.flat(), equalTo(B))
    }

    @Test
    fun `flat C sharp to C`() {
        assertThat(CSharp.flat(), equalTo(C))
    }

    @Test
    fun `flat D flat to C`() {
        assertThat(DFlat.flat(), equalTo(C))
    }

    @Test
    fun `flat D to D flat`() {
        assertThat(D.flat(), equalTo(DFlat))
    }

    @Test
    fun `flat D sharp to D`() {
        assertThat(DSharp.flat(), equalTo(D))
    }

    @Test
    fun `flat E flat to D`() {
        assertThat(EFlat.flat(), equalTo(D))
    }

    @Test
    fun `flat E to E Flat`() {
        assertThat(E.flat(), equalTo(EFlat))
    }

    @Test
    fun `flat F to E`() {
        assertThat(F.flat(), equalTo(E))
    }

    @Test
    fun `flat F sharp to F`() {
        assertThat(FSharp.flat(), equalTo(F))
    }

    @Test
    fun `flat G flat to F`() {
        assertThat(GFlat.flat(), equalTo(F))
    }

    @Test
    fun `flat G to G flat`() {
        assertThat(G.flat(), equalTo(GFlat))
    }

    @Test
    fun `flat G sharp to G`() {
        assertThat(GSharp.flat(), equalTo(G))
    }

    @Test
    fun `flat A flat to G`() {
        assertThat(AFlat.flat(), equalTo(G))
    }

    @Test
    fun `flat A to A flat`() {
        assertThat(A.flat(), equalTo(AFlat))
    }

    @Test
    fun `flat A sharp to A`() {
        assertThat(ASharp.flat(), equalTo(A))
    }

    @Test
    fun `flat B flat to A`() {
        assertThat(BFlat.flat(), equalTo(A))
    }

    @Test
    fun `flat B to B flat`() {
        assertThat(B.flat(), equalTo(BFlat))
    }

    @Test
    fun `measure semitones between C and C to zero semitones`() {
        assertThat(C.absoluteDistance(C), equalTo(0))
    }

    @Test
    fun `measure semitones between C and C sharp to one semitone`() {
        assertThat(C.absoluteDistance(CSharp), equalTo(1))
    }

    @Test
    fun `measure semitones between C and D flat to one semitone`() {
        assertThat(C.absoluteDistance(DFlat), equalTo(1))
    }

    @Test
    fun `measure semitones between C and D to two semitones`() {
        assertThat(C.absoluteDistance(D), equalTo(2))
    }

    @Test
    fun `measure semitones between C and D sharp to three semitones`() {
        assertThat(C.absoluteDistance(DSharp), equalTo(3))
    }

    @Test
    fun `measure semitones between C and E flat to three semitones`() {
        assertThat(C.absoluteDistance(EFlat), equalTo(3))
    }

    @Test
    fun `measure semitones between C and E to four semitones`() {
        assertThat(C.absoluteDistance(E), equalTo(4))
    }

    @Test
    fun `measure semitones between C and F to five semitones`() {
        assertThat(C.absoluteDistance(F), equalTo(5))
    }

    @Test
    fun `measure semitones between C and F sharp to six semitones`() {
        assertThat(C.absoluteDistance(FSharp), equalTo(6))
    }

    @Test
    fun `measure semitones between C and G flat to six semitones`() {
        assertThat(C.absoluteDistance(GFlat), equalTo(6))
    }

    @Test
    fun `measure semitones between C and G to seven semitones`() {
        assertThat(C.absoluteDistance(G), equalTo(7))
    }

    @Test
    fun `measure semitones between C and G sharp to eight semitones`() {
        assertThat(C.absoluteDistance(GSharp), equalTo(8))
    }

    @Test
    fun `measure semitones between C and A flat to eight semitones`() {
        assertThat(C.absoluteDistance(AFlat), equalTo(8))
    }

    @Test
    fun `measure semitones between C and A to nine semitones`() {
        assertThat(C.absoluteDistance(A), equalTo(9))
    }

    @Test
    fun `measure semitones between C and A sharp to ten semitones`() {
        assertThat(C.absoluteDistance(ASharp), equalTo(10))
    }

    @Test
    fun `measure semitones between C and B flat to ten semitones`() {
        assertThat(C.absoluteDistance(BFlat), equalTo(10))
    }

    @Test
    fun `measure semitones between C and B to eleven semitones`() {
        assertThat(C.absoluteDistance(B), equalTo(11))
    }

    @Test
    fun `measure interval between C and C as Unison`() {
        assertThat(C.intervalBetween(C), equalTo(Unison))
    }

    @Test
    fun `measure interval between C and D flat as MinorSecond`() {
        assertThat(C.intervalBetween(DFlat), equalTo(MinorSecond))
    }

    @Test
    fun `measure interval between C and D as MajorSecond`() {
        assertThat(C.intervalBetween(D), equalTo(MajorSecond))
    }

    @Test
    fun `measure interval between C and E flat as MinorThird`() {
        assertThat(C.intervalBetween(EFlat), equalTo(MinorThird))
    }

    @Test
    fun `measure interval between C and E as MajorThird`() {
        assertThat(C.intervalBetween(E), equalTo(MajorThird))
    }

    @Test
    fun `measure interval between C and F as PerfectFourth`() {
        assertThat(C.intervalBetween(F), equalTo(PerfectFourth))
    }

    @Test
    fun `measure interval between C and F sharp as AugmentedFourth`() {
        assertThat(C.intervalBetween(FSharp), equalTo(AugmentedFourth))
    }

    @Test
    fun `measure interval between C and G flat as DiminishedFifth`() {
        assertThat(C.intervalBetween(GFlat), equalTo(DiminishedFifth))
    }

    @Test
    fun `measure interval between C and G as PerfectFifth`() {
        assertThat(C.intervalBetween(G), equalTo(PerfectFifth))
    }

    @Test
    fun `measure interval between C and G sharp as AugmentedFifth`() {
        assertThat(C.intervalBetween(GSharp), equalTo(AugmentedFifth))
    }

    @Test
    fun `measure interval between C and A flat as MinorSixth`() {
        assertThat(C.intervalBetween(AFlat), equalTo(MinorSixth))
    }

    @Test
    fun `measure interval between C and A as MajorSixth`() {
        assertThat(C.intervalBetween(A), equalTo(MajorSixth))
    }

    @Test
    fun `measure interval between C and B flat as MinorSeventh`() {
        assertThat(C.intervalBetween(BFlat), equalTo(MinorSeventh))
    }

    @Test
    fun `measure interval between C and B as MajorSeventh`() {
        assertThat(C.intervalBetween(B), equalTo(MajorSeventh))
    }

    @Test
    fun `measure interval between D and F as MinorThird`() {
        assertThat(D.intervalBetween(F), equalTo(MinorThird))
    }

    @Test
    fun `transpose using a Unison from C to C`() {
        assertThat(C.transpose(Unison), equalTo(C))
    }

    @Test
    fun `transpose using a Unison from C# to C#`() {
        assertThat(CSharp.transpose(Unison), equalTo(CSharp))
    }

    @Test
    fun `transpose using a MinorSecond from C to D flat`() {
        assertThat(C.transpose(MinorSecond), equalTo(DFlat))
    }

    @Test
    fun `transpose using a MajorSecond from C to D`() {
        assertThat(C.transpose(MajorSecond), equalTo(D))
    }

    @Test
    fun `transpose using a AugmentedSecond from C to D sharp`() {
        assertThat(C.transpose(AugmentedSecond), equalTo(DSharp))
    }

    @Test
    fun `transpose using a MinorThird from C to E flat`() {
        assertThat(C.transpose(MinorThird), equalTo(EFlat))
    }

    @Test
    fun `transpose using a MajorThird from C to E`() {
        assertThat(C.transpose(MajorThird), equalTo(E))
    }

    @Test
    fun `transpose using a PerfectFourth from C to F`() {
        assertThat(C.transpose(PerfectFourth), equalTo(F))
    }

    @Test
    fun `transpose using a AugmentedFourth from C to F sharp`() {
        assertThat(C.transpose(AugmentedFourth), equalTo(FSharp))
    }

    @Test
    fun `transpose using a DiminishedFifth from C to G flat`() {
        assertThat(C.transpose(DiminishedFifth), equalTo(GFlat))
    }

    @Test
    fun `transpose using a PerfectFifth from C to G`() {
        assertThat(C.transpose(PerfectFifth), equalTo(G))
    }

    @Test
    fun `transpose using a PerfectFifth from D to A`() {
        assertThat(D.transpose(PerfectFifth), equalTo(A))
    }

    @Test
    fun `transpose using a AugmentedFifth from C to G sharp`() {
        assertThat(C.transpose(AugmentedFifth), equalTo(GSharp))
    }

    @Test
    fun `transpose using a MinorSixth from C to A flat`() {
        assertThat(C.transpose(MinorSixth), equalTo(AFlat))
    }

    @Test
    fun `transpose using a MajorSixth from C to A`() {
        assertThat(C.transpose(MajorSixth), equalTo(A))
    }

    @Test
    fun `transpose using a diminished seventh from C to B flat flat`() {
        assertThat(C.transpose(DiminishedSeventh), equalTo(A))
    }

    @Test
    fun `transpose using a diminished seventh from G to E`() {
        assertThat(G.transpose(DiminishedSeventh), equalTo(E))
    }

    @Test
    fun `transpose using a minor seventh from C to B flat`() {
        assertThat(C.transpose(MinorSeventh), equalTo(BFlat))
    }

    @Test
    fun `transpose using a MajorSeventh from C to B`() {
        assertThat(C.transpose(MajorSeventh), equalTo(B))
    }

    @Test
    fun `transpose using a augmented ninth from G to A#`() {
        assertThat(G.transpose(AugmentedNinth), equalTo(ASharp))
    }

    @Test
    fun `transpose using a perfect eleventh from G to C`() {
        assertThat(G.transpose(PerfectEleventh), equalTo(C))
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
