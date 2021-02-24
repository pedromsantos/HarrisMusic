package org.harris.scales

import org.harris.chords.Chord
import org.harris.scales.ScaleDegree

interface Harmonizer {
    fun chordFor(degree: ScaleDegree): Chord
}