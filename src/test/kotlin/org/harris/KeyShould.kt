package org.harris

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.harris.Key.*
import org.harris.Pitch.*
import org.junit.Test

class KeyShould {
    @Test
    fun `Generate correct notes for C Major key`() {
        assertThat(CMajor.notes(), equalTo(setOf(C, D, E, F, G, A, B)))
    }

    @Test
    fun `Generate correct notes for G Major key`() {
        assertThat(GMajor.notes(), equalTo(setOf(G, A, B, C, D, E, FSharp)))
    }

    @Test
    fun `Generate correct notes for D Major key`() {
        assertThat(DMajor.notes(), equalTo(setOf(D, E, FSharp, G, A, B, CSharp)))
    }

    @Test
    fun `Generate correct notes for A Major key`() {
        assertThat(AMajor.notes(), equalTo(setOf(A, B, CSharp, D, E, FSharp, GSharp)))
    }

    @Test
    fun `Generate correct notes for E Major key`() {
        assertThat(EMajor.notes(), equalTo(setOf(E, FSharp, GSharp, A, B, CSharp, DSharp)))
    }

    @Test
    fun `Generate correct notes for B Major key`() {
        assertThat(BMajor.notes(), equalTo(setOf(B, CSharp, DSharp, E, FSharp, GSharp, ASharp)))
    }

    @Test
    fun `Generate correct notes for F sharp Major key`() {
        assertThat(FSharpMajor.notes(), equalTo(setOf(FSharp, GSharp, ASharp, B, CSharp, DSharp, F)))
    }

    @Test
    fun `Generate correct notes for D flat Major key`() {
        assertThat(DFlatMajor.notes(), equalTo(setOf(DFlat, EFlat, F, GFlat, AFlat, BFlat, C )))
    }

    @Test
    fun `Generate correct notes for A flat Major key`() {
        assertThat(AFlatMajor.notes(), equalTo(setOf(AFlat, BFlat, C, DFlat, EFlat, F, G)))
    }

    @Test
    fun `Generate correct notes for G flat Major key`() {
        assertThat(GFlatMajor.notes(), equalTo(setOf(GFlat, AFlat, BFlat, B, DFlat, EFlat, F)))
    }

    @Test
    fun `Generate correct notes for E flat Major key`() {
        assertThat(EFlatMajor.notes(), equalTo(setOf(EFlat, F, G, AFlat, BFlat, C, D)))
    }

    @Test
    fun `Generate correct notes for B flat Major key`() {
        assertThat(BFlatMajor.notes(), equalTo(setOf(BFlat, C, D, EFlat, F, G, A)))
    }

    @Test
    fun `Generate correct notes for F Major key`() {
        assertThat(FMajor.notes(), equalTo(setOf(F, G, A, BFlat, C, D, E)))
    }

    @Test
    fun `Generate correct notes for A Minor key`() {
        assertThat(AMinor.notes(), equalTo(setOf(A, B, C, D, E, F, G)))
    }

    @Test
    fun `Generate correct notes for E Minor key`() {
        assertThat(EMinor.notes(), equalTo(setOf(E, FSharp, G, A, B, C, D)))
    }

    @Test
    fun `Generate correct notes for B Minor key`() {
        assertThat(BMinor.notes(), equalTo(setOf(B, CSharp, D, E, FSharp, G, A)))
    }

    @Test
    fun `Generate correct notes for F sharp Minor key`() {
        assertThat(FSharpMinor.notes(), equalTo(setOf(FSharp, GSharp, A, B, CSharp, D, E)))
    }

    @Test
    fun `Generate correct notes for C sharp Minor key`() {
        assertThat(CSharpMinor.notes(), equalTo(setOf(CSharp, DSharp, E, FSharp, GSharp, A, B)))
    }

    @Test
    fun `Generate correct notes for G sharp Minor key`() {
        assertThat(GSharpMinor.notes(), equalTo(setOf(GSharp, ASharp, B, CSharp, DSharp, E, FSharp)))
    }

    @Test
    fun `Generate correct notes for E flat Minor key`() {
        assertThat(EFlatMinor.notes(), equalTo(setOf(EFlat, F, GFlat, AFlat, BFlat, B, DFlat)))
    }

    @Test
    fun `Generate correct notes for B flat Minor key`() {
        assertThat(BFlatMinor.notes(), equalTo(setOf( BFlat, C, DFlat, EFlat, F, GFlat, AFlat)))
    }

    @Test
    fun `Generate correct notes for F Minor key`() {
        assertThat(FMinor.notes(), equalTo(setOf(F, G, AFlat, BFlat, C, DFlat, EFlat)))
    }

    @Test
    fun `Generate correct notes for C Minor key`() {
        assertThat(CMinor.notes(), equalTo(setOf(C, D, EFlat, F, G, AFlat, BFlat)))
    }

    @Test
    fun `Generate correct notes for G Minor key`() {
        assertThat(GMinor.notes(), equalTo(setOf(G, A, BFlat, C, D, EFlat, F)))
    }

    @Test
    fun `Generate correct notes for D Minor key`() {
        assertThat(DMinor.notes(), equalTo(setOf(D, E, F, G, A, BFlat, C)))
    }
}