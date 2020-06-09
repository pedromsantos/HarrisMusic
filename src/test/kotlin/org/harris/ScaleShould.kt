package org.harris

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.harris.Note.*
import org.harris.ScalePattern.*
import org.junit.Test

class ScaleShould {
    @Test
    fun `Generate correct notes for C Ionian`() {
        val expected = setOf(C, D, E, F, G, A, B)
        assertThat(Scale(Ionian, C).notes().toSet(), equalTo(expected))
        assertThat(Ionian.createScale(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Dorian`() {
        val expected = setOf(C, D, EFlat, F, G, A, BFlat)
        assertThat(Scale(Dorian, C).notes().toSet(), equalTo(expected))
        assertThat(Dorian.createScale(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Phrygian`() {
        val expected = setOf(C, DFlat, EFlat, F, G, AFlat, BFlat)
        assertThat(Scale(Phrygian, C).notes().toSet(), equalTo(expected))
        assertThat(Phrygian.createScale(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Lydian`() {
        val expected = setOf(C, D, E, FSharp, G, A, B)
        assertThat(Scale(Lydian, C).notes().toSet(), equalTo(expected))
        assertThat(Lydian.createScale(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Mixolydian`() {
        val expected = setOf(C, D, E, F, G, A, BFlat)
        assertThat(Scale(Mixolydian, C).notes().toSet(), equalTo(expected))
        assertThat(Mixolydian.createScale(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Aolian`() {
        val expected = setOf(C, D, EFlat, F, G, AFlat, BFlat)
        assertThat(Scale(Aolian, C).notes().toSet(), equalTo(expected))
        assertThat(Aolian.createScale(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Locrian`() {
        val expected = setOf(C, DFlat, EFlat, F, GFlat, AFlat, BFlat)
        assertThat(Scale(Locrian, C).notes().toSet(), equalTo(expected))
        assertThat(Locrian.createScale(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Major Pentatonic`() {
        val expected = setOf(C, D, E, G, A)
        assertThat(Scale(MajorPentatonic, C).notes().toSet(), equalTo(expected))
        assertThat(MajorPentatonic.createScale(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Minor Pentatonic`() {
        val expected = setOf(C, EFlat, F, G, BFlat)
        assertThat(Scale(MinorPentatonic, C).notes().toSet(), equalTo(expected))
        assertThat(MinorPentatonic.createScale(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Blues`() {
        val expected = setOf(C, EFlat, F, GFlat, G, BFlat)
        assertThat(Scale(Blues, C).notes().toSet(), equalTo(expected))
        assertThat(Blues.createScale(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Harmonic minor`() {
        val expected = setOf(C, D, EFlat, F, G, AFlat, B)
        assertThat(Scale(HarmonicMinor, C).notes().toSet(), equalTo(expected))
        assertThat(HarmonicMinor.createScale(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Melodic minor`() {
        val expected = setOf(C, D, EFlat, F, G, A, B)
        assertThat(Scale(MelodicMinor, C).notes().toSet(), equalTo(expected))
        assertThat(MelodicMinor.createScale(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Dorian flat 2`() {
        val expected = setOf(C, DFlat, EFlat, F, G, A, BFlat)
        assertThat(Scale(DorianFlat2, C).notes().toSet(), equalTo(expected))
        assertThat(DorianFlat2.createScale(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Neapolitan minor`() {
        val expected = setOf(C, DFlat, EFlat, F, G, AFlat, B)
        assertThat(Scale(NeapolitanMinor, C).notes().toSet(), equalTo(expected))
        assertThat(NeapolitanMinor.createScale(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Lydian augmented`() {
        val expected = setOf(C, D, E, FSharp, GSharp, A, B)
        assertThat(Scale(LydianAugmented, C).notes().toSet(), equalTo(expected))
        assertThat(LydianAugmented.createScale(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Lydian dominant`() {
        val expected = setOf(C, D, E, FSharp, G, A, BFlat)
        assertThat(Scale(LydianDominant, C).notes().toSet(), equalTo(expected))
        assertThat(LydianDominant.createScale(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Mixolydian flat 6`() {
        val expected = setOf(C, D, E, F, G, AFlat, BFlat)
        assertThat(Scale(MixolydianFlat6, C).notes().toSet(), equalTo(expected))
        assertThat(MixolydianFlat6.createScale(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Locrian sharp 2`() {
        val expected = setOf(C, D, EFlat, F, GFlat, AFlat, BFlat)
        assertThat(Scale(LocrianSharp2, C).notes().toSet(), equalTo(expected))
        assertThat(LocrianSharp2.createScale(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Altered dominant`() {
        val expected = setOf(C, DFlat, DSharp, E, GFlat, GSharp, BFlat)
        assertThat(Scale(AlteredDominant, C).notes().toSet(), equalTo(expected))
        assertThat(AlteredDominant.createScale(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Half whole diminished`() {
        val expected = setOf(C, DFlat, EFlat, E, FSharp, G, A, BFlat)
        assertThat(Scale(HalfWholeDiminished, C).notes().toSet(), equalTo(expected))
        assertThat(HalfWholeDiminished.createScale(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Whole tone`() {
        val expected = setOf(C, D, E, GFlat, GSharp, BFlat)
        assertThat(Scale(WholeTone, C).notes().toSet(), equalTo(expected))
        assertThat(WholeTone.createScale(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Major sixth diminished`() {
        val expected = setOf(C, D, E, F, G, AFlat, A, B)
        assertThat(Scale(MajorSixthDiminished, C).notes().toSet(), equalTo(expected))
        assertThat(MajorSixthDiminished.createScale(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Minor sixth diminished`() {
        val expected = setOf(C, D, EFlat, F, G, AFlat, A, B)
        assertThat(Scale(MinorSixthDiminished, C).notes().toSet(), equalTo(expected))
        assertThat(MinorSixthDiminished.createScale(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Dominant sixth diminished`() {
        val expected = setOf(C, D, E, F, G, AFlat, BFlat, B)
        assertThat(Scale(DominantDiminished, C).notes().toSet(), equalTo(expected))
        assertThat(DominantDiminished.createScale(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Dominant flat 5 sixth diminished`() {
        val expected = setOf(C, D, E, F, GFlat, AFlat, BFlat, B)
        assertThat(Scale(DominantFlat5Diminished, C).notes().toSet(), equalTo(expected))
        assertThat(DominantFlat5Diminished.createScale(C).notes().toSet(), equalTo(expected))
    }
}