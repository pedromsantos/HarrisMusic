package org.harris

import org.harris.Interval.*

enum class ChordNoteFunction {
    Root,
    Third,
    Fifth,
    Sixth,
    Seventh,
    Ninth,
    Eleventh,
    Thirteenth;

    companion object {
        internal fun functionForInterval(interval: Interval): ChordNoteFunction {
            return when (interval) {
                Unison -> Root
                MajorThird,
                MinorThird,
                MajorSecond,
                MinorSecond,
                PerfectFourth,
                AugmentedFourth -> Third
                PerfectFifth,
                DiminishedFifth,
                AugmentedFifth -> Fifth
                MinorSixth,
                MajorSixth -> Sixth
                MajorSeventh,
                MinorSeventh,
                DiminishedSeventh -> Seventh
                MajorNinth,
                MinorNinth,
                AugmentedNinth -> Ninth
                PerfectEleventh,
                AugmentedEleventh -> Eleventh
                MajorThirteenth -> Thirteenth
                else -> Root
            }
        }
    }
}

internal data class ChordNote(val note: Note, val function: ChordNoteFunction)

internal class ChordNotes {
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

    fun noteForFunction(function: ChordNoteFunction) : ChordNote {
        return notes.first { it.function == function }
    }

    fun remove(function: ChordNoteFunction): ChordNotes {
        return ChordNotes(notes.filter { it.function != function }.toTypedArray())
    }

    fun rotate(): ChordNotes {
        return ChordNotes(notes.rotate(1))
    }
}

class Chord {
    private val pattern: ChordPattern
    private val notes: ChordNotes
    private val root: ChordNote

    constructor(root: Note, pattern: ChordPattern) {
        this.pattern = pattern
        this.notes = ChordNotes(root, pattern)
        this.root = ChordNote(root, ChordNoteFunction.Root)
    }

    private constructor(root: ChordNote, pattern: ChordPattern, notes: ChordNotes) {
        this.pattern = pattern
        this.notes = notes
        this.root = root
    }

    fun notes(): Array<Note> = notes.notes()

    fun bass(): Note {
        return notes.bass().note
    }

    fun lead(): Note {
        return notes.lead().note
    }

    fun name(): String {
        return root.note.name + pattern.name
    }

    fun noteForFunction(function: ChordNoteFunction) : Note {
        return notes.noteForFunction(function).note
    }

    fun remove(function: ChordNoteFunction): Chord {
        return Chord(root, pattern, notes.remove(function))
    }

    fun invert(): Chord {
        return Chord(root, pattern, notes.rotate())
    }
}