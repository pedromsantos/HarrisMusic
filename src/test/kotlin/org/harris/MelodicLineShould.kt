package org.harris

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.harris.Pitch.*
import org.harris.ScaleDegree.*
import org.harris.ScalePattern.*
import org.junit.Test

class MelodicLineShould {
    private val b = Note.chromaticNote(B)
    private val db = Note.chromaticNote(DFlat)
    private val eb = Note.chromaticNote(EFlat)
    private val e = Note.chromaticNote(E)
    private val gb = Note.chromaticNote(GFlat)
    private val ab = Note.chromaticNote(AFlat)
    private val bb = Note.chromaticNote(BFlat)

    @Test
    fun `Generate thirds melodic line for C Ionian with half tone approach from bellow`() {
        val scale = Scale(Ionian, C)

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
        val scale = Scale(Ionian, C)

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
        val scale = Scale(Ionian, C)

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
        val scale = Scale(Ionian, C)

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
