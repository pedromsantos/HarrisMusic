package org.harris

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.harris.Note.*
import org.harris.ScalePattern.*
import org.junit.Test

class TriadHarmonizerShould {
    @Test
    fun `Create triad for degree I of C Ionian scale`() {
        val cIonian = Ionian.createScale(C)
        val harmonizer = TriadHarmonizer(cIonian)
        var chord = harmonizer.chordForScaleDegree(ScaleDegree.I)

        assertThat(chord.notes().toList(), equalTo(listOf(C, E, G)))
    }

    @Test
    fun `Create triad for degree II of C Ionian scale`() {
        val cIonian = Ionian.createScale(C)
        val harmonizer = TriadHarmonizer(cIonian)
        var chord = harmonizer.chordForScaleDegree(ScaleDegree.II)

        assertThat(chord.notes().toList(), equalTo(listOf(D, F, A)))
    }
}

