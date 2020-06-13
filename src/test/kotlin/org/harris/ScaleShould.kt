package org.harris

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.harris.Note.*
import org.harris.ScalePattern.*
import org.junit.Test

class ScaleShould {
    @Test
    fun `Generate correct notes for C Ionian`() {
        val expected = listOf(C, D, E, F, G, A, B)
        assertThat(Scale(Ionian, C).notes().toList(), equalTo(expected))
        assertThat(Ionian.createScale(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Dorian`() {
        val expected = listOf(C, D, EFlat, F, G, A, BFlat)
        assertThat(Scale(Dorian, C).notes().toList(), equalTo(expected))
        assertThat(Dorian.createScale(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Phrygian`() {
        val expected = listOf(C, DFlat, EFlat, F, G, AFlat, BFlat)
        assertThat(Scale(Phrygian, C).notes().toList(), equalTo(expected))
        assertThat(Phrygian.createScale(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Lydian`() {
        val expected = listOf(C, D, E, FSharp, G, A, B)
        assertThat(Scale(Lydian, C).notes().toList(), equalTo(expected))
        assertThat(Lydian.createScale(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Mixolydian`() {
        val expected = listOf(C, D, E, F, G, A, BFlat)
        assertThat(Scale(Mixolydian, C).notes().toList(), equalTo(expected))
        assertThat(Mixolydian.createScale(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Aolian`() {
        val expected = listOf(C, D, EFlat, F, G, AFlat, BFlat)
        assertThat(Scale(Aolian, C).notes().toList(), equalTo(expected))
        assertThat(Aolian.createScale(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Locrian`() {
        val expected = listOf(C, DFlat, EFlat, F, GFlat, AFlat, BFlat)
        assertThat(Scale(Locrian, C).notes().toList(), equalTo(expected))
        assertThat(Locrian.createScale(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Major Pentatonic`() {
        val expected = listOf(C, D, E, G, A)
        assertThat(Scale(MajorPentatonic, C).notes().toList(), equalTo(expected))
        assertThat(MajorPentatonic.createScale(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Minor Pentatonic`() {
        val expected = listOf(C, EFlat, F, G, BFlat)
        assertThat(Scale(MinorPentatonic, C).notes().toList(), equalTo(expected))
        assertThat(MinorPentatonic.createScale(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Blues`() {
        val expected = listOf(C, EFlat, F, GFlat, G, BFlat)
        assertThat(Scale(Blues, C).notes().toList(), equalTo(expected))
        assertThat(Blues.createScale(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Harmonic minor`() {
        val expected = listOf(C, D, EFlat, F, G, AFlat, B)
        assertThat(Scale(HarmonicMinor, C).notes().toList(), equalTo(expected))
        assertThat(HarmonicMinor.createScale(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Melodic minor`() {
        val expected = listOf(C, D, EFlat, F, G, A, B)
        assertThat(Scale(MelodicMinor, C).notes().toList(), equalTo(expected))
        assertThat(MelodicMinor.createScale(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Dorian flat 2`() {
        val expected = listOf(C, DFlat, EFlat, F, G, A, BFlat)
        assertThat(Scale(DorianFlat2, C).notes().toList(), equalTo(expected))
        assertThat(DorianFlat2.createScale(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Neapolitan minor`() {
        val expected = listOf(C, DFlat, EFlat, F, G, AFlat, B)
        assertThat(Scale(NeapolitanMinor, C).notes().toList(), equalTo(expected))
        assertThat(NeapolitanMinor.createScale(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Lydian augmented`() {
        val expected = listOf(C, D, E, FSharp, GSharp, A, B)
        assertThat(Scale(LydianAugmented, C).notes().toList(), equalTo(expected))
        assertThat(LydianAugmented.createScale(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Lydian dominant`() {
        val expected = listOf(C, D, E, FSharp, G, A, BFlat)
        assertThat(Scale(LydianDominant, C).notes().toList(), equalTo(expected))
        assertThat(LydianDominant.createScale(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Mixolydian flat 6`() {
        val expected = listOf(C, D, E, F, G, AFlat, BFlat)
        assertThat(Scale(MixolydianFlat6, C).notes().toList(), equalTo(expected))
        assertThat(MixolydianFlat6.createScale(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Locrian sharp 2`() {
        val expected = listOf(C, D, EFlat, F, GFlat, AFlat, BFlat)
        assertThat(Scale(LocrianSharp2, C).notes().toList(), equalTo(expected))
        assertThat(LocrianSharp2.createScale(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Altered dominant`() {
        val expected = listOf(C, DFlat, DSharp, E, GFlat, GSharp, BFlat)
        assertThat(Scale(AlteredDominant, C).notes().toList(), equalTo(expected))
        assertThat(AlteredDominant.createScale(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Half whole diminished`() {
        val expected = listOf(C, DFlat, EFlat, E, FSharp, G, A, BFlat)
        assertThat(Scale(HalfWholeDiminished, C).notes().toList(), equalTo(expected))
        assertThat(HalfWholeDiminished.createScale(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Whole tone`() {
        val expected = listOf(C, D, E, GFlat, GSharp, BFlat)
        assertThat(Scale(WholeTone, C).notes().toList(), equalTo(expected))
        assertThat(WholeTone.createScale(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Major sixth diminished`() {
        val expected = listOf(C, D, E, F, G, AFlat, A, B)
        assertThat(Scale(MajorSixthDiminished, C).notes().toList(), equalTo(expected))
        assertThat(MajorSixthDiminished.createScale(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Minor sixth diminished`() {
        val expected = listOf(C, D, EFlat, F, G, AFlat, A, B)
        assertThat(Scale(MinorSixthDiminished, C).notes().toList(), equalTo(expected))
        assertThat(MinorSixthDiminished.createScale(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Dominant sixth diminished`() {
        val expected = listOf(C, D, E, F, G, AFlat, BFlat, B)
        assertThat(Scale(DominantDiminished, C).notes().toList(), equalTo(expected))
        assertThat(DominantDiminished.createScale(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Dominant flat 5 sixth diminished`() {
        val expected = listOf(C, D, E, F, GFlat, AFlat, BFlat, B)
        assertThat(Scale(DominantFlat5Diminished, C).notes().toList(), equalTo(expected))
        assertThat(DominantFlat5Diminished.createScale(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Bebop`() {
        val expected = listOf(C, D, E, F, G, A, BFlat, B)
        assertThat(Scale(Bebop, C).notes().toList(), equalTo(expected))
        assertThat(Bebop.createScale(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `Generate thirds for C Ionian starting on first degree`() {
        val expected = listOf(C, E, G, B, D, F, A)
        assertThat(Ionian.createScale(C).thirdsFrom(ScaleDegree.I).toList(), equalTo(expected))
    }

    @Test
    fun `Generate thirds for C Ionian starting on second degree`() {
        val expected = listOf(D, F, A, C, E, G, B)
        assertThat(Ionian.createScale(C).thirdsFrom(ScaleDegree.II).toList(), equalTo(expected))
    }

    @Test
    fun `Generate thirds for C Ionian starting on third degree`() {
        val expected = listOf(E, G, B, D, F, A, C)
        assertThat(Ionian.createScale(C).thirdsFrom(ScaleDegree.III).toList(), equalTo(expected))
    }

    @Test
    fun `Generate thirds for C Ionian starting on fourth degree`() {
        val expected = listOf(F, A, C, E, G, B, D)
        assertThat(Ionian.createScale(C).thirdsFrom(ScaleDegree.IV).toList(), equalTo(expected))
    }

    @Test
    fun `Generate thirds for C Ionian starting on fifth degree`() {
        val expected = listOf(G, B, D, F, A, C, E)
        assertThat(Ionian.createScale(C).thirdsFrom(ScaleDegree.V).toList(), equalTo(expected))
    }

    @Test
    fun `Generate thirds for C Ionian starting on sixth degree`() {
        val expected = listOf(A, C, E, G, B, D, F)
        assertThat(Ionian.createScale(C).thirdsFrom(ScaleDegree.VI).toList(), equalTo(expected))
    }

    @Test
    fun `Generate thirds for C Ionian starting on seventh degree`() {
        val expected = listOf(B, D, F, A, C, E, G)
        assertThat(Ionian.createScale(C).thirdsFrom(ScaleDegree.VII).toList(), equalTo(expected))
    }
}
