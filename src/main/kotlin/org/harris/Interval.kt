package org.harris

import org.harris.Note.*

enum class Interval(private val intervalName: String, private val abreviature: String, private val distance: Int, private val naturalDistance: Int, private val transposeValue: Int) {
    Unison("Unisson", "U", 0, C.naturalDistance(C), 0),
    AugmentedUnison("AugmentedUnison", "A1", 1, C.naturalDistance(CSharp), 1),
    MinorSecond("MinorSecond", "m2", 1, C.naturalDistance(DFlat), 2),
    MajorSecond("MajorSecond", "M2", 2, C.naturalDistance(D), 3),
    AugmentedSecond("AugmentedSecond", "A2", 3, C.naturalDistance(DSharp),4),
    MinorThird("MinorThird", "m3", 3, C.naturalDistance(EFlat), 5),
    MajorThird("MajorThird", "M3", 4, C.naturalDistance(E), 6),
    PerfectFourth("PerfectFourth", "P4", 5, C.naturalDistance(F), 7),
    AugmentedFourth("AugmentedFourth", "A4", 6, C.naturalDistance(FSharp), 8),
    DiminishedFifth("DiminishedFifth", "d5", 6, C.naturalDistance(GFlat), 9),
    Tritone("DiminishedFifth", "d5", 6, C.naturalDistance(GFlat), 9),
    PerfectFifth("PerfectFifth", "P5", 7, C.naturalDistance(G), 10),
    AugmentedFifth("AugmentedFifth", "A5", 8, C.naturalDistance(GSharp), 11),
    MinorSixth("MinorSixth", "m6", 8, C.naturalDistance(AFlat), 12),
    MajorSixth("MajorSixth", "M6", 9, C.naturalDistance(A), 13),
    DiminishedSeventh("DiminishedSeventh", "d7", 9, C.naturalDistance(A), 13),
    MinorSeventh("MinorSeventh", "m7", 10, C.naturalDistance(BFlat), 15),
    MajorSeventh("MajorSeventh", "M7", 11, C.naturalDistance(B), 16),
    PerfectOctave("PerfectOctave", "PO", 12, C.naturalDistance(C), 17),
    MinorNinth("MinorNinth", "m9", 13, C.naturalDistance(DFlat), 19),
    MajorNinth("MajorNinth", "M9", 14, C.naturalDistance(D), 20),
    AugmentedNinth("AugmentedNinth", "A9", 15, C.naturalDistance(DSharp), 21),
    PerfectEleventh("PerfectEleventh", "P11", 17, C.naturalDistance(F), 24),
    AugmentedEleventh("AugmentedEleventh", "A11", 18, C.naturalDistance(FSharp), 25),
    MinorThirteenth("MinorThirteenth", "m13", 20, C.naturalDistance(AFlat), 29),
    MajorThirteenth("MajorThirteenth", "M13", 21, C.naturalDistance(A), 30);

    fun hasSameNaturalDistance(otherNaturalDistance: Int) =  naturalDistance == otherNaturalDistance

    fun transpose(from: Note) : Note {
        return from.transpose(this.transposeValue)
    }

    companion object {
        fun from(distance: Int): List<Interval> {
            return values().filter { it.distance == distance }
        }
    }
}