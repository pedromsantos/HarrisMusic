package org.harris

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.harris.Note.*
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
        var chord = harmonizer.chordForScaleDegree(ScaleDegree.I)

        assertThat(chord.notes().toList(), equalTo(listOf(C, E, G)))
    }

    @Test
    fun `Create triad for degree II of C Ionian scale`() {
        var chord = harmonizer.chordForScaleDegree(ScaleDegree.II)

        assertThat(chord.notes().toList(), equalTo(listOf(D, F, A)))
    }

    @Test
    fun `Create triad for degree III of C Ionian scale`() {
        var chord = harmonizer.chordForScaleDegree(ScaleDegree.III)

        assertThat(chord.notes().toList(), equalTo(listOf(E, G, B)))
    }

    @Test
    fun `Create triad for degree IV of C Ionian scale`() {
        var chord = harmonizer.chordForScaleDegree(ScaleDegree.IV)

        assertThat(chord.notes().toList(), equalTo(listOf(F, A, C)))
    }

    @Test
    fun `Create triad for degree V of C Ionian scale`() {
        var chord = harmonizer.chordForScaleDegree(ScaleDegree.V)

        assertThat(chord.notes().toList(), equalTo(listOf(G, B, D)))
    }

    @Test
    fun `Create triad for degree VI of C Ionian scale`() {
        var chord = harmonizer.chordForScaleDegree(ScaleDegree.VI)

        assertThat(chord.notes().toList(), equalTo(listOf(A, C, E)))
    }

    @Test
    fun `Create triad for degree VII of C Ionian scale`() {
        var chord = harmonizer.chordForScaleDegree(ScaleDegree.VII)

        assertThat(chord.notes().toList(), equalTo(listOf(B, D, F)))
    }
}

