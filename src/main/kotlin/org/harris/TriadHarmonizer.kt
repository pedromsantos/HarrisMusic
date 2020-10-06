package org.harris

class TriadHarmonizer(private val scale: Scale) {
    fun chordForScaleDegree(degree: ScaleDegree): Chord {
        val thirds = scale.thirdsFrom(degree)

        val chordNotes = arrayOf(
            ChordNote(thirds[0], ChordNoteFunction.Root),
            ChordNote(thirds[1], ChordNoteFunction.Third),
            ChordNote(thirds[2], ChordNoteFunction.Fifth)
        )
        val pattern =  ChordPattern.from(ChordNotes(chordNotes).toIntervals())
        return ClosedChord(thirds.first(), pattern)
    }
}
