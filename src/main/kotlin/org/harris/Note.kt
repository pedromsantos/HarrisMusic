package org.harris

enum class Note(val noteName: String, val pitch: Int) {
    C("C", 0) {
        override fun sharp(): Note = CSharp
        override fun flat(): Note = B
    },
    CSharp("C#", 1) {
        override fun sharp(): Note = D
        override fun flat(): Note = C
    },
    DFlat("Db", 1) {
        override fun sharp(): Note = D
        override fun flat(): Note = C
    },
    D("D", 2) {
        override fun sharp(): Note = DSharp
        override fun flat(): Note = DFlat
    },
    DSharp("D#", 3) {
        override fun sharp(): Note = E
        override fun flat(): Note = D
    },
    EFlat("Eb", 3) {
        override fun sharp(): Note = E
        override fun flat(): Note = D
    },
    E("E", 4) {
        override fun sharp(): Note = F
        override fun flat(): Note = EFlat
    },
    F("F", 5) {
        override fun sharp(): Note = FSharp
        override fun flat(): Note = E
    },
    FSharp("F#", 6) {
        override fun sharp(): Note = G
        override fun flat(): Note = F
    },
    GFlat("Gb", 6) {
        override fun sharp(): Note = G
        override fun flat(): Note = F
    },
    G("G", 7) {
        override fun sharp(): Note = GSharp
        override fun flat(): Note = GFlat
    },
    GSharp("G#", 8) {
        override fun sharp(): Note = A
        override fun flat(): Note = G
    },
    AFlat("Ab", 8) {
        override fun sharp(): Note = A
        override fun flat(): Note = G
    },
    A("A", 9) {
        override fun sharp(): Note = ASharp
        override fun flat(): Note = AFlat
    },
    ASharp("A#", 10){
        override fun sharp(): Note = B
        override fun flat(): Note = A
    },
    BFlat("Bb", 10) {
        override fun sharp(): Note = B
        override fun flat(): Note = A
    },
    B("B", 11) {
        override fun sharp(): Note = C
        override fun flat(): Note = BFlat
    };

    public fun measureAbsoluteSemitones(to: Note) : Int {
        return to.pitch - this.pitch
    }

    public fun transpose(interval : Interval) : Note {
        return when (interval) {
            Interval.Unisson -> this;
            else -> this
        }
    }

    abstract fun sharp(): Note
    abstract fun flat(): Note
}