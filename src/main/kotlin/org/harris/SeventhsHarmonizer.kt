package org.harris

class SeventhsHarmonizer(private val scale: Scale) : Harmonizer {
    override fun chordFor(degree: ScaleDegree): Chord {
        val thirds = scale.thirdsFrom(degree)

        val chordNotes = arrayOf(
            ChordPitch(thirds[0], ChordFunction.Root),
            ChordPitch(thirds[1], ChordFunction.Third),
            ChordPitch(thirds[2], ChordFunction.Fifth),
            ChordPitch(thirds[3], ChordFunction.Seventh)
        )
        val intervals = ChordPitches(chordNotes).toIntervals()
        val pattern = ChordPattern.from(intervals)
        return ClosedChord(ChordPitch(thirds.first(), ChordFunction.Root), pattern, ChordPitches(chordNotes))
    }
}