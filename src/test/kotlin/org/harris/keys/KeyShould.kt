package org.harris.keys

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.harris.keys.Key.AFlatMajor
import org.harris.keys.Key.AMajor
import org.harris.keys.Key.AMinor
import org.harris.keys.Key.BFlatMajor
import org.harris.keys.Key.BFlatMinor
import org.harris.keys.Key.BMajor
import org.harris.keys.Key.BMinor
import org.harris.keys.Key.CMajor
import org.harris.keys.Key.CMinor
import org.harris.keys.Key.CSharpMinor
import org.harris.keys.Key.DFlatMajor
import org.harris.keys.Key.DMajor
import org.harris.keys.Key.DMinor
import org.harris.keys.Key.EFlatMajor
import org.harris.keys.Key.EFlatMinor
import org.harris.keys.Key.EMinor
import org.harris.keys.Key.FMajor
import org.harris.keys.Key.FMinor
import org.harris.keys.Key.FSharpMajor
import org.harris.keys.Key.FSharpMinor
import org.harris.keys.Key.GFlatMajor
import org.harris.keys.Key.GMajor
import org.harris.keys.Key.GMinor
import org.harris.keys.Key.GSharpMinor
import org.harris.notes.Pitch.A
import org.harris.notes.Pitch.AFlat
import org.harris.notes.Pitch.ASharp
import org.harris.notes.Pitch.B
import org.harris.notes.Pitch.BFlat
import org.harris.notes.Pitch.C
import org.harris.notes.Pitch.CSharp
import org.harris.notes.Pitch.D
import org.harris.notes.Pitch.DFlat
import org.harris.notes.Pitch.DSharp
import org.harris.notes.Pitch.E
import org.harris.notes.Pitch.EFlat
import org.harris.notes.Pitch.F
import org.harris.notes.Pitch.FSharp
import org.harris.notes.Pitch.G
import org.harris.notes.Pitch.GFlat
import org.harris.notes.Pitch.GSharp
import org.junit.Test

class KeyShould {
    @Test
    fun `Generate correct pitches for C Major key`() {
        assertThat(CMajor.pitches(), equalTo(setOf(C, D, E, F, G, A, B)))
    }

    @Test
    fun `Generate correct pitches for G Major key`() {
        assertThat(GMajor.pitches(), equalTo(setOf(G, A, B, C, D, E, FSharp)))
    }

    @Test
    fun `Generate correct pitches for D Major key`() {
        assertThat(DMajor.pitches(), equalTo(setOf(D, E, FSharp, G, A, B, CSharp)))
    }

    @Test
    fun `Generate correct pitches for A Major key`() {
        assertThat(AMajor.pitches(), equalTo(setOf(A, B, CSharp, D, E, FSharp, GSharp)))
    }

    @Test
    fun `Generate correct pitches for E Major key`() {
        assertThat(Key.EMajor.pitches(), equalTo(setOf(E, FSharp, GSharp, A, B, CSharp, DSharp)))
    }

    @Test
    fun `Generate correct pitches for B Major key`() {
        assertThat(BMajor.pitches(), equalTo(setOf(B, CSharp, DSharp, E, FSharp, GSharp, ASharp)))
    }

    @Test
    fun `Generate correct pitches for F sharp Major key`() {
        assertThat(FSharpMajor.pitches(), equalTo(setOf(FSharp, GSharp, ASharp, B, CSharp, DSharp, F)))
    }

    @Test
    fun `Generate correct pitches for D flat Major key`() {
        assertThat(DFlatMajor.pitches(), equalTo(setOf(DFlat, EFlat, F, GFlat, AFlat, BFlat, C)))
    }

    @Test
    fun `Generate correct pitches for A flat Major key`() {
        assertThat(AFlatMajor.pitches(), equalTo(setOf(AFlat, BFlat, C, DFlat, EFlat, F, G)))
    }

    @Test
    fun `Generate correct pitches for G flat Major key`() {
        assertThat(GFlatMajor.pitches(), equalTo(setOf(GFlat, AFlat, BFlat, B, DFlat, EFlat, F)))
    }

    @Test
    fun `Generate correct pitches for E flat Major key`() {
        assertThat(EFlatMajor.pitches(), equalTo(setOf(EFlat, F, G, AFlat, BFlat, C, D)))
    }

    @Test
    fun `Generate correct pitches for B flat Major key`() {
        assertThat(BFlatMajor.pitches(), equalTo(setOf(BFlat, C, D, EFlat, F, G, A)))
    }

    @Test
    fun `Generate correct pitches for F Major key`() {
        assertThat(FMajor.pitches(), equalTo(setOf(F, G, A, BFlat, C, D, E)))
    }

    @Test
    fun `Generate correct pitches for A Minor key`() {
        assertThat(AMinor.pitches(), equalTo(setOf(A, B, C, D, E, F, G)))
    }

    @Test
    fun `Generate correct pitches for E Minor key`() {
        assertThat(EMinor.pitches(), equalTo(setOf(E, FSharp, G, A, B, C, D)))
    }

    @Test
    fun `Generate correct pitches for B Minor key`() {
        assertThat(BMinor.pitches(), equalTo(setOf(B, CSharp, D, E, FSharp, G, A)))
    }

    @Test
    fun `Generate correct pitches for F sharp Minor key`() {
        assertThat(FSharpMinor.pitches(), equalTo(setOf(FSharp, GSharp, A, B, CSharp, D, E)))
    }

    @Test
    fun `Generate correct pitches for C sharp Minor key`() {
        assertThat(CSharpMinor.pitches(), equalTo(setOf(CSharp, DSharp, E, FSharp, GSharp, A, B)))
    }

    @Test
    fun `Generate correct pitches for G sharp Minor key`() {
        assertThat(GSharpMinor.pitches(), equalTo(setOf(GSharp, ASharp, B, CSharp, DSharp, E, FSharp)))
    }

    @Test
    fun `Generate correct pitches for E flat Minor key`() {
        assertThat(EFlatMinor.pitches(), equalTo(setOf(EFlat, F, GFlat, AFlat, BFlat, B, DFlat)))
    }

    @Test
    fun `Generate correct pitches for B flat Minor key`() {
        assertThat(BFlatMinor.pitches(), equalTo(setOf(BFlat, C, DFlat, EFlat, F, GFlat, AFlat)))
    }

    @Test
    fun `Generate correct pitches for F Minor key`() {
        assertThat(FMinor.pitches(), equalTo(setOf(F, G, AFlat, BFlat, C, DFlat, EFlat)))
    }

    @Test
    fun `Generate correct pitches for C Minor key`() {
        assertThat(CMinor.pitches(), equalTo(setOf(C, D, EFlat, F, G, AFlat, BFlat)))
    }

    @Test
    fun `Generate correct pitches for G Minor key`() {
        assertThat(GMinor.pitches(), equalTo(setOf(G, A, BFlat, C, D, EFlat, F)))
    }

    @Test
    fun `Generate correct pitches for D Minor key`() {
        assertThat(DMinor.pitches(), equalTo(setOf(D, E, F, G, A, BFlat, C)))
    }
}
