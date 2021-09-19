package org.harris.scales

import org.harris.chords.Chord

interface Harmonizer {
    fun chordFor(degree: ScaleDegree): Chord
}
