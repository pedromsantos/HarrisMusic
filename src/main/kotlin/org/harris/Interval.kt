package org.harris

import org.harris.Note.*

enum class Interval(private val intervalName: String, private val abreviature: String, private val distance: Int, private val naturalDistance: Int, private val transposeValue: Int) {
    Unison("Unisson", "U", 0, C.semitoneDistance(C), 0),
    AugmentedUnison("AugmentedUnison", "A1", 1, C.semitoneDistance(CSharp), 1),
    MinorSecond("MinorSecond", "m2", 1, C.semitoneDistance(DFlat), 2),
    MajorSecond("MajorSecond", "M2", 2, C.semitoneDistance(D), 3),
    AugmentedSecond("AugmentedSecond", "A2", 3, C.semitoneDistance(DSharp),4),
    MinorThird("MinorThird", "m3", 3, C.semitoneDistance(EFlat), 5),
    MajorThird("MajorThird", "M3", 4, C.semitoneDistance(E), 6),
    PerfectFourth("PerfectFourth", "P4", 5, C.semitoneDistance(F), 7),
    AugmentedFourth("AugmentedFourth", "A4", 6, C.semitoneDistance(FSharp), 8),
    DiminishedFifth("DiminishedFifth", "d5", 6, C.semitoneDistance(GFlat), 9),
    Tritone("DiminishedFifth", "d5", 6, C.semitoneDistance(GFlat), 9),
    PerfectFifth("PerfectFifth", "P5", 7, C.semitoneDistance(G), 10),
    AugmentedFifth("AugmentedFifth", "A5", 8, C.semitoneDistance(GSharp), 11),
    MinorSixth("MinorSixth", "m6", 8, C.semitoneDistance(AFlat), 12),
    MajorSixth("MajorSixth", "M6", 9, C.semitoneDistance(A), 13),
    DiminishedSeventh("DiminishedSeventh", "d7", 9, C.semitoneDistance(A), 13),
    MinorSeventh("MinorSeventh", "m7", 10, C.semitoneDistance(BFlat), 15),
    MajorSeventh("MajorSeventh", "M7", 11, C.semitoneDistance(B), 16),
    PerfectOctave("PerfectOctave", "PO", 12, C.semitoneDistance(C), 17),
    MinorNinth("MinorNinth", "m9", 13, C.semitoneDistance(DFlat), 19),
    MajorNinth("MajorNinth", "M9", 14, C.semitoneDistance(D), 20),
    AugmentedNinth("AugmentedNinth", "A9", 15, C.semitoneDistance(DSharp), 21),
    PerfectEleventh("PerfectEleventh", "P11", 17, C.semitoneDistance(F), 24),
    AugmentedEleventh("AugmentedEleventh", "A11", 18, C.semitoneDistance(FSharp), 25),
    MinorThirteenth("MinorThirteenth", "m13", 20, C.semitoneDistance(AFlat), 29),
    MajorThirteenth("MajorThirteenth", "M13", 21, C.semitoneDistance(A), 30);

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