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
    fun `Generate correct notes for C Major 9#11 chord`() {
        val expected = setOf(C, E, G, B, D, FSharp)
        assertThat(Chord(Major9Sharp11, C).notes().toSet(), equalTo(expected))
        assertThat(Major9Sharp11.createChord(C).notes().toSet(), equalTo(expected))
    }

    @Test
    fun `Generate correct notes for C Dominant 7 chord`() {
        val expected = setOf(C, E, G, BFlat)
        assertThat(Chord(Dominant7, C).notes().toSet(), equalTo(expected))
        assertThat(Dominant7.createChord(C).notes().toSet(), equalTo(expected))
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
    fun `Generate correct notes for C Minor 7 chord`() {
        val expected = setOf(C, EFlat, G, BFlat)
        assertThat(Chord(Minor7, C).notes().toSet(), equalTo(expected))
        assertThat(Minor7.createChord(C).notes().toSet(), equalTo(expected))
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
}