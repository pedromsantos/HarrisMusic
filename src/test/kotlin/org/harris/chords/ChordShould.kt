package org.harris.chords

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.startsWith
import org.harris.chords.ChordFunction.Fifth
import org.harris.chords.ChordFunction.Root
import org.harris.chords.ChordFunction.Third
import org.harris.chords.ChordPattern.Major
import org.harris.chords.ChordPattern.Major7
import org.harris.notes.Pitch.B
import org.harris.notes.Pitch.C
import org.harris.notes.Pitch.E
import org.harris.notes.Pitch.G
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
        assertThat(ClosedChord(C, Major).pitchForFunction(Root), equalTo(C))
    }

    @Test
    fun `return note for function third`() {
        assertThat(ClosedChord(C, Major).pitchForFunction(Third), equalTo(E))
    }

    @Test
    fun `return note for function fifth`() {
        assertThat(ClosedChord(C, Major).pitchForFunction(Fifth), equalTo(G))
    }

    @Test
    fun `remove function from chord`() {
        assertThat(
            ClosedChord(C, Major)
                .remove(Fifth)
                .pitches().toList(),
            equalTo(listOf(C, E))
        )
    }

    @Test
    fun `remove function from drop 2 chord`() {
        assertThat(
            ClosedChord(C, Major7)
                .drop2()
                .remove(Fifth)
                .pitches().toList(),
            equalTo(listOf(C, B, E))
        )
    }

    @Test
    fun `remove function from drop 3 chord`() {
        assertThat(
            ClosedChord(C, Major7)
                .drop3()
                .remove(Fifth)
                .pitches().toList(),
            equalTo(listOf(C, B, E))
        )
    }

    @Test
    fun `invert chord to first inversion`() {
        assertThat(
            ClosedChord(C, Major)
                .invert()
                .pitches().toList(),
            equalTo(listOf(E, G, C))
        )
    }

    @Test
    fun `invert chord to second inversion`() {
        assertThat(
            ClosedChord(C, Major)
                .invert()
                .invert()
                .pitches().toList(),
            equalTo(listOf(G, C, E))
        )
    }

    @Test
    fun `go back to root inversion when performing third inversion on triad`() {
        assertThat(
            ClosedChord(C, Major)
                .invert()
                .invert()
                .invert()
                .pitches().toList(),
            equalTo(listOf(C, E, G))
        )
    }

    @Test
    fun `invert chord to third inversion`() {
        assertThat(
            ClosedChord(C, Major7)
                .invert()
                .invert()
                .invert()
                .pitches().toList(),
            equalTo(listOf(B, C, E, G))
        )
    }

    @Test
    fun `not change chord to closed it it is already closed`() {
        assertThat(
            ClosedChord(C, Major7)
                .closed()
                .pitches().toList(),
            equalTo(listOf(C, E, G, B))
        )
    }

    @Test
    fun `create drop 2 chord`() {
        assertThat(
            ClosedChord(C, Major7)
                .drop2()
                .pitches().toList(),
            equalTo(listOf(C, G, B, E))
        )
    }

    @Test
    fun `not create drop 2 chord if chord does not have 4 notes`() {
        assertThat(
            ClosedChord(C, Major)
                .drop2()
                .pitches().toList(),
            equalTo(listOf(C, E, G))
        )
    }

    @Test
    fun `not create drop 2 chord if chord is already drop 2`() {
        assertThat(
            ClosedChord(C, Major7)
                .drop2()
                .drop2()
                .pitches().toList(),
            equalTo(listOf(C, G, B, E))
        )
    }

    @Test
    fun `create closed chord from drop 2 chord`() {
        assertThat(
            ClosedChord(C, Major7)
                .drop2()
                .closed()
                .pitches().toList(),
            equalTo(listOf(C, E, G, B))
        )
    }

    @Test
    fun `create drop 2 first inversion`() {
        assertThat(
            ClosedChord(C, Major7)
                .drop2()
                .invert()
                .pitches().toList(),
            equalTo(listOf(E, B, C, G))
        )
    }

    @Test
    fun `create drop 2 second inversion`() {
        assertThat(
            ClosedChord(C, Major7)
                .drop2()
                .invert()
                .invert()
                .pitches().toList(),
            equalTo(listOf(G, C, E, B))
        )
    }

    @Test
    fun `create drop 2 third inversion`() {
        assertThat(
            ClosedChord(C, Major7)
                .drop2()
                .invert()
                .invert()
                .invert()
                .pitches().toList(),
            equalTo(listOf(B, E, G, C))
        )
    }

    @Test
    fun `go back to root inversion on fourth inversion of drop 2`() {
        assertThat(
            ClosedChord(C, Major7)
                .drop2()
                .invert()
                .invert()
                .invert()
                .invert()
                .pitches().toList(),
            equalTo(listOf(C, G, B, E))
        )
    }

    @Test
    fun `create drop 3 chord`() {
        assertThat(
            ClosedChord(C, Major7)
                .drop3()
                .pitches().toList(),
            equalTo(listOf(C, B, E, G))
        )
    }

    @Test
    fun `create closed chord from drop 3 chord`() {
        assertThat(
            ClosedChord(C, Major7)
                .drop3()
                .closed()
                .pitches().toList(),
            equalTo(listOf(C, E, G, B))
        )
    }

    @Test
    fun `create drop 3 first inversion`() {
        assertThat(
            ClosedChord(C, Major7)
                .drop3()
                .invert()
                .pitches().toList(),
            equalTo(listOf(E, C, G, B))
        )
    }

    @Test
    fun `create drop 3 second inversion`() {
        assertThat(
            ClosedChord(C, Major7)
                .drop3()
                .invert()
                .invert()
                .pitches().toList(),
            equalTo(listOf(G, E, B, C))
        )
    }

    @Test
    fun `create drop 3 third inversion`() {
        assertThat(
            ClosedChord(C, Major7)
                .drop3()
                .invert()
                .invert()
                .invert()
                .pitches().toList(),
            equalTo(listOf(B, G, C, E))
        )
    }

    @Test
    fun `go back to root inversion on fourth inversion of drop 3`() {
        assertThat(
            ClosedChord(C, Major7)
                .drop3()
                .invert()
                .invert()
                .invert()
                .invert()
                .pitches().toList(),
            equalTo(listOf(C, B, E, G))
        )
    }

    @Test
    fun `not create drop 3 chord if chord does not have 4 notes`() {
        assertThat(
            ClosedChord(C, Major)
                .drop3()
                .pitches().toList(),
            equalTo(listOf(C, E, G))
        )
    }

    @Test
    fun `not create drop 3 chord if chord is already drop 3`() {
        assertThat(
            ClosedChord(C, Major7)
                .drop3()
                .drop3()
                .pitches().toList(),
            equalTo(listOf(C, B, E, G))
        )
    }
}
