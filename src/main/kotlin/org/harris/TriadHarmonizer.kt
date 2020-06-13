package org.harris

class TriadHarmonizer(private val scale: Scale) {
    fun chordForScaleDegree(degree: ScaleDegree): Chord {
        val thirds = scale.thirdsFrom(degree)

        return ClosedChord(Note.C, ChordPattern.Major)
    }
}
