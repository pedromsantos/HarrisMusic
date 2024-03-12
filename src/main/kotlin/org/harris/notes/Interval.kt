package org.harris.notes

enum class Interval(
    private val intervalName: String,
    private val abreviature: String,
    private val distance: Int,
) {
    Unison("Unisson", "U", 0) {
        override fun invert(): Interval = PerfectOctave
    },
    AugmentedUnison("Augmented Unison", "A1", 1) {
        override fun invert(): Interval = AugmentedUnison
    },
    MinorSecond("Minor Second", "m2", 1) {
        override fun invert(): Interval = MajorSeventh
    },
    MajorSecond("Major Second", "M2", 2) {
        override fun invert(): Interval = MinorSeventh
    },
    AugmentedSecond("Augmented Second", "A2", 3) {
        override fun invert(): Interval = DiminishedSeventh
    },
    MinorThird("Minor Third", "m3", 3) {
        override fun invert(): Interval = MajorSixth
    },
    MajorThird("Major Third", "M3", 4) {
        override fun invert(): Interval = MinorSixth
    },
    PerfectFourth("Perfect Fourth", "P4", 5) {
        override fun invert(): Interval = PerfectFifth
    },
    AugmentedFourth("Augmented Fourth", "A4", 6) {
        override fun invert(): Interval = DiminishedFifth
    },
    DiminishedFifth("Diminished Fifth", "d5", 6) {
        override fun invert(): Interval = AugmentedFourth
    },
    Tritone("Diminished Fifth", "d5", 6) {
        override fun invert(): Interval = AugmentedFourth
    },
    PerfectFifth("Perfect Fifth", "P5", 7) {
        override fun invert(): Interval = PerfectFourth
    },
    AugmentedFifth("Augmented Fifth", "A5", 8) {
        override fun invert(): Interval = MajorThird
    },
    MinorSixth("Minor Sixth", "m6", 8) {
        override fun invert(): Interval = MajorThird
    },
    MajorSixth("Major Sixth", "M6", 9) {
        override fun invert(): Interval = MinorThird
    },
    DiminishedSeventh("Diminished Seventh", "d7", 9) {
        override fun invert(): Interval = AugmentedSecond
    },
    MinorSeventh("Minor Seventh", "m7", 10) {
        override fun invert(): Interval = MajorSecond
    },
    MajorSeventh("Major Seventh", "M7", 11) {
        override fun invert(): Interval = MinorSecond
    },
    PerfectOctave("Perfect Octave", "PO", 12) {
        override fun invert(): Interval = Unison
    },
    MinorNinth("Minor Ninth", "m9", 13) {
        override fun invert(): Interval = MajorSeventh
    },
    MajorNinth("Major Ninth", "M9", 14) {
        override fun invert(): Interval = MinorSeventh
    },
    AugmentedNinth("Augmented Ninth", "A9", 15) {
        override fun invert(): Interval = DiminishedSeventh
    },
    PerfectEleventh("Perfect Eleventh", "P11", 17) {
        override fun invert(): Interval = PerfectFifth
    },
    AugmentedEleventh("Augmented Eleventh", "A11", 18) {
        override fun invert(): Interval = DiminishedFifth
    },
    MinorThirteenth("Minor Thirteenth", "m13", 20) {
        override fun invert(): Interval = MajorThird
    },
    MajorThirteenth("Major Thirteenth", "M13", 21) {
        override fun invert(): Interval = MinorThird
    }, ;

    abstract fun invert(): Interval
}
