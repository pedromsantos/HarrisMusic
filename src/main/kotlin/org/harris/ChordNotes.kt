package org.harris

data class ChordNote(val pitch: Pitch, val function: ChordNoteFunction)

class ChordNotes {
    private val notes: Array<ChordNote>

    internal constructor(root: Pitch, pattern: ChordPattern) {
        this.notes = pattern.notes(root)
    }

    internal constructor(notes: Array<ChordNote>) {
        this.notes = notes
    }

    internal fun notes(): Array<Pitch> = notes.map { it.pitch }.toTypedArray()

    internal fun bass(): ChordNote {
        return notes.first()
    }

    internal fun lead(): ChordNote {
        return notes.last()
    }

    internal fun noteForFunction(function: ChordNoteFunction): ChordNote {
        return notes.first { it.function == function }
    }

    internal fun remove(function: ChordNoteFunction): ChordNotes {
        return ChordNotes(notes.filter { it.function != function }.toTypedArray())
    }

    internal fun rotate(amount: Int = 1): ChordNotes {
        return ChordNotes(notes.rotate(amount))
    }

    internal fun rotateLastSkipFirst(skip: Int = 1): ChordNotes {
        val lastNotes = notes.drop(skip).toTypedArray().rotate(1).toList()
        return ChordNotes(notes.take(skip).union(lastNotes).toTypedArray())
    }

    internal fun drop2(): ChordNotes? {
        if (notes().size != 4) {
            return null
        }

        return ChordNotes(notes.moveElement(1, 2).moveElement(2, 3))
    }

    internal fun drop3(): ChordNotes? {
        return drop2()?.drop2()
    }

    internal fun toIntervals() : List<Interval> {
        val root = noteForFunction(ChordNoteFunction.Root).pitch
        var intervals = mutableListOf<Interval>()

        for(note in notes.drop(1)) {
            val interval = root.intervalTo(note.pitch)
            intervals.add(interval)
        }

        return intervals
    }
}