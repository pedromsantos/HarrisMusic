package org.harris

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.harris.Note.*
import org.harris.ScalePattern.*
import org.junit.Test

class ScaleShould {
    @Test
    fun `Generate correct notes for C Ionian`() {
        assertThat(Scale(Ionian, C).notes().toSet(), equalTo(setOf(C, D, E, F, G, A, B)))
        assertThat(Ionian.createScale(C).notes().toSet(), equalTo(setOf(C, D, E, F, G, A, B)))
    }

    @Test
    fun `Generate correct notes for C Dorian`() {
        assertThat(Scale(Dorian, C).notes().toSet(), equalTo(setOf(C, D, EFlat, F, G, A, BFlat)))
        assertThat(Dorian.createScale(C).notes().toSet(), equalTo(setOf(C, D, EFlat, F, G, A, BFlat)))
    }

    @Test
    fun `Generate correct notes for C Phrygian`() {
        assertThat(Scale(Phrygian, C).notes().toSet(), equalTo(setOf(C, DFlat, EFlat, F, G, AFlat, BFlat)))
        assertThat(Phrygian.createScale(C).notes().toSet(), equalTo(setOf(C, DFlat, EFlat, F, G, AFlat, BFlat)))
    }

    @Test
    fun `Generate correct notes for C Lydian`() {
        assertThat(Scale(Lydian, C).notes().toSet(), equalTo(setOf(C, D, E, FSharp, G, A, B)))
        assertThat(Lydian.createScale(C).notes().toSet(), equalTo(setOf(C, D, E, FSharp, G, A, B)))
    }

    @Test
    fun `Generate correct notes for C Mixolydian`() {
        assertThat(Scale(Mixolydian, C).notes().toSet(), equalTo(setOf(C, D, E, F, G, A, BFlat)))
        assertThat(Mixolydian.createScale(C).notes().toSet(), equalTo(setOf(C, D, E, F, G, A, BFlat)))
    }

    @Test
    fun `Generate correct notes for C Aolian`() {
        assertThat(Scale(Aolian, C).notes().toSet(), equalTo(setOf(C, D, EFlat, F, G, AFlat, BFlat)))
        assertThat(Aolian.createScale(C).notes().toSet(), equalTo(setOf(C, D, EFlat, F, G, AFlat, BFlat)))
    }

    @Test
    fun `Generate correct notes for C Locrian`() {
        assertThat(Scale(Locrian, C).notes().toSet(), equalTo(setOf(C, DFlat, EFlat, F, GFlat, AFlat, BFlat)))
        assertThat(Locrian.createScale(C).notes().toSet(), equalTo(setOf(C, DFlat, EFlat, F, GFlat, AFlat, BFlat)))
    }
}