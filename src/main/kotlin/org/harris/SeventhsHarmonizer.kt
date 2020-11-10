package org.harris

class SeventhsHarmonizer(private val scale: Scale) {
    fun chordForScaleDegree(degree: ScaleDegree): Chord {
        val thirds = scale.thirdsFrom(degree)

        val chordNotes = arrayOf(
            ChordNote(thirds[0], ChordNoteFunction.Root),
            ChordNote(thirds[1], ChordNoteFunction.Third),
            ChordNote(thirds[2], ChordNoteFunction.Fifth),
            ChordNote(thirds[3], ChordNoteFunction.Seventh)
        )
        val intervals = ChordNotes(chordNotes).toIntervals()
        val pattern = ChordPattern.from(intervals)
        return ClosedChord(ChordNote(thirds.first(), ChordNoteFunction.Root), pattern, ChordNotes(chordNotes))
    }
}