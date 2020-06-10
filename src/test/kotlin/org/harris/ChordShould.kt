package org.harris

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.harris.Note.*
import org.harris.ChordPattern.*
import org.junit.Test

class ChordShould {
    @Test
    fun `Generate correct notes for C Major chord`() {
        val expected = setOf(C, E, G)
        assertThat(Chord(Major, C).notes().toSet(), equalTo(expected))
        assertThat(Major.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Major 6 chord`() {
        val expected = setOf(C, E, G, A)
        assertThat(Chord(Major6, C).notes().toSet(), equalTo(expected))
        assertThat(Major6.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Major 6 add 9 chord`() {
        val expected = setOf(C, E, G, A, D)
        assertThat(Chord(Major6Add9, C).notes().toSet(), equalTo(expected))
        assertThat(Major6Add9.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Major 7 chord`() {
        val expected = setOf(C, E, G, B)
        assertThat(Chord(Major7, C).notes().toSet(), equalTo(expected))
        assertThat(Major7.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Major 9 chord`() {
        val expected = setOf(C, E, G, B, D)
        assertThat(Chord(Major9, C).notes().toSet(), equalTo(expected))
        assertThat(Major9.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Major 11 chord`() {
        val expected = setOf(C, E, G, B, F)
        assertThat(Chord(Major11, C).notes().toSet(), equalTo(expected))
        assertThat(Major11.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Major 13 chord`() {
        val expected = setOf(C, E, G, B, A)
        assertThat(Chord(Major13, C).notes().toSet(), equalTo(expected))
        assertThat(Major13.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Major 13 sharp 11 chord`() {
        val expected = setOf(C, E, G, B, FSharp, A)
        assertThat(Chord(Major13Sharp11, C).notes().toSet(), equalTo(expected))
        assertThat(Major13Sharp11.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Major 9#11 chord`() {
        val expected = setOf(C, E, G, B, D, FSharp)
        assertThat(Chord(Major9Sharp11, C).notes().toSet(), equalTo(expected))
        assertThat(Major9Sharp11.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Major 6 flat 5 add 9 chord`() {
        val expected = setOf(C, E, GFlat, A, D)
        assertThat(Chord(Major6Flat5Add9, C).notes().toSet(), equalTo(expected))
        assertThat(Major6Flat5Add9.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Dominant 7 chord`() {
        val expected = setOf(C, E, G, BFlat)
        assertThat(Chord(Dominant7, C).notes().toSet(), equalTo(expected))
        assertThat(Dominant7.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Major augmented 7 chord`() {
        val expected = setOf(C, E, GSharp, B)
        assertThat(Chord(Augmented7, C).notes().toSet(), equalTo(expected))
        assertThat(Augmented7.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Dominant 7b5 chord`() {
        val expected = setOf(C, E, GFlat, BFlat)
        assertThat(Chord(Dominant7Flat5, C).notes().toSet(), equalTo(expected))
        assertThat(Dominant7Flat5.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Dominant 9 chord`() {
        val expected = setOf(C, E, G, BFlat, D)
        assertThat(Chord(Dominant9, C).notes().toSet(), equalTo(expected))
        assertThat(Dominant9.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Dominant 7b9 chord`() {
        val expected = setOf(C, E, G, BFlat, DFlat)
        assertThat(Chord(Dominant7Flat9, C).notes().toSet(), equalTo(expected))
        assertThat(Dominant7Flat9.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Dominant 7b5b9 chord`() {
        val expected = setOf(C, E, GFlat, BFlat, DFlat)
        assertThat(Chord(Dominant7Flat5Flat9, C).notes().toSet(), equalTo(expected))
        assertThat(Dominant7Flat5Flat9.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Dominant 7b5#9 chord`() {
        val expected = setOf(C, E, GFlat, BFlat, DSharp)
        assertThat(Chord(Dominant7Flat5Sharp9, C).notes().toSet(), equalTo(expected))
        assertThat(Dominant7Flat5Sharp9.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Dominant 11 chord`() {
        val expected = setOf(C, E, G, BFlat, D, F)
        assertThat(Chord(Dominant11, C).notes().toSet(), equalTo(expected))
        assertThat(Dominant11.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Dominant 13 chord`() {
        val expected = setOf(C, E, G, BFlat, D, F, A)
        assertThat(Chord(Dominant13, C).notes().toSet(), equalTo(expected))
        assertThat(Dominant13.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Dominant 7#9 chord`() {
        val expected = setOf(C, E, G, BFlat, DSharp)
        assertThat(Chord(Dominant7Sharp9, C).notes().toSet(), equalTo(expected))
        assertThat(Dominant7Sharp9.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Dominant 9#11 chord`() {
        val expected = setOf(C, E, G, B, D, FSharp)
        assertThat(Chord(Major9Sharp11, C).notes().toSet(), equalTo(expected))
        assertThat(Major9Sharp11.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Augmented chord`() {
        val expected = setOf(C, E, GSharp)
        assertThat(Chord(Augmented, C).notes().toSet(), equalTo(expected))
        assertThat(Augmented.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Minor chord`() {
        val expected = setOf(C, EFlat, G)
        assertThat(Chord(Minor, C).notes().toSet(), equalTo(expected))
        assertThat(Minor.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Minor 6 chord`() {
        val expected = setOf(C, EFlat, G, A)
        assertThat(Chord(Minor6, C).notes().toSet(), equalTo(expected))
        assertThat(Minor6.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Minor 6 add 9 chord`() {
        val expected = setOf(C, EFlat, G, A, D)
        assertThat(Chord(Minor6Add9, C).notes().toSet(), equalTo(expected))
        assertThat(Minor6Add9.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Minor 7 chord`() {
        val expected = setOf(C, EFlat, G, BFlat)
        assertThat(Chord(Minor7, C).notes().toSet(), equalTo(expected))
        assertThat(Minor7.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Minor Major 7 chord`() {
        val expected = setOf(C, EFlat, G, B)
        assertThat(Chord(MinorMaj7, C).notes().toSet(), equalTo(expected))
        assertThat(MinorMaj7.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Minor Major 9 chord`() {
        val expected = setOf(C, EFlat, G, B, D)
        assertThat(Chord(MinorMaj9, C).notes().toSet(), equalTo(expected))
        assertThat(MinorMaj9.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Minor 7b5 chord`() {
        val expected = setOf(C, EFlat, GFlat, BFlat)
        assertThat(Chord(Minor7b5, C).notes().toSet(), equalTo(expected))
        assertThat(Minor7b5.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Minor 9 chord`() {
        val expected = setOf(C, EFlat, G, BFlat, D)
        assertThat(Chord(Minor9, C).notes().toSet(), equalTo(expected))
        assertThat(Minor9.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Diminished chord`() {
        val expected = setOf(C, EFlat, GFlat)
        assertThat(Chord(Diminished, C).notes().toSet(), equalTo(expected))
        assertThat(Diminished.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Diminished 7 chord`() {
        val expected = setOf(C, EFlat, GFlat, A)
        assertThat(Chord(Diminished7, C).notes().toSet(), equalTo(expected))
        assertThat(Diminished7.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Sus2 chord`() {
        val expected = setOf(C, D, G)
        assertThat(Chord(Sus2, C).notes().toSet(), equalTo(expected))
        assertThat(Sus2.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Sus2 diminished chord`() {
        val expected = setOf(C, D, GFlat)
        assertThat(Chord(Sus2Diminished, C).notes().toSet(), equalTo(expected))
        assertThat(Sus2Diminished.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Sus2 augmented chord`() {
        val expected = setOf(C, D, GSharp)
        assertThat(Chord(Sus2Augmented, C).notes().toSet(), equalTo(expected))
        assertThat(Sus2Augmented.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Sus4 chord`() {
        val expected = setOf(C, F, G)
        assertThat(Chord(Sus4, C).notes().toSet(), equalTo(expected))
        assertThat(Sus4.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Sus4 diminished chord`() {
        val expected = setOf(C, F, GFlat)
        assertThat(Chord(Sus4Diminished, C).notes().toSet(), equalTo(expected))
        assertThat(Sus4Diminished.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Sus4 augmented chord`() {
        val expected = setOf(C, F, GSharp)
        assertThat(Chord(Sus4Augmented, C).notes().toSet(), equalTo(expected))
        assertThat(Sus4Augmented.createChord(C).notes().toSet(), equalTo(expected))
    }
}