package org.harris

import org.harris.Accidental.*
import kotlin.math.abs

enum class Note {
    C("C", 0, Natural) {
        override fun sharp(): Note = CSharp
        override fun flat(): Note = B
        override fun natural(): Note = C
        override fun index() = 1
    },
    CSharp("C#", 1, Sharp) {
        override fun sharp(): Note = D
        override fun flat(): Note = C
        override fun natural(): Note = C
        override fun index() = 1
    },
    DFlat("Db", 1, Flat) {
        override fun sharp(): Note = D
        override fun flat(): Note = C
        override fun natural(): Note = D
        override fun index() = 2
    },
    D("D", 2, Natural) {
        override fun sharp(): Note = DSharp
        override fun flat(): Note = DFlat
        override fun natural(): Note = D
        override fun index() = 2
    },
    DSharp("D#", 3, Sharp) {
        override fun sharp(): Note = E
        override fun flat(): Note = D
        override fun natural(): Note = D
        override fun index() = 2
    },
    EFlat("Eb", 3, Flat) {
        override fun sharp(): Note = E
        override fun flat(): Note = D
        override fun natural(): Note = E
        override fun index() = 3
    },
    E("E", 4, Natural) {
        override fun sharp(): Note = F
        override fun flat(): Note = EFlat
        override fun natural(): Note = E
        override fun index() = 3
    },
    FFlat("Fb", 4, Flat) {
        override fun sharp(): Note = F
        override fun flat(): Note = E
        override fun natural(): Note = F
        override fun index() = 3
    },
    F("F", 5, Natural) {
        override fun sharp(): Note = FSharp
        override fun flat(): Note = E
        override fun natural(): Note = F
        override fun index() = 4
    },
    ESharp("E#", 5, Sharp) {
        override fun sharp(): Note = F
        override fun flat(): Note = E
        override fun natural(): Note = E
        override fun index() = 3
    },
    FSharp("F#", 6, Sharp) {
        override fun sharp(): Note = G
        override fun flat(): Note = F
        override fun natural(): Note = F
        override fun index() = 4
    },
    GFlat("Gb", 6, Flat) {
        override fun sharp(): Note = G
        override fun flat(): Note = F
        override fun natural(): Note = G
        override fun index() = 5
    },
    G("G", 7, Natural) {
        override fun sharp(): Note = GSharp
        override fun flat(): Note = GFlat
        override fun natural(): Note = G
        override fun index() = 5
    },
    GSharp("G#", 8, Sharp) {
        override fun sharp(): Note = A
        override fun flat(): Note = G
        override fun natural(): Note = G
        override fun index() = 5
    },
    AFlat("Ab", 8, Flat) {
        override fun sharp(): Note = A
        override fun flat(): Note = G
        override fun natural(): Note = A
        override fun index() = 6
    },
    A("A", 9, Natural) {
        override fun sharp(): Note = ASharp
        override fun flat(): Note = AFlat
        override fun natural(): Note = A
        override fun index() = 6
    },
    ASharp("A#", 10, Sharp) {
        override fun sharp(): Note = B
        override fun flat(): Note = A
        override fun natural(): Note = A
        override fun index() = 6
    },
    BFlat("Bb", 10, Flat) {
        override fun sharp(): Note = B
        override fun flat(): Note = A
        override fun natural(): Note = B
        override fun index() = 7
    },
    B("B", 11, Natural) {
        override fun sharp(): Note = C
        override fun flat(): Note = BFlat
        override fun natural(): Note = B
        override fun index() = 7
    },
    BSharp("B#", 0, Sharp) {
        override fun sharp(): Note = C
        override fun flat(): Note = B
        override fun natural(): Note = B
        override fun index() = 7
    },
    CFlat("Cb", 11, Flat) {
        override fun sharp(): Note = C
        override fun flat(): Note = B
        override fun natural(): Note = C
        override fun index() = 1
    },;

    private val pitch: Int
    private val noteName: String
    private val accidental: Accidental

    constructor(noteName: String, pitch: Int, accidental: Accidental) {
        this.noteName = noteName
        this.pitch = pitch
        this.accidental = accidental
    }

    fun pitch() = pitch
    fun accidental() = accidental

    fun absoluteDistance(to: Note): Int {
        if(this.pitch <= to.pitch)
            return to.pitch - this.pitch

        return 12 + (to.pitch - this.pitch)
    }

    fun transpose(interval: Interval): Note {
        return interval.transpose(this)
    }

    fun intervalBetween(to: Note): Interval {
        val intervals = Interval.from(naturalDistance(to))
        return intervals.first { it.hasSameDistance(absoluteDistance(to)) }
    }

    fun naturalDistance(to: Note) : Int {
        val distance = to.index() - this.index()

        if (distance < 0) {
            return abs(7 + distance)
        }

        return distance
    }

    internal fun transpose(absoluteDistance: Int) : List<Note> {
        var distance = (this.pitch() + absoluteDistance) % 12
        return values().filter { it.pitch() == distance }
    }

    abstract fun sharp(): Note
    abstract fun flat(): Note
    abstract fun natural(): Note
    internal abstract fun index() : Int
}