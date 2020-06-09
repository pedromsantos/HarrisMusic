package org.harris

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.harris.Interval.*
import org.harris.Note.*
import org.junit.Test

class NoteShould {
    @Test
    fun `sharp to note above`() {
        assertThat(C.sharp(), equalTo(CSharp))
        assertThat(CSharp.sharp(), equalTo(D))
        assertThat(DFlat.sharp(), equalTo(D))
        assertThat(D.sharp(), equalTo(DSharp))
        assertThat(DSharp.sharp(), equalTo(E))
        assertThat(EFlat.sharp(), equalTo(E))
        assertThat(E.sharp(), equalTo(F))
        assertThat(F.sharp(), equalTo(FSharp))
        assertThat(FSharp.sharp(), equalTo(G))
        assertThat(GFlat.sharp(), equalTo(G))
        assertThat(G.sharp(), equalTo(GSharp))
        assertThat(GSharp.sharp(), equalTo(A))
        assertThat(AFlat.sharp(), equalTo(A))
        assertThat(A.sharp(), equalTo(ASharp))
        assertThat(ASharp.sharp(), equalTo(B))
        assertThat(BFlat.sharp(), equalTo(B))
        assertThat(B.sharp(), equalTo(C))
    }

    @Test
    fun `flat to note below`() {
        assertThat(C.flat(), equalTo(B))
        assertThat(CSharp.flat(), equalTo(C))
        assertThat(DFlat.flat(), equalTo(C))
        assertThat(D.flat(), equalTo(DFlat))
        assertThat(DSharp.flat(), equalTo(D))
        assertThat(EFlat.flat(), equalTo(D))
        assertThat(E.flat(), equalTo(EFlat))
        assertThat(F.flat(), equalTo(E))
        assertThat(FSharp.flat(), equalTo(F))
        assertThat(GFlat.flat(), equalTo(F))
        assertThat(G.flat(), equalTo(GFlat))
        assertThat(GSharp.flat(), equalTo(G))
        assertThat(AFlat.flat(), equalTo(G))
        assertThat(A.flat(), equalTo(AFlat))
        assertThat(ASharp.flat(), equalTo(A))
        assertThat(BFlat.flat(), equalTo(A))
        assertThat(B.flat(), equalTo(BFlat))
    }
    
    @Test
    fun `measure semitones between notes`() {
        assertThat(C.measureAbsoluteSemitones(C), equalTo(0))
        assertThat(C.measureAbsoluteSemitones(CSharp), equalTo(1))
        assertThat(C.measureAbsoluteSemitones(DFlat), equalTo(1))
        assertThat(C.measureAbsoluteSemitones(D), equalTo(2))
        assertThat(C.measureAbsoluteSemitones(DSharp), equalTo(3))
        assertThat(C.measureAbsoluteSemitones(EFlat), equalTo(3))
        assertThat(C.measureAbsoluteSemitones(E), equalTo(4))
        assertThat(C.measureAbsoluteSemitones(F), equalTo(5))
        assertThat(C.measureAbsoluteSemitones(FSharp), equalTo(6))
        assertThat(C.measureAbsoluteSemitones(GFlat), equalTo(6))
        assertThat(C.measureAbsoluteSemitones(G), equalTo(7))
        assertThat(C.measureAbsoluteSemitones(GSharp), equalTo(8))
        assertThat(C.measureAbsoluteSemitones(AFlat), equalTo(8))
        assertThat(C.measureAbsoluteSemitones(A), equalTo(9))
        assertThat(C.measureAbsoluteSemitones(ASharp), equalTo(10))
        assertThat(C.measureAbsoluteSemitones(BFlat), equalTo(10))
        assertThat(C.measureAbsoluteSemitones(B), equalTo(11))
    }

    @Test
    fun `measure interval between notes`() {
        assertThat(C.intervalBetween(C), equalTo(Unison))
        assertThat(C.intervalBetween(CSharp), equalTo(AugmentedUnison))
        assertThat(C.intervalBetween(DFlat), equalTo(MinorSecond))
        assertThat(C.intervalBetween(D), equalTo(MajorSecond))
        assertThat(C.intervalBetween(DSharp), equalTo(AugmentedSecond))
        assertThat(C.intervalBetween(EFlat), equalTo(MinorThird))
        assertThat(C.intervalBetween(E), equalTo(MajorThird))
        assertThat(C.intervalBetween(F), equalTo(PerfectFourth))
        assertThat(C.intervalBetween(FSharp), equalTo(AugmentedFourth))
        assertThat(C.intervalBetween(GFlat), equalTo(DiminishedFifth))
        assertThat(C.intervalBetween(G), equalTo(PerfectFifth))
        assertThat(C.intervalBetween(GSharp), equalTo(AugmentedFifth))
        assertThat(C.intervalBetween(AFlat), equalTo(MinorSixth))
        assertThat(C.intervalBetween(A), equalTo(MajorSixth))
        assertThat(C.intervalBetween(ASharp), equalTo(MinorSeventh))
        assertThat(C.intervalBetween(BFlat), equalTo(MinorSeventh))
        assertThat(C.intervalBetween(B), equalTo(MajorSeventh))
    }
}
