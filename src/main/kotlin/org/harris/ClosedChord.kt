package org.harris

data class ChordNote(val note: Note, val function: ChordNoteFunction)

interface Chord {
    fun notes(): Array<Note>
    fun bass(): Note
    fun lead(): Note
    fun name(): String
    fun noteForFunction(function: ChordNoteFunction): Note
    fun remove(function: ChordNoteFunction): Chord
    fun invert(): Chord
    fun drop2(): Chord
}

abstract class BaseChord : Chord {
    protected val pattern: ChordPattern
    protected val notes: ChordNotes
    protected val root: ChordNote

    protected constructor(root: Note, pattern: ChordPattern) {
        this.pattern = pattern
        this.notes = ChordNotes(root, pattern)
        this.root = ChordNote(root, ChordNoteFunction.Root)
    }

    protected constructor(root: ChordNote, pattern: ChordPattern, notes: ChordNotes) {
        this.pattern = pattern
        this.notes = notes
        this.root = root
    }

    override fun notes(): Array<Note> = notes.notes()

    override fun bass(): Note {
        return notes.bass().note
    }

    override fun lead(): Note {
        return notes.lead().note
    }

    override fun name(): String {
        return root.note.name + pattern.name
    }

    override fun noteForFunction(function: ChordNoteFunction) : Note {
        return notes.noteForFunction(function).note
    }

    abstract override fun remove(function: ChordNoteFunction): Chord

    abstract override fun invert(): Chord

    abstract override fun drop2(): Chord
}

class ClosedChord : BaseChord {

    constructor(root: Note, pattern: ChordPattern)
        :super(root, pattern) {}

    private constructor(root: ChordNote, pattern: ChordPattern, notes: ChordNotes)
        :super(root, pattern, notes) {}

    override fun remove(function: ChordNoteFunction): Chord {
        return ClosedChord(root, pattern, notes.remove(function))
    }

    override fun invert(): Chord {
        return ClosedChord(root, pattern, notes.rotate())
    }

    override fun drop2(): Chord {
        return Drop2Chord(root.note, pattern)
    }
}

class Drop2Chord : BaseChord {

    constructor(root: Note, pattern: ChordPattern)
            :super(root, pattern) {

    }

    private constructor(root: ChordNote, pattern: ChordPattern, notes: ChordNotes)
            :super(root, pattern, notes) {

    }

    override fun remove(function: ChordNoteFunction): Chord {
        return Drop2Chord(root, pattern, notes.remove(function))
    }

    override fun invert(): Chord {
        return Drop2Chord(root, pattern, notes.rotate())
    }

    override fun drop2(): Chord {
        return this
    }
}