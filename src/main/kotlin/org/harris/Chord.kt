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
    private val root: ChordNote

    constructor(root: Note, pattern: ChordPattern) {
        this.root = ChordNote(root, ChordNoteFunction.Root)
        this.notes = pattern.notes(root)
    }

    fun notes(): Array<Note> = notes.map { it.note }.toTypedArray()

    fun bass(): ChordNote {
        return notes.first()
    }

    fun lead(): ChordNote {
        return notes.last()
    }

    fun rootName() : String {
        return root.note.name
    }

    fun noteForFunction(function: ChordNoteFunction) : ChordNote {
        return notes.first { it.function == function }
    }
}

class Chord {
    private val pattern: ChordPattern
    private val notes: ChordNotes

    constructor(pattern: ChordPattern, root: Note) {
        this.pattern = pattern
        this.notes = ChordNotes(root, pattern)
    }

    fun notes(): Array<Note> = notes.notes()

    fun bass(): Note {
        return notes.bass().note
    }

    fun lead(): Note {
        return notes.lead().note
    }

    fun name(): String {
        return notes.rootName() + pattern.name
    }

    fun noteForFunction(function: ChordNoteFunction) : Note {
        return notes.noteForFunction(function).note
    }
}