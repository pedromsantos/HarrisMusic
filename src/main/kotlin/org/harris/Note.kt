package org.harris

import org.harris.Accidental.*
import org.harris.Interval.*

enum class Note {
    C("C", 0, Natural) {
        override fun sharp(): Note = CSharp
        override fun flat(): Note = B
        override fun natural(): Note = C
        override fun intervals(): Map<Interval, Note> {
            return mapOf(
                Pair(Unison, C),
                Pair(AugmentedUnison, CSharp),
                Pair(MinorSecond, DFlat),
                Pair(MajorSecond, D),
                Pair(MinorThird, EFlat),
                Pair(AugmentedSecond, DSharp),
                Pair(MajorThird, E),
                Pair(PerfectFourth, F),
                Pair(AugmentedFourth, FSharp),
                Pair(DiminishedFifth, GFlat),
                Pair(Tritone, GFlat),
                Pair(PerfectFifth, G),
                Pair(AugmentedFifth, GSharp),
                Pair(MinorSixth, AFlat),
                Pair(MajorSixth, A),
                Pair(DiminishedSeventh, A),
                Pair(MinorSeventh, BFlat),
                Pair(MajorSeventh, B),
                Pair(PerfectOctave, C),
                Pair(MinorNinth, DFlat),
                Pair(MajorNinth, D),
                Pair(AugmentedNinth, DSharp),
                Pair(PerfectEleventh, F),
                Pair(AugmentedEleventh, FSharp),
                Pair(MinorThirteenth, AFlat),
                Pair(MajorThirteenth, A)
            )
        }
    },
    CSharp("C#", 1, Sharp) {
        override fun sharp(): Note = D
        override fun flat(): Note = C
        override fun natural(): Note = C
        override fun intervals(): Map<Interval, Note> {
             return C.intervals().map { p -> Pair(p.key, p.value.sharp()) }.toMap()
        }
    },
    DFlat("Db", 1, Flat) {
        override fun sharp(): Note = D
        override fun flat(): Note = C
        override fun natural(): Note = D
        override fun intervals(): Map<Interval, Note> {
            return mapOf(
                return D.intervals().map { p -> Pair(p.key, p.value.flat()) }.toMap()
            )
        }
    },
    D("D", 2, Natural) {
        override fun sharp(): Note = DSharp
        override fun flat(): Note = DFlat
        override fun natural(): Note = D
        override fun intervals(): Map<Interval, Note> {
            return mapOf(
                    Pair(Unison, D),
                    Pair(AugmentedUnison, DSharp),
                    Pair(MinorSecond, EFlat),
                    Pair(MajorSecond, E),
                    Pair(MinorThird, F),
                    Pair(AugmentedSecond, ESharp),
                    Pair(MajorThird, FSharp),
                    Pair(PerfectFourth, G),
                    Pair(AugmentedFourth, GSharp),
                    Pair(DiminishedFifth, AFlat),
                    Pair(Tritone, AFlat),
                    Pair(PerfectFifth, A),
                    Pair(AugmentedFifth, ASharp),
                    Pair(MinorSixth, BFlat),
                    Pair(MajorSixth, B),
                    Pair(DiminishedSeventh, B),
                    Pair(MinorSeventh, C),
                    Pair(MajorSeventh, CSharp),
                    Pair(PerfectOctave, D),
                    Pair(MinorNinth, EFlat),
                    Pair(MajorNinth, E),
                    Pair(AugmentedNinth, ESharp),
                    Pair(PerfectEleventh, G),
                    Pair(AugmentedEleventh, GSharp),
                    Pair(MinorThirteenth, BFlat),
                    Pair(MajorThirteenth, B)
                )
        }
    },
    DSharp("D#", 3, Sharp) {
        override fun sharp(): Note = E
        override fun flat(): Note = D
        override fun natural(): Note = D
        override fun intervals(): Map<Interval, Note> {
            return mapOf(
                return D.intervals().map { p -> Pair(p.key, p.value.sharp()) }.toMap()
            )
        }
    },
    EFlat("Eb", 3, Flat) {
        override fun sharp(): Note = E
        override fun flat(): Note = D
        override fun natural(): Note = E
        override fun intervals(): Map<Interval, Note> {
            return mapOf(
                return E.intervals().map { p -> Pair(p.key, p.value.flat()) }.toMap()
            )
        }
    },
    E("E", 4, Natural) {
        override fun sharp(): Note = F
        override fun flat(): Note = EFlat
        override fun natural(): Note = E
        override fun intervals(): Map<Interval, Note> {
            return mapOf(
                Pair(Unison, E),
                Pair(AugmentedUnison, ESharp),
                Pair(MinorSecond, F),
                Pair(MajorSecond, FSharp),
                Pair(MinorThird, G),
                Pair(AugmentedSecond, G),
                Pair(MajorThird, GSharp),
                Pair(PerfectFourth, A),
                Pair(AugmentedFourth, ASharp),
                Pair(DiminishedFifth, BFlat),
                Pair(Tritone, BFlat),
                Pair(PerfectFifth, B),
                Pair(AugmentedFifth, BSharp),
                Pair(MinorSixth, C),
                Pair(MajorSixth, CSharp),
                Pair(DiminishedSeventh, CSharp),
                Pair(MinorSeventh, D),
                Pair(MajorSeventh, DSharp),
                Pair(PerfectOctave, E),
                Pair(MinorNinth, F),
                Pair(MajorNinth, FSharp),
                Pair(AugmentedNinth, G),
                Pair(PerfectEleventh, A),
                Pair(AugmentedEleventh, ASharp),
                Pair(MinorThirteenth, C),
                Pair(MajorThirteenth, CSharp)
            )
        }
    },
    F("F", 5, Natural) {
        override fun sharp(): Note = FSharp
        override fun flat(): Note = E
        override fun natural(): Note = F
        override fun intervals(): Map<Interval, Note> {
            return mapOf(
                Pair(Unison, F),
                Pair(AugmentedUnison, FSharp),
                Pair(MinorSecond, GFlat),
                Pair(MajorSecond, G),
                Pair(MinorThird, AFlat),
                Pair(AugmentedSecond, GSharp),
                Pair(MajorThird, A),
                Pair(PerfectFourth, BFlat),
                Pair(AugmentedFourth, B),
                Pair(DiminishedFifth, CFlat),
                Pair(Tritone, CFlat),
                Pair(PerfectFifth, C),
                Pair(AugmentedFifth, CSharp),
                Pair(MinorSixth, DFlat),
                Pair(MajorSixth, D),
                Pair(DiminishedSeventh, D),
                Pair(MinorSeventh, EFlat),
                Pair(MajorSeventh, E),
                Pair(PerfectOctave, F),
                Pair(MinorNinth, GFlat),
                Pair(MajorNinth, G),
                Pair(AugmentedNinth, GSharp),
                Pair(PerfectEleventh, BFlat),
                Pair(AugmentedEleventh, B),
                Pair(MinorThirteenth, DFlat),
                Pair(MajorThirteenth, D)
            )
        }
    },
    ESharp("E#", 5, Sharp) {
        override fun sharp(): Note = F
        override fun flat(): Note = E
        override fun natural(): Note = E
        override fun intervals(): Map<Interval, Note> {
            return mapOf(
                Pair(Unison, ESharp)
            )
        }
    },
    FSharp("F#", 6, Sharp) {
        override fun sharp(): Note = G
        override fun flat(): Note = F
        override fun natural(): Note = F
        override fun intervals(): Map<Interval, Note> {
            return mapOf(
                return F.intervals().map { p -> Pair(p.key, p.value.sharp()) }.toMap()
            )
        }
    },
    GFlat("Gb", 6, Flat) {
        override fun sharp(): Note = G
        override fun flat(): Note = F
        override fun natural(): Note = G
        override fun intervals(): Map<Interval, Note> {
            return mapOf(
                return G.intervals().map { p -> Pair(p.key, p.value.flat()) }.toMap()
            )
        }
    },
    G("G", 7, Natural) {
        override fun sharp(): Note = GSharp
        override fun flat(): Note = GFlat
        override fun natural(): Note = G
        override fun intervals(): Map<Interval, Note> {
                return mapOf(
                    Pair(Unison, G),
                    Pair(AugmentedUnison, GSharp),
                    Pair(MinorSecond, AFlat),
                    Pair(MajorSecond, A),
                    Pair(MinorThird, BFlat),
                    Pair(AugmentedSecond, ASharp),
                    Pair(MajorThird, B),
                    Pair(PerfectFourth, C),
                    Pair(AugmentedFourth, CSharp),
                    Pair(DiminishedFifth, DFlat),
                    Pair(Tritone, DFlat),
                    Pair(PerfectFifth, D),
                    Pair(AugmentedFifth, DSharp),
                    Pair(MinorSixth, EFlat),
                    Pair(MajorSixth, E),
                    Pair(DiminishedSeventh, E),
                    Pair(MinorSeventh, F),
                    Pair(MajorSeventh, FSharp),
                    Pair(PerfectOctave, G),
                    Pair(MinorNinth, AFlat),
                    Pair(MajorNinth, A),
                    Pair(AugmentedNinth, ASharp),
                    Pair(PerfectEleventh, C),
                    Pair(AugmentedEleventh, CSharp),
                    Pair(MinorThirteenth, EFlat),
                    Pair(MajorThirteenth, E)
                )
        }
    },
    GSharp("G#", 8, Sharp) {
        override fun sharp(): Note = A
        override fun flat(): Note = G
        override fun natural(): Note = G
        override fun intervals(): Map<Interval, Note> {
            return mapOf(
                return G.intervals().map { p -> Pair(p.key, p.value.sharp()) }.toMap()
            )
        }
    },
    AFlat("Ab", 8, Flat) {
        override fun sharp(): Note = A
        override fun flat(): Note = G
        override fun natural(): Note = A
        override fun intervals(): Map<Interval, Note> {
            return mapOf(
                return A.intervals().map { p -> Pair(p.key, p.value.flat()) }.toMap()
            )
        }
    },
    A("A", 9, Natural) {
        override fun sharp(): Note = ASharp
        override fun flat(): Note = AFlat
        override fun natural(): Note = A
        override fun intervals(): Map<Interval, Note> {
            return mapOf(
                    Pair(Unison, A),
                    Pair(AugmentedUnison, ASharp),
                    Pair(MinorSecond, BFlat),
                    Pair(MajorSecond, B),
                    Pair(MinorThird, C),
                    Pair(AugmentedSecond, BSharp),
                    Pair(MajorThird, CSharp),
                    Pair(PerfectFourth, D),
                    Pair(AugmentedFourth, DSharp),
                    Pair(DiminishedFifth, EFlat),
                    Pair(Tritone, EFlat),
                    Pair(PerfectFifth, E),
                    Pair(AugmentedFifth, ESharp),
                    Pair(MinorSixth, F),
                    Pair(MajorSixth, FSharp),
                    Pair(DiminishedSeventh, FSharp),
                    Pair(MinorSeventh, G),
                    Pair(MajorSeventh, GSharp),
                    Pair(PerfectOctave, A),
                    Pair(MinorNinth, BFlat),
                    Pair(MajorNinth, B),
                    Pair(AugmentedNinth, BSharp),
                    Pair(PerfectEleventh, D),
                    Pair(AugmentedEleventh, DSharp),
                    Pair(MinorThirteenth, F),
                    Pair(MajorThirteenth, FSharp)
                )
        }
    },
    ASharp("A#", 10, Sharp) {
        override fun sharp(): Note = B
        override fun flat(): Note = A
        override fun natural(): Note = A
        override fun intervals(): Map<Interval, Note> {
            return mapOf(
                return C.intervals().map { p -> Pair(p.key, p.value.sharp()) }.toMap()
            )
        }
    },
    BFlat("Bb", 10, Flat) {
        override fun sharp(): Note = B
        override fun flat(): Note = A
        override fun natural(): Note = B
        override fun intervals(): Map<Interval, Note> {
            return mapOf(
                return B.intervals().map { p -> Pair(p.key, p.value.flat()) }.toMap()
            )
        }
    },
    B("B", 11, Natural) {
        override fun sharp(): Note = C
        override fun flat(): Note = BFlat
        override fun natural(): Note = B
        override fun intervals(): Map<Interval, Note> {
            return mapOf(
                Pair(Unison, B),
                Pair(AugmentedUnison, BSharp),
                Pair(MinorSecond, C),
                Pair(MajorSecond, CSharp),
                Pair(MinorThird, D),
                Pair(AugmentedSecond, D),
                Pair(MajorThird, DSharp),
                Pair(PerfectFourth, E),
                Pair(AugmentedFourth, ESharp),
                Pair(DiminishedFifth, F),
                Pair(Tritone, F),
                Pair(PerfectFifth, FSharp),
                Pair(AugmentedFifth, FSharp),
                Pair(MinorSixth, G),
                Pair(MajorSixth, GSharp),
                Pair(DiminishedSeventh, GSharp),
                Pair(MinorSeventh, A),
                Pair(MajorSeventh, ASharp),
                Pair(PerfectOctave, B),
                Pair(MinorNinth, C),
                Pair(MajorNinth, CSharp),
                Pair(AugmentedNinth, CSharp),
                Pair(PerfectEleventh, E),
                Pair(AugmentedEleventh, ESharp),
                Pair(MinorThirteenth, G),
                Pair(MajorThirteenth, GSharp)
            )
        }
    },
    BSharp("B#", 0, Sharp) {
        override fun sharp(): Note = C
        override fun flat(): Note = B
        override fun natural(): Note = B
        override fun intervals(): Map<Interval, Note> {
            return mapOf(
                Pair(Unison, BSharp)
            )
        }
    },
    CFlat("Cb", 11, Sharp) {
        override fun sharp(): Note = C
        override fun flat(): Note = B
        override fun natural(): Note = C
        override fun intervals(): Map<Interval, Note> {
            return mapOf(
                Pair(Unison, CFlat)
            )
        }
    };

    private val pitch: Int
    private val noteName: String
    private val accidental: Accidental

    constructor(noteName: String, pitch: Int, accidental: Accidental) {
        this.noteName = noteName
        this.pitch = pitch
        this.accidental = accidental
    }

    fun pitch() = pitch

    fun absoluteDistance(to: Note): Int {
        if(this.pitch <= to.pitch)
            return to.pitch - this.pitch

        return 12 + (to.pitch - this.pitch)
    }

    fun transpose(interval: Interval): Note {
        return intervals()[interval] ?: error("Interval not found")
    }

    fun intervalBetween(to: Note): Interval {
        return intervals().filter { p -> p.value == to }.keys.first()
    }

    abstract fun sharp(): Note
    abstract fun flat(): Note
    abstract fun natural(): Note
    internal abstract fun intervals() : Map<Interval, Note>
}