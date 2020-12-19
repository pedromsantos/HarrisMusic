package org.harris

interface Chord {
    fun notes(): Array<Pitch>
    fun bass(): Pitch
    fun lead(): Pitch
    fun name(): String
    fun noteForFunction(function: ChordNoteFunction): Pitch
    fun remove(function: ChordNoteFunction): Chord
    fun invert(): Chord
    fun drop2(): Chord
    fun drop3(): Chord
    fun closed(): Chord
}

abstract class BaseChord : Chord {
    protected val pattern: ChordPattern
    protected val notes: ChordNotes
    protected val root: ChordNote

    protected constructor(root: Pitch, pattern: ChordPattern) {
        this.pattern = pattern
        this.notes = ChordNotes(root, pattern)
        this.root = ChordNote(root, ChordNoteFunction.Root)
    }

    protected constructor(root: ChordNote, pattern: ChordPattern, notes: ChordNotes) {
        this.pattern = pattern
        this.notes = notes
        this.root = root
    }

    override fun notes(): Array<Pitch> = notes.notes()

    override fun bass(): Pitch {
        return notes.bass().pitch
    }

    override fun lead(): Pitch {
        return notes.lead().pitch
    }

    override fun name(): String {
        return root.pitch.name + pattern.name
    }

    override fun noteForFunction(function: ChordNoteFunction) : Pitch {
        return notes.noteForFunction(function).pitch
    }

    override fun drop2(): Chord {
        if (notes().size == 4) {
            notes.drop2()?.let {
                return Drop2Chord(root, pattern, it)
            }
        }

        return this
    }

    override fun drop3(): Chord {
        notes.drop3()?.let {
            return Drop3Chord(root, pattern, it)
        }

        return this
    }

    override fun closed(): Chord {
        return ClosedChord(root.pitch, pattern)
    }

    abstract override fun remove(function: ChordNoteFunction): Chord
    abstract override fun invert(): Chord
}

class ClosedChord : BaseChord {

    constructor(root: Pitch, pattern: ChordPattern)
        :super(root, pattern) {}

    internal constructor(root: ChordNote, pattern: ChordPattern, notes: ChordNotes)
        :super(root, pattern, notes) {}

    override fun remove(function: ChordNoteFunction): Chord {
        return ClosedChord(root, pattern, notes.remove(function))
    }

    override fun invert(): Chord {
        return ClosedChord(root, pattern, notes.rotate())
    }

    override fun closed(): Chord {
        return this
    }
}

class Drop2Chord : BaseChord {

    internal constructor(root: ChordNote, pattern: ChordPattern, notes: ChordNotes)
            :super(root, pattern, notes) {

    }

    override fun remove(function: ChordNoteFunction): Chord {
        return Drop2Chord(root, pattern, notes.remove(function))
    }

    override fun invert(): Chord {
        val invertedNotes = notes
            .rotate(3)
            .rotateLastSkipFirst()
            .rotateLastSkipFirst()

        return Drop2Chord(root, pattern, invertedNotes)
    }

    override fun drop2(): Chord {
        return this
    }
}

class Drop3Chord : BaseChord {

    internal constructor(root: ChordNote, pattern: ChordPattern, notes: ChordNotes)
            :super(root, pattern, notes) {

    }

    override fun remove(function: ChordNoteFunction): Chord {
        return Drop3Chord(root, pattern, notes.remove(function))
    }

    override fun invert(): Chord {
        val invertedNotes = notes
            .rotate(2)
            .rotateLastSkipFirst(2)
            .rotateLastSkipFirst(1)
            .rotateLastSkipFirst(1)

        return Drop3Chord(root, pattern, invertedNotes)
    }

    override fun drop3(): Chord {
        return this
    }
}