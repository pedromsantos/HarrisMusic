package org.harris.notes

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.harris.notes.Interval.*
import org.harris.notes.Pitch.*
import org.junit.Test

val notes = listOf(C, CSharp, DFlat, D, DSharp, EFlat, E, F, FSharp, GFlat, G, AFlat, A, ASharp, BFlat, B)

class NoteShould {

    @Test
    fun `transpose using a augmented ninth from G to A#`() {
        assertThat(G.transpose(AugmentedNinth), equalTo(ASharp))
    }

    @Test
    fun `transpose using a perfect eleventh from F to Bb`() {
        assertThat(F.transpose(PerfectFourth), equalTo(BFlat))
    }

    @Test
    fun `transpose using a augmented second from D to E#`() {
        assertThat(D.transpose(AugmentedSecond), equalTo(ESharp))
    }

    @Test
    fun `transpose using a minor third from G to Bb`() {
        assertThat(G.transpose(MinorThird), equalTo(BFlat))
    }

    @Test
    fun `transpose using a major third from G to B`() {
        assertThat(G.transpose(MajorThird), equalTo(B))
    }
}
