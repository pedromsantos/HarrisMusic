package org.harris.chords

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.harris.notes.Pitch
import org.junit.Test

class ChordShouldHaveCorrectNotesFor {
    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.E, Pitch.G)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Major).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Major.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.E, Pitch.G, Pitch.A)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Major6).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Major6.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.E, Pitch.G, Pitch.A, Pitch.D)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Major6Add9).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Major6Add9.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.E, Pitch.G, Pitch.B)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Major7).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Major7.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.E, Pitch.G, Pitch.B, Pitch.D)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Major9).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Major9.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.E, Pitch.G, Pitch.B, Pitch.F)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Major11).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Major11.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.E, Pitch.G, Pitch.B, Pitch.A)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Major13).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Major13.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.E, Pitch.G, Pitch.B, Pitch.FSharp, Pitch.A)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Major13Sharp11).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Major13Sharp11.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.E, Pitch.G, Pitch.B, Pitch.D, Pitch.FSharp)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Major9Sharp11).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Major9Sharp11.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.E, Pitch.GFlat, Pitch.A, Pitch.D)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Major6Flat5Add9).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Major6Flat5Add9.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.E, Pitch.G, Pitch.BFlat)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Dominant7).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Dominant7.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.E, Pitch.GSharp, Pitch.B)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Augmented7).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Augmented7.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.E, Pitch.GFlat, Pitch.BFlat)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Dominant7Flat5).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Dominant7Flat5.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.E, Pitch.G, Pitch.BFlat, Pitch.D)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Dominant9).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Dominant9.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.E, Pitch.G, Pitch.BFlat, Pitch.DFlat)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Dominant7Flat9).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Dominant7Flat9.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.E, Pitch.GFlat, Pitch.BFlat, Pitch.DFlat)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Dominant7Flat5Flat9).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Dominant7Flat5Flat9.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.E, Pitch.GFlat, Pitch.BFlat, Pitch.DSharp)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Dominant7Flat5Sharp9).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Dominant7Flat5Sharp9.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.E, Pitch.G, Pitch.BFlat, Pitch.D, Pitch.F)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Dominant11).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Dominant11.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.E, Pitch.G, Pitch.BFlat, Pitch.D, Pitch.F, Pitch.A)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Dominant13).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Dominant13.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.E, Pitch.G, Pitch.BFlat, Pitch.DSharp)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Dominant7Sharp9).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Dominant7Sharp9.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.E, Pitch.G, Pitch.B, Pitch.D, Pitch.FSharp)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Major9Sharp11).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Major9Sharp11.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.E, Pitch.GSharp)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Augmented).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Augmented.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.EFlat, Pitch.G)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Minor).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Minor.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.EFlat, Pitch.G, Pitch.A)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Minor6).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Minor6.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.EFlat, Pitch.G, Pitch.A, Pitch.D)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Minor6Add9).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Minor6Add9.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.EFlat, Pitch.G, Pitch.BFlat)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Minor7).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Minor7.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.EFlat, Pitch.G, Pitch.B)
        assertThat(ClosedChord(Pitch.C, ChordPattern.MinorMaj7).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.MinorMaj7.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.EFlat, Pitch.G, Pitch.B, Pitch.D)
        assertThat(ClosedChord(Pitch.C, ChordPattern.MinorMaj9).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.MinorMaj9.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.EFlat, Pitch.GFlat, Pitch.BFlat)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Minor7b5).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Minor7b5.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.EFlat, Pitch.G, Pitch.BFlat, Pitch.D)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Minor9).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Minor9.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.EFlat, Pitch.GFlat)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Diminished).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Diminished.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.EFlat, Pitch.GFlat, Pitch.A)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Diminished7).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Diminished7.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.D, Pitch.G)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Sus2).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Sus2.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.D, Pitch.GFlat)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Sus2Diminished).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Sus2Diminished.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.D, Pitch.GSharp)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Sus2Augmented).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Sus2Augmented.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.F, Pitch.G)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Sus4).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Sus4.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.F, Pitch.GFlat)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Sus4Diminished).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Sus4Diminished.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }

    @Test
    fun () {
        val expected = listOf(Pitch.C, Pitch.F, Pitch.GSharp)
        assertThat(ClosedChord(Pitch.C, ChordPattern.Sus4Augmented).pitches().toList(), equalTo(expected))
        assertThat(ChordPattern.Sus4Augmented.createChord(Pitch.C).pitches().toList(), equalTo(expected))
    }
}
