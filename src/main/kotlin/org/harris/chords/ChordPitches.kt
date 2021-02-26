package org.harris.chords

import org.harris.moveElement
import org.harris.notes.Interval
import org.harris.notes.Pitch
import org.harris.rotate

data class ChordPitch(val pitch: Pitch, val function: ChordFunction)

class ChordPitches {
    private val pitches: Array<ChordPitch>

    internal constructor(root: Pitch, pattern: ChordPattern) {
        this.pitches = pattern.notes(root)
    }

    internal constructor(pitches: Array<ChordPitch>) {
        this.pitches = pitches
    }

    internal fun notes(): Array<Pitch> = pitches.map { it.pitch }.toTypedArray()

    internal fun bass(): ChordPitch {
        return pitches.first()
    }

    internal fun lead(): ChordPitch {
        return pitches.last()
    }

    internal fun pitchForFunction(function: ChordFunction): ChordPitch {
        return pitches.first { it.function == function }
    }

    internal fun remove(function: ChordFunction): ChordPitches {
        return ChordPitches(pitches.filter { it.function != function }.toTypedArray())
    }

    internal fun rotate(amount: Int = 1): ChordPitches {
        return ChordPitches(pitches.rotate(amount))
    }

    internal fun rotateLastSkipFirst(skip: Int = 1): ChordPitches {
        val lastNotes = pitches.drop(skip).toTypedArray().rotate(1).toList()
        return ChordPitches(pitches.take(skip).union(lastNotes).toTypedArray())
    }

    internal fun drop2(): ChordPitches? {
        if (notes().size != 4) {
            return null
        }

        return ChordPitches(pitches.moveElement(1, 2).moveElement(2, 3))
    }

    internal fun drop3(): ChordPitches? {
        return drop2()?.drop2()
    }

    internal fun toIntervals() : List<Interval> {
        val root = pitchForFunction(ChordFunction.Root).pitch
        var intervals = mutableListOf<Interval>()

        for(pitch in pitches.drop(1)) {
            val interval = root.intervalTo(pitch.pitch)
            intervals.add(interval)
        }

        return intervals
    }
}