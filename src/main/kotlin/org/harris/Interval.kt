package org.harris

import org.harris.Note.*

enum class Interval(private val intervalName: String, private val abreviature: String, private val distance: Int, private val naturalDistance: Int) {
    Unison("Unisson", "U", 0, C.naturalDistance(C)),
    AugmentedUnison("AugmentedUnison", "A1", 1, C.naturalDistance(CSharp)),
    MinorSecond("MinorSecond", "m2", 1, C.naturalDistance(DFlat)),
    MajorSecond("MajorSecond", "M2", 2, C.naturalDistance(D)),
    AugmentedSecond("AugmentedSecond", "A2", 3, C.naturalDistance(DSharp)),
    MinorThird("MinorThird", "m3", 3, C.naturalDistance(EFlat)),
    MajorThird("MajorThird", "M3", 4, C.naturalDistance(E)),
    PerfectFourth("PerfectFourth", "P4", 5, C.naturalDistance(F)),
    AugmentedFourth("AugmentedFourth", "A4", 6, C.naturalDistance(FSharp)),
    DiminishedFifth("DiminishedFifth", "d5", 6, C.naturalDistance(GFlat)),
    Tritone("DiminishedFifth", "d5", 6, C.naturalDistance(GFlat)),
    PerfectFifth("PerfectFifth", "P5", 7, C.naturalDistance(G)),
    AugmentedFifth("AugmentedFifth", "A5", 8, C.naturalDistance(GSharp)),
    MinorSixth("MinorSixth", "m6", 8, C.naturalDistance(AFlat)),
    MajorSixth("MajorSixth", "M6", 9, C.naturalDistance(A)),
    DiminishedSeventh("DiminishedSeventh", "d7", 9, C.naturalDistance(A)),
    MinorSeventh("MinorSeventh", "m7", 10, C.naturalDistance(BFlat)),
    MajorSeventh("MajorSeventh", "M7", 11, C.naturalDistance(B)),
    PerfectOctave("PerfectOctave", "PO", 12, C.naturalDistance(C)),
    MinorNinth("MinorNinth", "m9", 13, C.naturalDistance(DFlat)),
    MajorNinth("MajorNinth", "M9", 14, C.naturalDistance(D)),
    AugmentedNinth("AugmentedNinth", "A9", 15, C.naturalDistance(DSharp)),
    PerfectEleventh("PerfectEleventh", "P11", 17, C.naturalDistance(F)),
    AugmentedEleventh("AugmentedEleventh", "A11", 18, C.naturalDistance(FSharp)),
    MinorThirteenth("MinorThirteenth", "m13", 20, C.naturalDistance(AFlat)),
    MajorThirteenth("MajorThirteenth", "M13", 21, C.naturalDistance(A));

    fun naturalDistance() =  naturalDistance

    fun transpose(from: Note) : Note {
        return when (this) {
            MinorSecond,
            MajorSecond,
            AugmentedSecond -> from.transpose(this.distance + 1)
            PerfectFourth,
            AugmentedFourth,
            MajorThird,
            MinorThird -> from.transpose(this.distance + 2)
            AugmentedFifth,
            PerfectFifth,
            Tritone,
            DiminishedFifth -> from.transpose(this.distance + 3)
            MajorSixth,
            MinorSixth -> from.transpose(this.distance + 4)
            AugmentedNinth,
            PerfectEleventh,
            AugmentedEleventh,
            MajorThirteenth,
            MinorNinth,
            MajorNinth,
            MinorThirteenth,
            DiminishedSeventh,
            MajorSeventh,
            MinorSeventh -> from.transpose(this.distance + 5)
            else -> from.transpose(this.distance)
        }
    }

    companion object {
        fun from(distance: Int): List<Interval> {
            return values().filter { it.distance == distance }
        }
    }
}