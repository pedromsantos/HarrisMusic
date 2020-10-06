package org.harris

import org.harris.Note.*
import org.harris.Accidental.*

enum class Interval(private val intervalName: String, private val abreviature: String, private val distance: Int, private val naturalDistance: Int, private val transposeValue: Accidental) {
    Unison("Unisson", "U", 0, C.naturalDistance(C), Natural),
    AugmentedUnison("AugmentedUnison", "A1", 1, C.naturalDistance(C), Sharp),
    MinorSecond("MinorSecond", "m2", 1, C.naturalDistance(D), Flat),
    MajorSecond("MajorSecond", "M2", 2, C.naturalDistance(D), Natural),
    AugmentedSecond("AugmentedSecond", "A2", 3, C.naturalDistance(D),Sharp),
    MinorThird("MinorThird", "m3", 3, C.naturalDistance(E), Flat),
    MajorThird("MajorThird", "M3", 4, C.naturalDistance(E), Natural),
    PerfectFourth("PerfectFourth", "P4", 5, C.naturalDistance(F), Natural),
    AugmentedFourth("AugmentedFourth", "A4", 6, C.naturalDistance(F), Sharp),
    DiminishedFifth("DiminishedFifth", "d5", 6, C.naturalDistance(G), Flat),
    Tritone("DiminishedFifth", "d5", 6, C.naturalDistance(G), Flat),
    PerfectFifth("PerfectFifth", "P5", 7, C.naturalDistance(G), Natural),
    AugmentedFifth("AugmentedFifth", "A5", 8, C.naturalDistance(G), Sharp),
    MinorSixth("MinorSixth", "m6", 8, C.naturalDistance(A), Flat),
    MajorSixth("MajorSixth", "M6", 9, C.naturalDistance(A), Natural),
    DiminishedSeventh("DiminishedSeventh", "d7", 9, C.naturalDistance(B), DoubleFlat),
    MinorSeventh("MinorSeventh", "m7", 10, C.naturalDistance(B), Flat),
    MajorSeventh("MajorSeventh", "M7", 11, C.naturalDistance(B), Natural),
    PerfectOctave("PerfectOctave", "PO", 12, C.naturalDistance(C), Natural),
    MinorNinth("MinorNinth", "m9", 13, C.naturalDistance(D), Flat),
    MajorNinth("MajorNinth", "M9", 14, C.naturalDistance(D), Natural),
    AugmentedNinth("AugmentedNinth", "A9", 15, C.naturalDistance(D), Sharp),
    PerfectEleventh("PerfectEleventh", "P11", 17, C.naturalDistance(F), Natural),
    AugmentedEleventh("AugmentedEleventh", "A11", 18, C.naturalDistance(F), Sharp),
    MinorThirteenth("MinorThirteenth", "m13", 20, C.naturalDistance(A), Flat),
    MajorThirteenth("MajorThirteenth", "M13", 21, C.naturalDistance(A), Natural);

    fun hasSameDistance(otherDistance: Int) = distance == otherDistance

    fun transpose(from: Note) : Note {
        val transposed = from.transpose(this.naturalDistance)
        return when(this.transposeValue) {
            DoubleFlat -> transposed.flat().flat()
            Flat -> transposed.flat()
            Sharp -> transposed.sharp()
            Natural -> transposed
        }
    }

    companion object {
        fun from(naturalDistance: Int): List<Interval> {
            return values().filter { it.naturalDistance == naturalDistance }
        }
    }
}