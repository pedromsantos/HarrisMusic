package org.harris

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.harris.Pitch.*
import org.harris.ScalePattern.*
import org.junit.Test
import org.junit.Before

class TriadHarmonizerShould {
    private lateinit var cIonian : Scale
    private lateinit var harmonizer : TriadHarmonizer

    @Before fun setup() {
        cIonian = Ionian.createScale(C)
        harmonizer = TriadHarmonizer(cIonian)
    }

    @Test
    fun `Create triad for degree I of C Ionian scale`() {
        var chord = harmonizer.chordFor(ScaleDegree.I)

        assertThat(chord.pitches().toList(), equalTo(listOf(C, E, G)))
    }

    @Test
    fun `Create triad for degree II of C Ionian scale`() {
        var chord = harmonizer.chordFor(ScaleDegree.II)

        assertThat(chord.pitches().toList(), equalTo(listOf(D, F, A)))
    }

    @Test
    fun `Create triad for degree III of C Ionian scale`() {
        var chord = harmonizer.chordFor(ScaleDegree.III)

        assertThat(chord.pitches().toList(), equalTo(listOf(E, G, B)))
    }

    @Test
    fun `Create triad for degree IV of C Ionian scale`() {
        var chord = harmonizer.chordFor(ScaleDegree.IV)

        assertThat(chord.pitches().toList(), equalTo(listOf(F, A, C)))
    }

    @Test
    fun `Create triad for degree V of C Ionian scale`() {
        var chord = harmonizer.chordFor(ScaleDegree.V)

        assertThat(chord.pitches().toList(), equalTo(listOf(G, B, D)))
    }

    @Test
    fun `Create triad for degree VI of C Ionian scale`() {
        var chord = harmonizer.chordFor(ScaleDegree.VI)

        assertThat(chord.pitches().toList(), equalTo(listOf(A, C, E)))
    }

    @Test
    fun `Create triad for degree VII of C Ionian scale`() {
        var chord = harmonizer.chordFor(ScaleDegree.VII)

        assertThat(chord.pitches().toList(), equalTo(listOf(B, D, F)))
    }
}

