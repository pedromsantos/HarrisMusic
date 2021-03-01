package org.harris

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.harris.notes.Pitch.*
import org.harris.scales.ScaleDegree.*
import org.harris.scales.ScalePattern.*
import org.harris.notes.Note
import org.harris.scales.Scale
import org.junit.Test

class MelodicLineShould {
    private val scale = Scale(Ionian, C)
    private val b = Note(B)
    private val db = Note(DFlat)
    private val eb = Note(EFlat)
    private val e = Note(E)
    private val gb = Note(GFlat)
    private val ab = Note(AFlat)
    private val bb = Note(BFlat)

    @Test
    fun `Generate thirds melodic line for C Ionian with half tone approach from bellow`() {
        val expected = MelodicLineHalfToneApproach(MelodicLine(
            listOf(
                MelodicPhrase(listOf(scale.note(I), scale.note(III))),
                MelodicPhrase(listOf(scale.note(II), scale.note(IV))),
                MelodicPhrase(listOf(scale.note(III), scale.note(V))),
                MelodicPhrase(listOf(scale.note(IV), scale.note(VI))),
                MelodicPhrase(listOf(scale.note(V), scale.note(VII))),
                MelodicPhrase(listOf(scale.note(VI), scale.note(I))),
                MelodicPhrase(listOf(scale.note(VII), scale.note(II))))))

        assertThat(MelodicLineHalfToneApproach(scale.thirds()), equalTo(expected))
    }

    @Test
    fun `Generate triads melodic line for C Ionian with half tone approach from bellow`() {
        val expected = MelodicLineHalfToneApproach(MelodicLine(
            listOf(
                MelodicPhrase(listOf(scale.note(I), scale.note(III), scale.note(V))),
                MelodicPhrase(listOf(scale.note(II), scale.note(IV), scale.note(VI))),
                MelodicPhrase(listOf(scale.note(III), scale.note(V), scale.note(VII))),
                MelodicPhrase(listOf(scale.note(IV), scale.note(VI), scale.note(I))),
                MelodicPhrase(listOf(scale.note(V), scale.note(VII), scale.note(II))),
                MelodicPhrase(listOf(scale.note(VI), scale.note(I), scale.note(III))),
                MelodicPhrase(listOf(scale.note(VII), scale.note(II), scale.note(IV))))))

        assertThat(MelodicLineHalfToneApproach(scale.triads()), equalTo(expected))
    }

    @Test
    fun `Generate chords melodic line for C Ionian with half tone approach from bellow`() {
        val expected = MelodicLineHalfToneApproach(MelodicLine(
            listOf(
                MelodicPhrase(listOf(scale.note(I), scale.note(III), scale.note(V), scale.note(VII))),
                MelodicPhrase(listOf(scale.note(II), scale.note(IV), scale.note(VI), scale.note(I))),
                MelodicPhrase(listOf(scale.note(III), scale.note(V), scale.note(VII), scale.note(II))),
                MelodicPhrase(listOf(scale.note(IV), scale.note(VI), scale.note(I), scale.note(III))),
                MelodicPhrase(listOf(scale.note(V), scale.note(VII), scale.note(II), scale.note(IV))),
                MelodicPhrase(listOf(scale.note(VI), scale.note(I), scale.note(III), scale.note(V))),
                MelodicPhrase(listOf(scale.note(VII), scale.note(II), scale.note(IV), scale.note(VI))))))

        assertThat(MelodicLineHalfToneApproach(scale.chords()), equalTo(expected))
    }

    @Test
    fun `Generate pivot chords melodic line for C Ionian with half tone approach from bellow`() {
        val expected = MelodicLineHalfToneApproach(MelodicLine(
            listOf(
                MelodicPhrase(listOf(scale.note(I), scale.note(VII), scale.note(V), scale.note(III))),
                MelodicPhrase(listOf(scale.note(II), scale.note(I), scale.note(VI), scale.note(IV))),
                MelodicPhrase(listOf(scale.note(III), scale.note(II), scale.note(VII), scale.note(V))),
                MelodicPhrase(listOf(scale.note(IV), scale.note(III), scale.note(I), scale.note(VI))),
                MelodicPhrase(listOf(scale.note(V), scale.note(IV), scale.note(II), scale.note(VII))),
                MelodicPhrase(listOf(scale.note(VI), scale.note(V), scale.note(III), scale.note(I))),
                MelodicPhrase(listOf(scale.note(VII), scale.note(VI), scale.note(IV), scale.note(II))))))

        assertThat(MelodicLineHalfToneApproach(scale.pivotChords()), equalTo(expected))
    }
}
