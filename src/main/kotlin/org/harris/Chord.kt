package org.harris

interface Chord {
    fun pitches(): Array<Pitch>
    fun bass(): Pitch
    fun lead(): Pitch
    fun name(): String
    fun pitchForFunction(function: ChordFunction): Pitch
    fun remove(function: ChordFunction): Chord
    fun invert(): Chord
    fun drop2(): Chord
    fun drop3(): Chord
    fun closed(): Chord
}

abstract class BaseChord : Chord {
    protected val pattern: ChordPattern
    protected val pitches: ChordPitches
    protected val root: ChordPitch

    protected constructor(root: Pitch, pattern: ChordPattern) {
        this.pattern = pattern
        this.pitches = ChordPitches(root, pattern)
        this.root = ChordPitch(root, ChordFunction.Root)
    }

    protected constructor(root: ChordPitch, pattern: ChordPattern, notes: ChordPitches) {
        this.pattern = pattern
        this.pitches = notes
        this.root = root
    }

    override fun pitches(): Array<Pitch> = pitches.notes()

    override fun bass(): Pitch {
        return pitches.bass().pitch
    }

    override fun lead(): Pitch {
        return pitches.lead().pitch
    }

    override fun name(): String {
        return root.pitch.name + pattern.name
    }

    override fun pitchForFunction(function: ChordFunction) : Pitch {
        return pitches.pitchForFunction(function).pitch
    }

    override fun drop2(): Chord {
        if (pitches().size == 4) {
            pitches.drop2()?.let {
                return Drop2Chord(root, pattern, it)
            }
        }

        return this
    }

    override fun drop3(): Chord {
        pitches.drop3()?.let {
            return Drop3Chord(root, pattern, it)
        }

        return this
    }

    override fun closed(): Chord {
        return ClosedChord(root.pitch, pattern)
    }

    abstract override fun remove(function: ChordFunction): Chord
    abstract override fun invert(): Chord
}

class ClosedChord : BaseChord {

    constructor(root: Pitch, pattern: ChordPattern)
        :super(root, pattern) {}

    internal constructor(root: ChordPitch, pattern: ChordPattern, notes: ChordPitches)
        :super(root, pattern, notes) {}

    override fun remove(function: ChordFunction): Chord {
        return ClosedChord(root, pattern, pitches.remove(function))
    }

    override fun invert(): Chord {
        return ClosedChord(root, pattern, pitches.rotate())
    }

    override fun closed(): Chord {
        return this
    }
}

class Drop2Chord internal constructor(root: ChordPitch, pattern: ChordPattern, notes: ChordPitches) :
    BaseChord(root, pattern, notes) {

    override fun remove(function: ChordFunction): Chord {
        return Drop2Chord(root, pattern, pitches.remove(function))
    }

    override fun invert(): Chord {
        val invertedNotes = pitches
            .rotate(3)
            .rotateLastSkipFirst()
            .rotateLastSkipFirst()

        return Drop2Chord(root, pattern, invertedNotes)
    }

    override fun drop2(): Chord {
        return this
    }
}

class Drop3Chord internal constructor(root: ChordPitch, pattern: ChordPattern, notes: ChordPitches) :
    BaseChord(root, pattern, notes) {

    override fun remove(function: ChordFunction): Chord {
        return Drop3Chord(root, pattern, pitches.remove(function))
    }

    override fun invert(): Chord {
        val invertedNotes = pitches
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