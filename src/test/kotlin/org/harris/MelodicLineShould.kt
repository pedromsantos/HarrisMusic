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
    private val b = Note(B)
    private val db = Note(DFlat)
    private val eb = Note(EFlat)
    private val e = Note(E)
    private val gb = Note(GFlat)
    private val ab = Note(AFlat)
    private val bb = Note(BFlat)
    private val scale = Scale(Ionian, C)

    @Test
    fun `Generate thirds melodic line for C Ionian with half tone approach from bellow`() {
        val expected = MelodicLine(
            listOf(
                MelodicFragment(listOf(b, scale.note(I), scale.note(III))),
                MelodicFragment(listOf(db, scale.note(II), scale.note(IV))),
                MelodicFragment(listOf(eb, scale.note(III), scale.note(V))),
                MelodicFragment(listOf(e, scale.note(IV), scale.note(VI))),
                MelodicFragment(listOf(gb, scale.note(V), scale.note(VII))),
                MelodicFragment(listOf(ab, scale.note(VI), scale.note(I))),
                MelodicFragment(listOf(bb, scale.note(VII), scale.note(II)))))

        assertThat(scale.thirds().hallToneApproachBellowToFragments(), equalTo(expected))
    }

    @Test
    fun `Generate triads melodic line for C Ionian with half tone approach from bellow`() {
        val expected = MelodicLine(
            listOf(
                MelodicFragment(listOf(b, scale.note(I), scale.note(III), scale.note(V))),
                MelodicFragment(listOf(db, scale.note(II), scale.note(IV), scale.note(VI))),
                MelodicFragment(listOf(eb, scale.note(III), scale.note(V), scale.note(VII))),
                MelodicFragment(listOf(e, scale.note(IV), scale.note(VI), scale.note(I))),
                MelodicFragment(listOf(gb, scale.note(V), scale.note(VII), scale.note(II))),
                MelodicFragment(listOf(ab, scale.note(VI), scale.note(I), scale.note(III))),
                MelodicFragment(listOf(bb, scale.note(VII), scale.note(II), scale.note(IV)))))

        assertThat(scale.triads().hallToneApproachBellowToFragments(), equalTo(expected))
    }

    @Test
    fun `Generate chords melodic line for C Ionian with half tone approach from bellow`() {
        val expected = MelodicLine(
            listOf(
                MelodicFragment(listOf(b, scale.note(I), scale.note(III), scale.note(V), scale.note(VII))),
                MelodicFragment(listOf(db, scale.note(II), scale.note(IV), scale.note(VI), scale.note(I))),
                MelodicFragment(listOf(eb, scale.note(III), scale.note(V), scale.note(VII), scale.note(II))),
                MelodicFragment(listOf(e, scale.note(IV), scale.note(VI), scale.note(I), scale.note(III))),
                MelodicFragment(listOf(gb, scale.note(V), scale.note(VII), scale.note(II), scale.note(IV))),
                MelodicFragment(listOf(ab, scale.note(VI), scale.note(I), scale.note(III), scale.note(V))),
                MelodicFragment(listOf(bb, scale.note(VII), scale.note(II), scale.note(IV), scale.note(VI)))))

        assertThat(scale.chords().hallToneApproachBellowToFragments(), equalTo(expected))
    }

    @Test
    fun `Generate pivot chords melodic line for C Ionian with half tone approach from bellow`() {
        val expected = MelodicLine(
            listOf(
                MelodicFragment(listOf(b, scale.note(I), scale.note(VII), scale.note(V), scale.note(III))),
                MelodicFragment(listOf(db, scale.note(II), scale.note(I), scale.note(VI), scale.note(IV))),
                MelodicFragment(listOf(eb, scale.note(III), scale.note(II), scale.note(VII), scale.note(V))),
                MelodicFragment(listOf(e, scale.note(IV), scale.note(III), scale.note(I), scale.note(VI))),
                MelodicFragment(listOf(gb, scale.note(V), scale.note(IV), scale.note(II), scale.note(VII))),
                MelodicFragment(listOf(ab, scale.note(VI), scale.note(V), scale.note(III), scale.note(I))),
                MelodicFragment(listOf(bb, scale.note(VII), scale.note(VI), scale.note(IV), scale.note(II)))))

        assertThat(scale.pivotChords().hallToneApproachBellowToFragments(), equalTo(expected))
    }
}
