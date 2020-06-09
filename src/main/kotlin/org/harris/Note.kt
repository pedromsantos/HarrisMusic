package org.harris

import org.harris.Interval.Unison

enum class Note(private val noteName: String, val pitch: Int) {
    C("C", 0) {
        override fun sharp(): Note = CSharp
        override fun flat(): Note = B
        override fun natural(): Note = C
    },
    CSharp("C#", 1) {
        override fun sharp(): Note = D
        override fun flat(): Note = C
        override fun natural(): Note = C
    },
    DFlat("Db", 1) {
        override fun sharp(): Note = D
        override fun flat(): Note = C
        override fun natural(): Note = D
    },
    D("D", 2) {
        override fun sharp(): Note = DSharp
        override fun flat(): Note = DFlat
        override fun natural(): Note = D
    },
    DSharp("D#", 3) {
        override fun sharp(): Note = E
        override fun flat(): Note = D
        override fun natural(): Note = D
    },
    EFlat("Eb", 3) {
        override fun sharp(): Note = E
        override fun flat(): Note = D
        override fun natural(): Note = E
    },
    E("E", 4) {
        override fun sharp(): Note = F
        override fun flat(): Note = EFlat
        override fun natural(): Note = E
    },
    F("F", 5) {
        override fun sharp(): Note = FSharp
        override fun flat(): Note = E
        override fun natural(): Note = F
    },
    FSharp("F#", 6) {
        override fun sharp(): Note = G
        override fun flat(): Note = F
        override fun natural(): Note = F
    },
    GFlat("Gb", 6) {
        override fun sharp(): Note = G
        override fun flat(): Note = F
        override fun natural(): Note = G
    },
    G("G", 7) {
        override fun sharp(): Note = GSharp
        override fun flat(): Note = GFlat
        override fun natural(): Note = G
    },
    GSharp("G#", 8) {
        override fun sharp(): Note = A
        override fun flat(): Note = G
        override fun natural(): Note = G
    },
    AFlat("Ab", 8) {
        override fun sharp(): Note = A
        override fun flat(): Note = G
        override fun natural(): Note = A
    },
    A("A", 9) {
        override fun sharp(): Note = ASharp
        override fun flat(): Note = AFlat
        override fun natural(): Note = A
    },
    ASharp("A#", 10) {
        override fun sharp(): Note = B
        override fun flat(): Note = A
        override fun natural(): Note = A
    },
    BFlat("Bb", 10) {
        override fun sharp(): Note = B
        override fun flat(): Note = A
        override fun natural(): Note = B
    },
    B("B", 11) {
        override fun sharp(): Note = C
        override fun flat(): Note = BFlat
        override fun natural(): Note = B
    };

    fun measureAbsoluteSemitones(to: Note): Int {
        return to.pitch - this.pitch
    }

    fun transpose(interval: Interval): Note {
        return when (interval) {
            Unison -> this
            else -> this
        }
    }

    fun naturalDistance(to: Note) : Int {
        if (this.natural().ordinal == to.natural().ordinal) {
            return 0
        }

        if (this.natural().pitch < to.natural().pitch) {
            return to.natural().pitch - this.natural().pitch
        }

        return this.natural().pitch - to.natural().pitch
    }

    fun intervalBetween(to: Note): Interval {
        val intervals = Interval.from(measureAbsoluteSemitones(to))
        val naturalDistance = naturalDistance(to)

        if (intervals.size == 1 || naturalDistance == 0) {
            return intervals.first()
        }

        return intervals.first{ it.naturalDistance() == naturalDistance }
    }

    abstract fun sharp(): Note
    abstract fun flat(): Note
    abstract fun natural(): Note
}