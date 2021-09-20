package org.harris.melodicLines

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.harris.notes.Pitch.C
import org.harris.scales.Scale
import org.harris.scales.ScaleDegree.I
import org.harris.scales.ScaleDegree.II
import org.harris.scales.ScaleDegree.III
import org.harris.scales.ScaleDegree.IV
import org.harris.scales.ScaleDegree.V
import org.harris.scales.ScaleDegree.VI
import org.harris.scales.ScaleDegree.VII
import org.harris.scales.ScalePattern.Ionian
import org.junit.Test

class MelodicLineShould {
    private val scale = Scale(Ionian, C)

    @Test
    fun `Generate thirds melodic line for C Ionian with half tone approach from bellow`() {
        val expected = MelodicLineHalfToneApproachFromBelow(
            MelodicLine(
                listOf(
                    MelodicPhrase(listOf(scale.note(I), scale.note(III))),
                    MelodicPhrase(listOf(scale.note(II), scale.note(IV))),
                    MelodicPhrase(listOf(scale.note(III), scale.note(V))),
                    MelodicPhrase(listOf(scale.note(IV), scale.note(VI))),
                    MelodicPhrase(listOf(scale.note(V), scale.note(VII))),
                    MelodicPhrase(listOf(scale.note(VI), scale.note(I))),
                    MelodicPhrase(listOf(scale.note(VII), scale.note(II)))
                )
            )
        )

        assertThat(MelodicLineHalfToneApproachFromBelow(scale.thirds()), equalTo(expected))
    }

    @Test
    fun `Generate triads melodic line for C Ionian with half tone approach from bellow`() {
        val expected = MelodicLineHalfToneApproachFromBelow(
            MelodicLine(
                listOf(
                    MelodicPhrase(listOf(scale.note(I), scale.note(III), scale.note(V))),
                    MelodicPhrase(listOf(scale.note(II), scale.note(IV), scale.note(VI))),
                    MelodicPhrase(listOf(scale.note(III), scale.note(V), scale.note(VII))),
                    MelodicPhrase(listOf(scale.note(IV), scale.note(VI), scale.note(I))),
                    MelodicPhrase(listOf(scale.note(V), scale.note(VII), scale.note(II))),
                    MelodicPhrase(listOf(scale.note(VI), scale.note(I), scale.note(III))),
                    MelodicPhrase(listOf(scale.note(VII), scale.note(II), scale.note(IV)))
                )
            )
        )

        assertThat(MelodicLineHalfToneApproachFromBelow(scale.triads()), equalTo(expected))
    }

    @Test
    fun `Generate chords melodic line for C Ionian with half tone approach from bellow`() {
        val expected = MelodicLineHalfToneApproachFromBelow(
            MelodicLine(
                listOf(
                    MelodicPhrase(listOf(scale.note(I), scale.note(III), scale.note(V), scale.note(VII))),
                    MelodicPhrase(listOf(scale.note(II), scale.note(IV), scale.note(VI), scale.note(I))),
                    MelodicPhrase(listOf(scale.note(III), scale.note(V), scale.note(VII), scale.note(II))),
                    MelodicPhrase(listOf(scale.note(IV), scale.note(VI), scale.note(I), scale.note(III))),
                    MelodicPhrase(listOf(scale.note(V), scale.note(VII), scale.note(II), scale.note(IV))),
                    MelodicPhrase(listOf(scale.note(VI), scale.note(I), scale.note(III), scale.note(V))),
                    MelodicPhrase(listOf(scale.note(VII), scale.note(II), scale.note(IV), scale.note(VI)))
                )
            )
        )

        assertThat(MelodicLineHalfToneApproachFromBelow(scale.chords()), equalTo(expected))
    }

    @Test
    fun `Generate pivot chords melodic line for C Ionian with half tone approach from bellow`() {
        val expected = MelodicLineHalfToneApproachFromBelow(
            MelodicLine(
                listOf(
                    MelodicPhrase(listOf(scale.note(I), scale.note(VII), scale.note(V), scale.note(III))),
                    MelodicPhrase(listOf(scale.note(II), scale.note(I), scale.note(VI), scale.note(IV))),
                    MelodicPhrase(listOf(scale.note(III), scale.note(II), scale.note(VII), scale.note(V))),
                    MelodicPhrase(listOf(scale.note(IV), scale.note(III), scale.note(I), scale.note(VI))),
                    MelodicPhrase(listOf(scale.note(V), scale.note(IV), scale.note(II), scale.note(VII))),
                    MelodicPhrase(listOf(scale.note(VI), scale.note(V), scale.note(III), scale.note(I))),
                    MelodicPhrase(listOf(scale.note(VII), scale.note(VI), scale.note(IV), scale.note(II)))
                )
            )
        )

        assertThat(MelodicLineHalfToneApproachFromBelow(scale.pivotChords()), equalTo(expected))
    }

    @Test
    fun `Generate pivot chords melodic line for C Ionian with half tone approach from up`() {
        val expected = MelodicLineHalfToneApproachFromAbove(
            MelodicLine(
                listOf(
                    MelodicPhrase(listOf(scale.note(I), scale.note(VII), scale.note(V), scale.note(III))),
                    MelodicPhrase(listOf(scale.note(II), scale.note(I), scale.note(VI), scale.note(IV))),
                    MelodicPhrase(listOf(scale.note(III), scale.note(II), scale.note(VII), scale.note(V))),
                    MelodicPhrase(listOf(scale.note(IV), scale.note(III), scale.note(I), scale.note(VI))),
                    MelodicPhrase(listOf(scale.note(V), scale.note(IV), scale.note(II), scale.note(VII))),
                    MelodicPhrase(listOf(scale.note(VI), scale.note(V), scale.note(III), scale.note(I))),
                    MelodicPhrase(listOf(scale.note(VII), scale.note(VI), scale.note(IV), scale.note(II)))
                )
            )
        )

        assertThat(MelodicLineHalfToneApproachFromAbove(scale.pivotChords()), equalTo(expected))
    }

    @Test
    fun `Generate pivot chords melodic line for C Ionian with chromatic enclosure approach`() {
        val expected = MelodicLineChromaticEnclosureApproach(
            MelodicLine(
                listOf(
                    MelodicPhrase(listOf(scale.note(I), scale.note(VII), scale.note(V), scale.note(III))),
                    MelodicPhrase(listOf(scale.note(II), scale.note(I), scale.note(VI), scale.note(IV))),
                    MelodicPhrase(listOf(scale.note(III), scale.note(II), scale.note(VII), scale.note(V))),
                    MelodicPhrase(listOf(scale.note(IV), scale.note(III), scale.note(I), scale.note(VI))),
                    MelodicPhrase(listOf(scale.note(V), scale.note(IV), scale.note(II), scale.note(VII))),
                    MelodicPhrase(listOf(scale.note(VI), scale.note(V), scale.note(III), scale.note(I))),
                    MelodicPhrase(listOf(scale.note(VII), scale.note(VI), scale.note(IV), scale.note(II)))
                )
            )
        )

        assertThat(MelodicLineChromaticEnclosureApproach(scale.pivotChords()), equalTo(expected))
    }

    @Test
    fun `Generate pivot chords melodic line for C Ionian with diatonic enclosure approach`() {
        val expected = MelodicLineDiatonicEnclosureApproach(
            MelodicLine(
                listOf(
                    MelodicPhrase(listOf(scale.note(I), scale.note(VII), scale.note(V), scale.note(III))),
                    MelodicPhrase(listOf(scale.note(II), scale.note(I), scale.note(VI), scale.note(IV))),
                    MelodicPhrase(listOf(scale.note(III), scale.note(II), scale.note(VII), scale.note(V))),
                    MelodicPhrase(listOf(scale.note(IV), scale.note(III), scale.note(I), scale.note(VI))),
                    MelodicPhrase(listOf(scale.note(V), scale.note(IV), scale.note(II), scale.note(VII))),
                    MelodicPhrase(listOf(scale.note(VI), scale.note(V), scale.note(III), scale.note(I))),
                    MelodicPhrase(listOf(scale.note(VII), scale.note(VI), scale.note(IV), scale.note(II)))
                )
            )
        )

        assertThat(MelodicLineDiatonicEnclosureApproach(scale.pivotChords()), equalTo(expected))
    }
}
