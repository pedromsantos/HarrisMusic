package org.harris

import org.harris.Interval.*

enum class Note(private val noteName: String, private val pitch: Int) {
    C("C", 0) {
        override fun sharp(): Note = CSharp
        override fun flat(): Note = B
        override fun natural(): Note = C
        override fun intervals(): Map<Interval, Note> {
            return mapOf(
                Unison to C,
                AugmentedUnison to CSharp,
                MinorSecond to DFlat,
                MajorSecond to D,
                MinorThird to EFlat,
                AugmentedSecond to DSharp,
                MajorThird to E,
                PerfectFourth to F,
                AugmentedFourth to FSharp,
                DiminishedFifth to GFlat,
                Tritone to GFlat,
                PerfectFifth to G,
                AugmentedFifth to GSharp,
                MinorSixth to AFlat,
                MajorSixth to A,
                DiminishedSeventh to A,
                MinorSeventh to BFlat,
                MajorSeventh to B,
                PerfectOctave to C,
                MinorNinth to DFlat,
                MajorNinth to D,
                AugmentedNinth to DSharp,
                PerfectEleventh to F,
                AugmentedEleventh to FSharp,
                MinorThirteenth to AFlat,
                MajorThirteenth to A
            )
        }
    },
    CSharp("C#", 1) {
        override fun sharp(): Note = D
        override fun flat(): Note = C
        override fun natural(): Note = C
        override fun intervals(): Map<Interval, Note> {
             return C.intervals().map { it.key to it.value.sharp() }.toMap()
        }
    },
    DFlat("Db", 1) {
        override fun sharp(): Note = D
        override fun flat(): Note = C
        override fun natural(): Note = D
        override fun intervals(): Map<Interval, Note> {
            return D.intervals().map { it.key to it.value.flat() }.toMap()
        }
    },
    D("D", 2) {
        override fun sharp(): Note = DSharp
        override fun flat(): Note = DFlat
        override fun natural(): Note = D
        override fun intervals(): Map<Interval, Note> {
            return mapOf(
                Unison to D,
                AugmentedUnison to DSharp,
                MinorSecond to EFlat,
                MajorSecond to E,
                MinorThird to F,
                AugmentedSecond to ESharp,
                MajorThird to FSharp,
                PerfectFourth to G,
                AugmentedFourth to GSharp,
                DiminishedFifth to AFlat,
                Tritone to AFlat,
                PerfectFifth to A,
                AugmentedFifth to ASharp,
                MinorSixth to BFlat,
                MajorSixth to B,
                DiminishedSeventh to B,
                MinorSeventh to C,
                MajorSeventh to CSharp,
                PerfectOctave to D,
                MinorNinth to EFlat,
                MajorNinth to E,
                AugmentedNinth to ESharp,
                PerfectEleventh to G,
                AugmentedEleventh to GSharp,
                MinorThirteenth to BFlat,
                MajorThirteenth to B
                )
        }
    },
    DSharp("D#", 3) {
        override fun sharp(): Note = E
        override fun flat(): Note = D
        override fun natural(): Note = D
        override fun intervals(): Map<Interval, Note> {
            return D.intervals().map { it.key to it.value.sharp() }.toMap()
        }
    },
    EFlat("Eb", 3) {
        override fun sharp(): Note = E
        override fun flat(): Note = D
        override fun natural(): Note = E
        override fun intervals(): Map<Interval, Note> {
            return E.intervals().map { it.key to it.value.flat() }.toMap()
        }
    },
    E("E", 4) {
        override fun sharp(): Note = F
        override fun flat(): Note = EFlat
        override fun natural(): Note = E
        override fun intervals(): Map<Interval, Note> {
            return mapOf(
                Unison to E,
                AugmentedUnison to ESharp,
                MinorSecond to F,
                MajorSecond to FSharp,
                MinorThird to G,
                AugmentedSecond to G,
                MajorThird to GSharp,
                PerfectFourth to A,
                AugmentedFourth to ASharp,
                DiminishedFifth to BFlat,
                Tritone to BFlat,
                PerfectFifth to B,
                AugmentedFifth to BSharp,
                MinorSixth to C,
                MajorSixth to CSharp,
                DiminishedSeventh to CSharp,
                MinorSeventh to D,
                MajorSeventh to DSharp,
                PerfectOctave to E,
                MinorNinth to F,
                MajorNinth to FSharp,
                AugmentedNinth to G,
                PerfectEleventh to A,
                AugmentedEleventh to ASharp,
                MinorThirteenth to C,
                MajorThirteenth to CSharp
            )
        }
    },
    F("F", 5) {
        override fun sharp(): Note = FSharp
        override fun flat(): Note = E
        override fun natural(): Note = F
        override fun intervals(): Map<Interval, Note> {
            return mapOf(
                Unison to F,
                AugmentedUnison to FSharp,
                MinorSecond to GFlat,
                MajorSecond to G,
                MinorThird to AFlat,
                AugmentedSecond to GSharp,
                MajorThird to A,
                PerfectFourth to BFlat,
                AugmentedFourth to B,
                DiminishedFifth to CFlat,
                Tritone to CFlat,
                PerfectFifth to C,
                AugmentedFifth to CSharp,
                MinorSixth to DFlat,
                MajorSixth to D,
                DiminishedSeventh to D,
                MinorSeventh to EFlat,
                MajorSeventh to E,
                PerfectOctave to F,
                MinorNinth to GFlat,
                MajorNinth to G,
                AugmentedNinth to GSharp,
                PerfectEleventh to BFlat,
                AugmentedEleventh to B,
                MinorThirteenth to DFlat,
                MajorThirteenth to D
            )
        }
    },
    ESharp("E#", 5) {
        override fun sharp(): Note = F
        override fun flat(): Note = E
        override fun natural(): Note = E
        override fun intervals(): Map<Interval, Note> {
            return F.intervals()
        }
    },
    FSharp("F#", 6) {
        override fun sharp(): Note = G
        override fun flat(): Note = F
        override fun natural(): Note = F
        override fun intervals(): Map<Interval, Note> {
            return F.intervals().map { it.key to it.value.sharp() }.toMap()
        }
    },
    GFlat("Gb", 6) {
        override fun sharp(): Note = G
        override fun flat(): Note = F
        override fun natural(): Note = G
        override fun intervals(): Map<Interval, Note> {
            return G.intervals().map { it.key to it.value.flat() }.toMap()
        }
    },
    G("G", 7) {
        override fun sharp(): Note = GSharp
        override fun flat(): Note = GFlat
        override fun natural(): Note = G
        override fun intervals(): Map<Interval, Note> {
                return mapOf(
                    Unison to G,
                    AugmentedUnison to GSharp,
                    MinorSecond to AFlat,
                    MajorSecond to A,
                    MinorThird to BFlat,
                    AugmentedSecond to ASharp,
                    MajorThird to B,
                    PerfectFourth to C,
                    AugmentedFourth to CSharp,
                    DiminishedFifth to DFlat,
                    Tritone to DFlat,
                    PerfectFifth to D,
                    AugmentedFifth to DSharp,
                    MinorSixth to EFlat,
                    MajorSixth to E,
                    DiminishedSeventh to E,
                    MinorSeventh to F,
                    MajorSeventh to FSharp,
                    PerfectOctave to G,
                    MinorNinth to AFlat,
                    MajorNinth to A,
                    AugmentedNinth to ASharp,
                    PerfectEleventh to C,
                    AugmentedEleventh to CSharp,
                    MinorThirteenth to EFlat,
                    MajorThirteenth to E
                )
        }
    },
    GSharp("G#", 8) {
        override fun sharp(): Note = A
        override fun flat(): Note = G
        override fun natural(): Note = G
        override fun intervals(): Map<Interval, Note> {
            return G.intervals().map { it.key to it.value.sharp() }.toMap()
        }
    },
    AFlat("Ab", 8) {
        override fun sharp(): Note = A
        override fun flat(): Note = G
        override fun natural(): Note = A
        override fun intervals(): Map<Interval, Note> {
            return A.intervals().map { it.key to it.value.flat() }.toMap()
        }
    },
    A("A", 9) {
        override fun sharp(): Note = ASharp
        override fun flat(): Note = AFlat
        override fun natural(): Note = A
        override fun intervals(): Map<Interval, Note> {
            return mapOf(
                    Unison to A,
                    AugmentedUnison to ASharp,
                    MinorSecond to BFlat,
                    MajorSecond to B,
                    MinorThird to C,
                    AugmentedSecond to BSharp,
                    MajorThird to CSharp,
                    PerfectFourth to D,
                    AugmentedFourth to DSharp,
                    DiminishedFifth to EFlat,
                    Tritone to EFlat,
                    PerfectFifth to E,
                    AugmentedFifth to ESharp,
                    MinorSixth to F,
                    MajorSixth to FSharp,
                    DiminishedSeventh to FSharp,
                    MinorSeventh to G,
                    MajorSeventh to GSharp,
                    PerfectOctave to A,
                    MinorNinth to BFlat,
                    MajorNinth to B,
                    AugmentedNinth to BSharp,
                    PerfectEleventh to D,
                    AugmentedEleventh to DSharp,
                    MinorThirteenth to F,
                    MajorThirteenth to FSharp
                )
        }
    },
    ASharp("A#", 10) {
        override fun sharp(): Note = B
        override fun flat(): Note = A
        override fun natural(): Note = A
        override fun intervals(): Map<Interval, Note> {
            return C.intervals().map { it.key to it.value.sharp() }.toMap()
        }
    },
    BFlat("Bb", 10) {
        override fun sharp(): Note = B
        override fun flat(): Note = A
        override fun natural(): Note = B
        override fun intervals(): Map<Interval, Note> {
            return B.intervals().map { it.key to it.value.flat() }.toMap()
        }
    },
    B("B", 11) {
        override fun sharp(): Note = C
        override fun flat(): Note = BFlat
        override fun natural(): Note = B
        override fun intervals(): Map<Interval, Note> {
            return mapOf(
                Unison to B,
                AugmentedUnison to BSharp,
                MinorSecond to C,
                MajorSecond to CSharp,
                MinorThird to D,
                AugmentedSecond to D,
                MajorThird to DSharp,
                PerfectFourth to E,
                AugmentedFourth to ESharp,
                DiminishedFifth to F,
                Tritone to F,
                PerfectFifth to FSharp,
                AugmentedFifth to FSharp,
                MinorSixth to G,
                MajorSixth to GSharp,
                DiminishedSeventh to GSharp,
                MinorSeventh to A,
                MajorSeventh to ASharp,
                PerfectOctave to B,
                MinorNinth to C,
                MajorNinth to CSharp,
                AugmentedNinth to CSharp,
                PerfectEleventh to E,
                AugmentedEleventh to ESharp,
                MinorThirteenth to G,
                MajorThirteenth to GSharp
            )
        }
    },
    BSharp("B#", 0) {
        override fun sharp(): Note = C
        override fun flat(): Note = B
        override fun natural(): Note = B
        override fun intervals(): Map<Interval, Note> {
            return C.intervals()
        }
    },
    CFlat("Cb", 11) {
        override fun sharp(): Note = C
        override fun flat(): Note = B
        override fun natural(): Note = C
        override fun intervals(): Map<Interval, Note> {
            return B.intervals()
        }
    };

    fun pitch() = pitch

    fun equals(other: Note): Boolean {
        return this.pitch == other.pitch
    }

    fun absoluteDistance(to: Note): Int {
        if(this.pitch <= to.pitch)
            return to.pitch - this.pitch

        return 12 + (to.pitch - this.pitch)
    }

    fun transpose(interval: Interval): Note {
        return intervals()[interval] ?: error("Interval '${interval.name}' not found on note '${this.noteName}'")
    }

    fun intervalBetween(to: Note): Interval {
        return intervals().filter { it.value == to }.keys.first()
    }

    abstract fun sharp(): Note
    abstract fun flat(): Note
    abstract fun natural(): Note
    internal abstract fun intervals() : Map<Interval, Note>
}