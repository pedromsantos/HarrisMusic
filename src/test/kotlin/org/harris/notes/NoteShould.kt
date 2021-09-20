package org.harris.notes

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.harris.notes.Interval.AugmentedNinth
import org.harris.notes.Interval.AugmentedSecond
import org.harris.notes.Interval.MajorThird
import org.harris.notes.Interval.MinorThird
import org.harris.notes.Interval.PerfectFourth
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
import org.harris.notes.Pitch.ESharp
import org.harris.notes.Pitch.F
import org.harris.notes.Pitch.FSharp
import org.harris.notes.Pitch.G
import org.harris.notes.Pitch.GFlat
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
