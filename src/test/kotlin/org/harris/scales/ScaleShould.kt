package org.harris.scales

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.harris.MelodicPhrase
import org.harris.MelodicLine
import org.harris.notes.Pitch.*
import org.harris.scales.ScaleDegree.*
import org.harris.scales.ScalePattern.*
import org.junit.Test

class ScaleShould {
    @Test
    fun `Generate correct pitches for C Ionian`() {
        val expected = listOf(C, D, E, F, G, A, B)
        assertThat(Scale(Ionian, C).pitches().toList(), equalTo(expected))
        assertThat(Ionian.createScale(C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct pitches for C Dorian`() {
        val expected = listOf(C, D, EFlat, F, G, A, BFlat)
        assertThat(Scale(Dorian, C).pitches().toList(), equalTo(expected))
        assertThat(Dorian.createScale(C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct pitches for C Phrygian`() {
        val expected = listOf(C, DFlat, EFlat, F, G, AFlat, BFlat)
        assertThat(Scale(Phrygian, C).pitches().toList(), equalTo(expected))
        assertThat(Phrygian.createScale(C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct pitches for C Lydian`() {
        val expected = listOf(C, D, E, FSharp, G, A, B)
        assertThat(Scale(Lydian, C).pitches().toList(), equalTo(expected))
        assertThat(Lydian.createScale(C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct pitches for C Mixolydian`() {
        val expected = listOf(C, D, E, F, G, A, BFlat)
        assertThat(Scale(Mixolydian, C).pitches().toList(), equalTo(expected))
        assertThat(Mixolydian.createScale(C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct pitches for C Aolian`() {
        val expected = listOf(C, D, EFlat, F, G, AFlat, BFlat)
        assertThat(Scale(Aolian, C).pitches().toList(), equalTo(expected))
        assertThat(Aolian.createScale(C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct pitches for C Locrian`() {
        val expected = listOf(C, DFlat, EFlat, F, GFlat, AFlat, BFlat)
        assertThat(Scale(Locrian, C).pitches().toList(), equalTo(expected))
        assertThat(Locrian.createScale(C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct pitches for C Major Pentatonic`() {
        val expected = listOf(C, D, E, G, A)
        assertThat(Scale(MajorPentatonic, C).pitches().toList(), equalTo(expected))
        assertThat(MajorPentatonic.createScale(C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct pitches for C Minor Pentatonic`() {
        val expected = listOf(C, EFlat, F, G, BFlat)
        assertThat(Scale(MinorPentatonic, C).pitches().toList(), equalTo(expected))
        assertThat(MinorPentatonic.createScale(C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct pitches for C Blues`() {
        val expected = listOf(C, EFlat, F, GFlat, G, BFlat)
        assertThat(Scale(Blues, C).pitches().toList(), equalTo(expected))
        assertThat(Blues.createScale(C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct pitches for C Harmonic minor`() {
        val expected = listOf(C, D, EFlat, F, G, AFlat, B)
        assertThat(Scale(HarmonicMinor, C).pitches().toList(), equalTo(expected))
        assertThat(HarmonicMinor.createScale(C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct pitches for C Melodic minor`() {
        val expected = listOf(C, D, EFlat, F, G, A, B)
        assertThat(Scale(MelodicMinor, C).pitches().toList(), equalTo(expected))
        assertThat(MelodicMinor.createScale(C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct pitches for C Dorian flat 2`() {
        val expected = listOf(C, DFlat, EFlat, F, G, A, BFlat)
        assertThat(Scale(DorianFlat2, C).pitches().toList(), equalTo(expected))
        assertThat(DorianFlat2.createScale(C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct pitches for C Neapolitan minor`() {
        val expected = listOf(C, DFlat, EFlat, F, G, AFlat, B)
        assertThat(Scale(NeapolitanMinor, C).pitches().toList(), equalTo(expected))
        assertThat(NeapolitanMinor.createScale(C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct pitches for C Lydian augmented`() {
        val expected = listOf(C, D, E, FSharp, GSharp, A, B)
        assertThat(Scale(LydianAugmented, C).pitches().toList(), equalTo(expected))
        assertThat(LydianAugmented.createScale(C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct pitches for C Lydian dominant`() {
        val expected = listOf(C, D, E, FSharp, G, A, BFlat)
        assertThat(Scale(LydianDominant, C).pitches().toList(), equalTo(expected))
        assertThat(LydianDominant.createScale(C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct pitches for C Mixolydian flat 6`() {
        val expected = listOf(C, D, E, F, G, AFlat, BFlat)
        assertThat(Scale(MixolydianFlat6, C).pitches().toList(), equalTo(expected))
        assertThat(MixolydianFlat6.createScale(C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct pitches for C Locrian sharp 2`() {
        val expected = listOf(C, D, EFlat, F, GFlat, AFlat, BFlat)
        assertThat(Scale(LocrianSharp2, C).pitches().toList(), equalTo(expected))
        assertThat(LocrianSharp2.createScale(C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct pitches for C Altered dominant`() {
        val expected = listOf(C, DFlat, DSharp, E, GFlat, GSharp, BFlat)
        assertThat(Scale(AlteredDominant, C).pitches().toList(), equalTo(expected))
        assertThat(AlteredDominant.createScale(C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct pitches for C Half whole diminished`() {
        val expected = listOf(C, DFlat, EFlat, E, FSharp, G, A, BFlat)
        assertThat(Scale(HalfWholeDiminished, C).pitches().toList(), equalTo(expected))
        assertThat(HalfWholeDiminished.createScale(C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct pitches for C Whole tone`() {
        val expected = listOf(C, D, E, GFlat, GSharp, BFlat)
        assertThat(Scale(WholeTone, C).pitches().toList(), equalTo(expected))
        assertThat(WholeTone.createScale(C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct pitches for C Major sixth diminished`() {
        val expected = listOf(C, D, E, F, G, AFlat, A, B)
        assertThat(Scale(MajorSixthDiminished, C).pitches().toList(), equalTo(expected))
        assertThat(MajorSixthDiminished.createScale(C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct pitches for C Minor sixth diminished`() {
        val expected = listOf(C, D, EFlat, F, G, AFlat, A, B)
        assertThat(Scale(MinorSixthDiminished, C).pitches().toList(), equalTo(expected))
        assertThat(MinorSixthDiminished.createScale(C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct pitches for C Dominant sixth diminished`() {
        val expected = listOf(C, D, E, F, G, AFlat, BFlat, B)
        assertThat(Scale(DominantDiminished, C).pitches().toList(), equalTo(expected))
        assertThat(DominantDiminished.createScale(C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct pitches for C Dominant flat 5 sixth diminished`() {
        val expected = listOf(C, D, E, F, GFlat, AFlat, BFlat, B)
        assertThat(Scale(DominantFlat5Diminished, C).pitches().toList(), equalTo(expected))
        assertThat(DominantFlat5Diminished.createScale(C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct pitches for C Bebop`() {
        val expected = listOf(C, D, E, F, G, A, BFlat, B)
        assertThat(Scale(Bebop, C).pitches().toList(), equalTo(expected))
        assertThat(Bebop.createScale(C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun `Generate correct pitches for Chromatic scale`() {
        val expected = listOf(C, CSharp, D, DSharp, E, F, FSharp, G, GSharp, A, BFlat, B)
        assertThat(Scale(Chromatic, C).pitches().toList(), equalTo(expected))
        assertThat(Chromatic.createScale(C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun `Generate thirds for C Ionian starting on first degree`() {
        val expected = listOf(C, E, G, B, D, F, A)
        assertThat(Ionian.createScale(C).thirdsFrom(I).toList(), equalTo(expected))
    }

    @Test
    fun `Generate thirds for C Ionian starting on second degree`() {
        val expected = listOf(D, F, A, C, E, G, B)
        assertThat(Ionian.createScale(C).thirdsFrom(II).toList(), equalTo(expected))
    }

    @Test
    fun `Generate thirds for C Ionian starting on third degree`() {
        val expected = listOf(E, G, B, D, F, A, C)
        assertThat(Ionian.createScale(C).thirdsFrom(III).toList(), equalTo(expected))
    }

    @Test
    fun `Generate thirds for C Ionian starting on fourth degree`() {
        val expected = listOf(F, A, C, E, G, B, D)
        assertThat(Ionian.createScale(C).thirdsFrom(IV).toList(), equalTo(expected))
    }

    @Test
    fun `Generate thirds for C Ionian starting on fifth degree`() {
        val expected = listOf(G, B, D, F, A, C, E)
        assertThat(Ionian.createScale(C).thirdsFrom(V).toList(), equalTo(expected))
    }

    @Test
    fun `Generate thirds for C Ionian starting on sixth degree`() {
        val expected = listOf(A, C, E, G, B, D, F)
        assertThat(Ionian.createScale(C).thirdsFrom(VI).toList(), equalTo(expected))
    }

    @Test
    fun `Generate thirds for C Ionian starting on seventh degree`() {
        val expected = listOf(B, D, F, A, C, E, G)
        assertThat(Ionian.createScale(C).thirdsFrom(VII).toList(), equalTo(expected))
    }

    @Test
    fun `Generate thirds melodic line for C Ionian`() {
        val scale = Scale(Ionian, C)

        val expected = MelodicLine(
            listOf(
                MelodicPhrase(listOf(scale.note(I), scale.note(III))),
                MelodicPhrase(listOf(scale.note(II), scale.note(IV))),
                MelodicPhrase(listOf(scale.note(III), scale.note(V))),
                MelodicPhrase(listOf(scale.note(IV), scale.note(VI))),
                MelodicPhrase(listOf(scale.note(V), scale.note(VII))),
                MelodicPhrase(listOf(scale.note(VI), scale.note(I))),
                MelodicPhrase(listOf(scale.note(VII), scale.note(II)))
            ))

        assertThat(scale.thirds(), equalTo(expected))
    }

    @Test
    fun `Generate triads melodic line for C Ionian`() {
        val scale = Scale(Ionian, C)

        val expected = MelodicLine(
            listOf(
                MelodicPhrase(listOf(scale.note(I), scale.note(III), scale.note(V))),
                MelodicPhrase(listOf(scale.note(II), scale.note(IV), scale.note(VI))),
                MelodicPhrase(listOf(scale.note(III), scale.note(V), scale.note(VII))),
                MelodicPhrase(listOf(scale.note(IV), scale.note(VI), scale.note(I))),
                MelodicPhrase(listOf(scale.note(V), scale.note(VII), scale.note(II))),
                MelodicPhrase(listOf(scale.note(VI), scale.note(I), scale.note(III))),
                MelodicPhrase(listOf(scale.note(VII), scale.note(II), scale.note(IV)))
            ))

        assertThat(scale.triads(), equalTo(expected))
    }

    @Test
    fun `Generate chords melodic line for C Ionian`() {
        val scale = Scale(Ionian, C)

        val expected = MelodicLine(
            listOf(
                MelodicPhrase(listOf(scale.note(I), scale.note(III), scale.note(V), scale.note(VII))),
                MelodicPhrase(listOf(scale.note(II), scale.note(IV), scale.note(VI), scale.note(I))),
                MelodicPhrase(listOf(scale.note(III), scale.note(V), scale.note(VII), scale.note(II))),
                MelodicPhrase(listOf(scale.note(IV), scale.note(VI), scale.note(I), scale.note(III))),
                MelodicPhrase(listOf(scale.note(V), scale.note(VII), scale.note(II), scale.note(IV))),
                MelodicPhrase(listOf(scale.note(VI), scale.note(I), scale.note(III), scale.note(V))),
                MelodicPhrase(listOf(scale.note(VII), scale.note(II), scale.note(IV), scale.note(VI)))
            ))

        assertThat(scale.chords(), equalTo(expected))
    }

    @Test
    fun `Generate pivot chords melodic line for C Ionian`() {
        val scale = Scale(Ionian, C)

        val expected = MelodicLine(
            listOf(
                MelodicPhrase(listOf(scale.note(I), scale.note(VII), scale.note(V), scale.note(III))),
                MelodicPhrase(listOf(scale.note(II), scale.note(I), scale.note(VI), scale.note(IV))),
                MelodicPhrase(listOf(scale.note(III), scale.note(II), scale.note(VII), scale.note(V))),
                MelodicPhrase(listOf(scale.note(IV), scale.note(III), scale.note(I), scale.note(VI))),
                MelodicPhrase(listOf(scale.note(V), scale.note(IV), scale.note(II), scale.note(VII))),
                MelodicPhrase(listOf(scale.note(VI), scale.note(V), scale.note(III), scale.note(I))),
                MelodicPhrase(listOf(scale.note(VII), scale.note(VI), scale.note(IV), scale.note(II)))
            ))

        assertThat(scale.pivotChords(), equalTo(expected))
    }
}
