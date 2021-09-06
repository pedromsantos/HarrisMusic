package org.harris.keys

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.harris.keys.Key.*
import org.harris.notes.Pitch.*
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
        assertThat(EMajor.pitches(), equalTo(setOf(E, FSharp, GSharp, A, B, CSharp, DSharp)))
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
        assertThat(DFlatMajor.pitches(), equalTo(setOf(DFlat, EFlat, F, GFlat, AFlat, BFlat, C )))
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
        assertThat(BFlatMinor.pitches(), equalTo(setOf( BFlat, C, DFlat, EFlat, F, GFlat, AFlat)))
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