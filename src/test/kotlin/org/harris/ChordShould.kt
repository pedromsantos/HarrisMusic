package org.harris

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.startsWith
import org.harris.ChordNoteFunction.*
import org.harris.Note.*
import org.harris.ChordPattern.*
import org.junit.Test

class ChordShould {
    @Test
    fun `Return bass note`() {
        assertThat(ClosedChord(C, Major).bass(), equalTo(C))
    }

    @Test
    fun `Return lead note`() {
        assertThat(ClosedChord(C, Major).lead(), equalTo(G))
    }

    @Test
    fun `be named after the root note`() {
        assertThat(ClosedChord(C, Major).name(), startsWith("C"))
    }

    @Test
    fun `be named after the root note and the quality`() {
        assertThat(ClosedChord(C, Major).name(), equalTo("CMajor"))
    }

    @Test
    fun `return note for function root`() {
        assertThat(ClosedChord(C, Major).noteForFunction(Root), equalTo(C))
    }

    @Test
    fun `return note for function third`() {
        assertThat(ClosedChord(C, Major).noteForFunction(Third), equalTo(E))
    }

    @Test
    fun `return note for function fifth`() {
        assertThat(ClosedChord(C, Major).noteForFunction(Fifth), equalTo(G))
    }

    @Test
    fun `remove function from chord`() {
        assertThat(
            ClosedChord(C, Major)
                .remove(Fifth)
                .notes().toList(),
            equalTo(listOf(C, E)))
    }

    @Test
    fun `invert chord to first inversion`() {
        assertThat(
            ClosedChord(C, Major)
                .invert()
                .notes().toList(),
            equalTo(listOf(E, G, C)))
    }

    @Test
    fun `invert chord to second inversion`() {
        assertThat(
            ClosedChord(C, Major)
                .invert()
                .invert()
                .notes().toList(),
            equalTo(listOf(G, C, E)))
    }

    @Test
    fun `return a triad to root inversion when performing third inversion`() {
        assertThat(
            ClosedChord(C, Major)
                .invert()
                .invert()
                .invert()
                .notes().toList(),
            equalTo(listOf(C, E, G)))
    }

    @Test
    fun `invert chord to third inversion`() {
        assertThat(
            ClosedChord(C, Major7)
                .invert()
                .invert()
                .invert()
                .notes().toList(),
            equalTo(listOf(B, C, E, G)))
    }

    @Test
    fun `create drop 2 chord`() {
        assertThat(
            ClosedChord(C, Major7)
                .drop2()
                .notes().toList(),
            equalTo(listOf(C, G, B, E)))
    }

    @Test
    fun `create closed chord from drop 2 chord`() {
        assertThat(
            ClosedChord(C, Major7)
                .drop2()
                .closed()
                .notes().toList(),
            equalTo(listOf(C, E, G, B)))
    }

    @Test
    fun `create drop 2 first inversion`() {
        assertThat(
            ClosedChord(C, Major7)
                .drop2()
                .invert()
                .notes().toList(),
            equalTo(listOf(E, B, C, G)))
    }

    @Test
    fun `create drop 2 second inversion`() {
        assertThat(
            ClosedChord(C, Major7)
                .drop2()
                .invert()
                .invert()
                .notes().toList(),
            equalTo(listOf(G, C, E, B)))
    }

    @Test
    fun `create drop 2 third inversion`() {
        assertThat(
            ClosedChord(C, Major7)
                .drop2()
                .invert()
                .invert()
                .invert()
                .notes().toList(),
            equalTo(listOf(B, E, G, C)))
    }

    @Test
    fun `drop 2 fourth inversion goes back to root inversion`() {
        assertThat(
            ClosedChord(C, Major7)
                .drop2()
                .invert()
                .invert()
                .invert()
                .invert()
                .notes().toList(),
            equalTo(listOf(C, G, B, E)))
    }

    @Test
    fun `create drop 3 chord`() {
        assertThat(
            ClosedChord(C, Major7)
                .drop3()
                .notes().toList(),
            equalTo(listOf(C, B, E, G)))
    }

    @Test
    fun `create closed chord from drop 3 chord`() {
        assertThat(
            ClosedChord(C, Major7)
                .drop3()
                .closed()
                .notes().toList(),
            equalTo(listOf(C, E, G, B)))
    }

    @Test
    fun `create drop 3 first inversion`() {
        assertThat(
            ClosedChord(C, Major7)
                .drop3()
                .invert()
                .notes().toList(),
            equalTo(listOf(E, C, G, B)))
    }

    @Test
    fun `create drop 3 second inversion`() {
        assertThat(
            ClosedChord(C, Major7)
                .drop3()
                .invert()
                .invert()
                .notes().toList(),
            equalTo(listOf(G, E, B, C)))
    }

    @Test
    fun `create drop 3 third inversion`() {
        assertThat(
            ClosedChord(C, Major7)
                .drop3()
                .invert()
                .invert()
                .invert()
                .notes().toList(),
            equalTo(listOf(B, G, C, E)))
    }

    @Test
    fun `create drop 3 fourth inversion`() {
        assertThat(
            ClosedChord(C, Major7)
                .drop3()
                .invert()
                .invert()
                .invert()
                .invert()
                .notes().toList(),
            equalTo(listOf(C, B, E, G)))
    }
}

class ChordShouldCorrectNotesFor {
    @Test
    fun `C Major chord`() {
        val expected = listOf(C, E, G)
        assertThat(ClosedChord(C, Major).notes().toList(), equalTo(expected))
        assertThat(Major.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Major 6 chord`() {
        val expected = listOf(C, E, G, A)
        assertThat(ClosedChord(C, Major6).notes().toList(), equalTo(expected))
        assertThat(Major6.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Major 6 add 9 chord`() {
        val expected = listOf(C, E, G, A, D)
        assertThat(ClosedChord(C, Major6Add9).notes().toList(), equalTo(expected))
        assertThat(Major6Add9.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Major 7 chord`() {
        val expected = listOf(C, E, G, B)
        assertThat(ClosedChord(C, Major7).notes().toList(), equalTo(expected))
        assertThat(Major7.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Major 9 chord`() {
        val expected = listOf(C, E, G, B, D)
        assertThat(ClosedChord(C, Major9).notes().toList(), equalTo(expected))
        assertThat(Major9.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Major 11 chord`() {
        val expected = listOf(C, E, G, B, F)
        assertThat(ClosedChord(C, Major11).notes().toList(), equalTo(expected))
        assertThat(Major11.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Major 13 chord`() {
        val expected = listOf(C, E, G, B, A)
        assertThat(ClosedChord(C, Major13).notes().toList(), equalTo(expected))
        assertThat(Major13.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Major 13 sharp 11 chord`() {
        val expected = listOf(C, E, G, B, FSharp, A)
        assertThat(ClosedChord(C, Major13Sharp11).notes().toList(), equalTo(expected))
        assertThat(Major13Sharp11.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Major 9#11 chord`() {
        val expected = listOf(C, E, G, B, D, FSharp)
        assertThat(ClosedChord(C, Major9Sharp11).notes().toList(), equalTo(expected))
        assertThat(Major9Sharp11.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Major 6 flat 5 add 9 chord`() {
        val expected = listOf(C, E, GFlat, A, D)
        assertThat(ClosedChord(C, Major6Flat5Add9).notes().toList(), equalTo(expected))
        assertThat(Major6Flat5Add9.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Dominant 7 chord`() {
        val expected = listOf(C, E, G, BFlat)
        assertThat(ClosedChord(C, Dominant7).notes().toList(), equalTo(expected))
        assertThat(Dominant7.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Major augmented 7 chord`() {
        val expected = listOf(C, E, GSharp, B)
        assertThat(ClosedChord(C, Augmented7).notes().toList(), equalTo(expected))
        assertThat(Augmented7.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Dominant 7b5 chord`() {
        val expected = listOf(C, E, GFlat, BFlat)
        assertThat(ClosedChord(C, Dominant7Flat5).notes().toList(), equalTo(expected))
        assertThat(Dominant7Flat5.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Dominant 9 chord`() {
        val expected = listOf(C, E, G, BFlat, D)
        assertThat(ClosedChord(C, Dominant9).notes().toList(), equalTo(expected))
        assertThat(Dominant9.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Dominant 7b9 chord`() {
        val expected = listOf(C, E, G, BFlat, DFlat)
        assertThat(ClosedChord(C, Dominant7Flat9).notes().toList(), equalTo(expected))
        assertThat(Dominant7Flat9.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Dominant 7b5b9 chord`() {
        val expected = listOf(C, E, GFlat, BFlat, DFlat)
        assertThat(ClosedChord(C, Dominant7Flat5Flat9).notes().toList(), equalTo(expected))
        assertThat(Dominant7Flat5Flat9.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Dominant 7b5#9 chord`() {
        val expected = listOf(C, E, GFlat, BFlat, DSharp)
        assertThat(ClosedChord(C, Dominant7Flat5Sharp9).notes().toList(), equalTo(expected))
        assertThat(Dominant7Flat5Sharp9.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Dominant 11 chord`() {
        val expected = listOf(C, E, G, BFlat, D, F)
        assertThat(ClosedChord(C, Dominant11).notes().toList(), equalTo(expected))
        assertThat(Dominant11.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Dominant 13 chord`() {
        val expected = listOf(C, E, G, BFlat, D, F, A)
        assertThat(ClosedChord(C, Dominant13).notes().toList(), equalTo(expected))
        assertThat(Dominant13.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Dominant 7#9 chord`() {
        val expected = listOf(C, E, G, BFlat, DSharp)
        assertThat(ClosedChord(C, Dominant7Sharp9).notes().toList(), equalTo(expected))
        assertThat(Dominant7Sharp9.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Dominant 9#11 chord`() {
        val expected = listOf(C, E, G, B, D, FSharp)
        assertThat(ClosedChord(C, Major9Sharp11).notes().toList(), equalTo(expected))
        assertThat(Major9Sharp11.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Augmented chord`() {
        val expected = listOf(C, E, GSharp)
        assertThat(ClosedChord(C, Augmented).notes().toList(), equalTo(expected))
        assertThat(Augmented.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Minor chord`() {
        val expected = listOf(C, EFlat, G)
        assertThat(ClosedChord(C, Minor).notes().toList(), equalTo(expected))
        assertThat(Minor.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Minor 6 chord`() {
        val expected = listOf(C, EFlat, G, A)
        assertThat(ClosedChord(C, Minor6).notes().toList(), equalTo(expected))
        assertThat(Minor6.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Minor 6 add 9 chord`() {
        val expected = listOf(C, EFlat, G, A, D)
        assertThat(ClosedChord(C, Minor6Add9).notes().toList(), equalTo(expected))
        assertThat(Minor6Add9.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Minor 7 chord`() {
        val expected = listOf(C, EFlat, G, BFlat)
        assertThat(ClosedChord(C, Minor7).notes().toList(), equalTo(expected))
        assertThat(Minor7.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Minor Major 7 chord`() {
        val expected = listOf(C, EFlat, G, B)
        assertThat(ClosedChord(C, MinorMaj7).notes().toList(), equalTo(expected))
        assertThat(MinorMaj7.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Minor Major 9 chord`() {
        val expected = listOf(C, EFlat, G, B, D)
        assertThat(ClosedChord(C, MinorMaj9).notes().toList(), equalTo(expected))
        assertThat(MinorMaj9.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Minor 7b5 chord`() {
        val expected = listOf(C, EFlat, GFlat, BFlat)
        assertThat(ClosedChord(C, Minor7b5).notes().toList(), equalTo(expected))
        assertThat(Minor7b5.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Minor 9 chord`() {
        val expected = listOf(C, EFlat, G, BFlat, D)
        assertThat(ClosedChord(C, Minor9).notes().toList(), equalTo(expected))
        assertThat(Minor9.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Diminished chord`() {
        val expected = listOf(C, EFlat, GFlat)
        assertThat(ClosedChord(C, Diminished).notes().toList(), equalTo(expected))
        assertThat(Diminished.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Diminished 7 chord`() {
        val expected = listOf(C, EFlat, GFlat, A)
        assertThat(ClosedChord(C, Diminished7).notes().toList(), equalTo(expected))
        assertThat(Diminished7.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Sus2 chord`() {
        val expected = listOf(C, D, G)
        assertThat(ClosedChord(C, Sus2).notes().toList(), equalTo(expected))
        assertThat(Sus2.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Sus2 diminished chord`() {
        val expected = listOf(C, D, GFlat)
        assertThat(ClosedChord(C, Sus2Diminished).notes().toList(), equalTo(expected))
        assertThat(Sus2Diminished.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Sus2 augmented chord`() {
        val expected = listOf(C, D, GSharp)
        assertThat(ClosedChord(C, Sus2Augmented).notes().toList(), equalTo(expected))
        assertThat(Sus2Augmented.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Sus4 chord`() {
        val expected = listOf(C, F, G)
        assertThat(ClosedChord(C, Sus4).notes().toList(), equalTo(expected))
        assertThat(Sus4.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Sus4 diminished chord`() {
        val expected = listOf(C, F, GFlat)
        assertThat(ClosedChord(C, Sus4Diminished).notes().toList(), equalTo(expected))
        assertThat(Sus4Diminished.createChord(C).notes().toList(), equalTo(expected))
    }

    @Test
    fun `C Sus4 augmented chord`() {
        val expected = listOf(C, F, GSharp)
        assertThat(ClosedChord(C, Sus4Augmented).notes().toList(), equalTo(expected))
        assertThat(Sus4Augmented.createChord(C).notes().toList(), equalTo(expected))
    }
}