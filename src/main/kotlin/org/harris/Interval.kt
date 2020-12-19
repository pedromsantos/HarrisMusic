package org.harris

enum class Interval(
    private val intervalName: String,
    private val abreviature: String,
    private val distance: Int
) {
    Unison("Unisson", "U", 0),
    AugmentedUnison("AugmentedUnison", "A1", 1),
    MinorSecond("MinorSecond", "m2", 1),
    MajorSecond("MajorSecond", "M2", 2),
    AugmentedSecond("AugmentedSecond", "A2", 3),
    MinorThird("MinorThird", "m3", 3),
    MajorThird("MajorThird", "M3", 4),
    PerfectFourth("PerfectFourth", "P4", 5),
    AugmentedFourth("AugmentedFourth", "A4", 6),
    DiminishedFifth("DiminishedFifth", "d5", 6),
    Tritone("DiminishedFifth", "d5", 6),
    PerfectFifth("PerfectFifth", "P5", 7),
    AugmentedFifth("AugmentedFifth", "A5", 8),
    MinorSixth("MinorSixth", "m6", 8),
    MajorSixth("MajorSixth", "M6", 9),
    DiminishedSeventh("DiminishedSeventh", "d7", 9),
    MinorSeventh("MinorSeventh", "m7", 10),
    MajorSeventh("MajorSeventh", "M7", 11),
    PerfectOctave("PerfectOctave", "PO", 12),
    MinorNinth("MinorNinth", "m9", 13),
    MajorNinth("MajorNinth", "M9", 14),
    AugmentedNinth("AugmentedNinth", "A9", 15),
    PerfectEleventh("PerfectEleventh", "P11", 17),
    AugmentedEleventh("AugmentedEleventh", "A11", 18),
    MinorThirteenth("MinorThirteenth", "m13", 20),
    MajorThirteenth("MajorThirteenth", "M13", 21);
}