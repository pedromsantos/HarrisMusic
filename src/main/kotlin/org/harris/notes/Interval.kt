package org.harris.notes

enum class Interval(
        private val intervalName: String,
        private val abreviature: String,
        private val distance: Int
) {
    Unison("Unisson", "U", 0),
    AugmentedUnison("Augmented Unison", "A1", 1),
    MinorSecond("Minor Second", "m2", 1),
    MajorSecond("Major Second", "M2", 2),
    AugmentedSecond("Augmented Second", "A2", 3),
    MinorThird("Minor Third", "m3", 3),
    MajorThird("Major Third", "M3", 4),
    PerfectFourth("Perfect Fourth", "P4", 5),
    AugmentedFourth("Augmented Fourth", "A4", 6),
    DiminishedFifth("Diminished Fifth", "d5", 6),
    Tritone("Diminished Fifth", "d5", 6),
    PerfectFifth("Perfect Fifth", "P5", 7),
    AugmentedFifth("Augmented Fifth", "A5", 8),
    MinorSixth("Minor Sixth", "m6", 8),
    MajorSixth("Major Sixth", "M6", 9),
    DiminishedSeventh("Diminished Seventh", "d7", 9),
    MinorSeventh("Minor Seventh", "m7", 10),
    MajorSeventh("Major Seventh", "M7", 11),
    PerfectOctave("Perfect Octave", "PO", 12),
    MinorNinth("Minor Ninth", "m9", 13),
    MajorNinth("Major Ninth", "M9", 14),
    AugmentedNinth("Augmented Ninth", "A9", 15),
    PerfectEleventh("Perfect Eleventh", "P11", 17),
    AugmentedEleventh("Augmented Eleventh", "A11", 18),
    MinorThirteenth("Minor Thirteenth", "m13", 20),
    MajorThirteenth("Major Thirteenth", "M13", 21)
}
