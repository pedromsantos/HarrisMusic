package org.harris.scales

import org.harris.chords.Chord
import org.harris.chords.ChordFunction
import org.harris.chords.ChordFunction.Fifth
import org.harris.chords.ChordFunction.Root
import org.harris.chords.ChordFunction.Third
import org.harris.chords.ChordPattern
import org.harris.chords.ChordPitch
import org.harris.chords.ChordPitches
import org.harris.chords.ClosedChord

class TriadHarmonizer(
    private val scale: Scale,
) : Harmonizer {
    override fun chordFor(degree: ScaleDegree): Chord {
        val thirds = scale.thirdsFrom(degree)

        val chordNotes =
            arrayOf(
                ChordPitch(thirds[0], ChordFunction.Root),
                ChordPitch(thirds[1], ChordFunction.Third),
                ChordPitch(thirds[2], ChordFunction.Fifth),
            )
        val intervals = ChordPitches(chordNotes).toIntervals()
        val pattern = ChordPattern.from(intervals)
        return ClosedChord(ChordPitch(thirds.first(), ChordFunction.Root), pattern, ChordPitches(chordNotes))
    }
}
