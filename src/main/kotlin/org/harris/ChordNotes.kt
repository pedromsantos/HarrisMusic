package org.harris

class ChordNotes {
    private val notes: Array<ChordNote>

    constructor(root: Note, pattern: ChordPattern) {
        this.notes = pattern.notes(root)
    }

    private constructor(notes: Array<ChordNote>) {
        this.notes = notes
    }

    fun notes(): Array<Note> = notes.map { it.note }.toTypedArray()

    fun bass(): ChordNote {
        return notes.first()
    }

    fun lead(): ChordNote {
        return notes.last()
    }

    fun noteForFunction(function: ChordNoteFunction): ChordNote {
        return notes.first { it.function == function }
    }

    fun remove(function: ChordNoteFunction): ChordNotes {
        return ChordNotes(notes.filter { it.function != function }.toTypedArray())
    }

    fun rotate(): ChordNotes {
        return ChordNotes(notes.rotate(1))
    }

    fun drop2(): ChordNotes? {
        if (notes().size != 4) {
            return null
        }

        return ChordNotes(notes.moveElement(1, 2).rotate(1))
    }

    fun drop3(): ChordNotes? {
        return drop2()?.drop2()
    }
}