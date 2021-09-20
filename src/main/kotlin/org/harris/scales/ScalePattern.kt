package org.harris.scales

import org.harris.notes.Interval
import org.harris.notes.Interval.AugmentedFifth
import org.harris.notes.Interval.AugmentedFourth
import org.harris.notes.Interval.AugmentedNinth
import org.harris.notes.Interval.AugmentedSecond
import org.harris.notes.Interval.AugmentedUnison
import org.harris.notes.Interval.DiminishedFifth
import org.harris.notes.Interval.MajorSecond
import org.harris.notes.Interval.MajorSeventh
import org.harris.notes.Interval.MajorSixth
import org.harris.notes.Interval.MajorThird
import org.harris.notes.Interval.MinorSecond
import org.harris.notes.Interval.MinorSeventh
import org.harris.notes.Interval.MinorSixth
import org.harris.notes.Interval.MinorThird
import org.harris.notes.Interval.PerfectFifth
import org.harris.notes.Interval.PerfectFourth
import org.harris.notes.Interval.Unison
import org.harris.notes.Pitch
import kotlin.math.abs

enum class ScalePattern(private val pattern: Array<Interval>) {
    Ionian(
        arrayOf(
            Unison,
            MajorSecond,
            MajorThird,
            PerfectFourth,
            PerfectFifth,
            MajorSixth,
            MajorSeventh
        )
    ),
    Dorian(
        arrayOf(
            Unison,
            MajorSecond,
            MinorThird,
            PerfectFourth,
            PerfectFifth,
            MajorSixth,
            MinorSeventh
        )
    ),
    Phrygian(
        arrayOf(
            Unison,
            MinorSecond,
            MinorThird,
            PerfectFourth,
            PerfectFifth,
            MinorSixth,
            MinorSeventh
        )
    ),
    Lydian(
        arrayOf(
            Unison,
            MajorSecond,
            MajorThird,
            AugmentedFourth,
            PerfectFifth,
            MajorSixth,
            MajorSeventh
        )
    ),
    Mixolydian(
        arrayOf(
            Unison,
            MajorSecond,
            MajorThird,
            PerfectFourth,
            PerfectFifth,
            MajorSixth,
            MinorSeventh
        )
    ),
    Aolian(
        arrayOf(
            Unison,
            MajorSecond,
            MinorThird,
            PerfectFourth,
            PerfectFifth,
            MinorSixth,
            MinorSeventh
        )
    ),
    Locrian(
        arrayOf(
            Unison,
            MinorSecond,
            MinorThird,
            PerfectFourth,
            DiminishedFifth,
            MinorSixth,
            MinorSeventh
        )
    ),
    MajorPentatonic(
        arrayOf(
            Unison,
            MajorSecond,
            MajorThird,
            PerfectFifth,
            MajorSixth
        )
    ),
    MinorPentatonic(
        arrayOf(
            Unison,
            MinorThird,
            PerfectFourth,
            PerfectFifth,
            MinorSeventh
        )
    ),
    Blues(
        arrayOf(
            Unison,
            MinorThird,
            PerfectFourth,
            DiminishedFifth,
            PerfectFifth,
            MinorSeventh
        )
    ),
    HarmonicMinor(
        arrayOf(
            Unison,
            MajorSecond,
            MinorThird,
            PerfectFourth,
            PerfectFifth,
            MinorSixth,
            MajorSeventh
        )
    ),
    MelodicMinor(
        arrayOf(
            Unison,
            MajorSecond,
            MinorThird,
            PerfectFourth,
            PerfectFifth,
            MajorSixth,
            MajorSeventh
        )
    ),
    DorianFlat2(
        arrayOf(
            Unison,
            MinorSecond,
            MinorThird,
            PerfectFourth,
            PerfectFifth,
            MajorSixth,
            MinorSeventh
        )
    ),
    NeapolitanMinor(
        arrayOf(
            Unison,
            MinorSecond,
            MinorThird,
            PerfectFourth,
            PerfectFifth,
            MinorSixth,
            MajorSeventh
        )
    ),
    LydianAugmented(
        arrayOf(
            Unison,
            MajorSecond,
            MajorThird,
            AugmentedFourth,
            AugmentedFifth,
            MajorSixth,
            MajorSeventh
        )
    ),
    LydianDominant(
        arrayOf(
            Unison,
            MajorSecond,
            MajorThird,
            AugmentedFourth,
            PerfectFifth,
            MajorSixth,
            MinorSeventh
        )
    ),
    MixolydianFlat6(
        arrayOf(
            Unison,
            MajorSecond,
            MajorThird,
            PerfectFourth,
            PerfectFifth,
            MinorSixth,
            MinorSeventh
        )
    ),
    Bebop(
        arrayOf(
            Unison,
            MajorSecond,
            MajorThird,
            PerfectFourth,
            PerfectFifth,
            MajorSixth,
            MinorSeventh,
            MajorSeventh
        )
    ),
    LocrianSharp2(
        arrayOf(
            Unison,
            MajorSecond,
            MinorThird,
            PerfectFourth,
            DiminishedFifth,
            MinorSixth,
            MinorSeventh
        )
    ),
    AlteredDominant(
        arrayOf(
            Unison,
            MinorSecond,
            AugmentedNinth,
            MajorThird,
            DiminishedFifth,
            AugmentedFifth,
            MinorSeventh
        )
    ),
    HalfWholeDiminished(
        arrayOf(
            Unison,
            MinorSecond,
            MinorThird,
            MajorThird,
            AugmentedFourth,
            PerfectFifth,
            MajorSixth,
            MinorSeventh
        )
    ),
    WholeTone(
        arrayOf(
            Unison,
            MajorSecond,
            MajorThird,
            DiminishedFifth,
            AugmentedFifth,
            MinorSeventh
        )
    ),
    MajorSixthDiminished(
        arrayOf(
            Unison,
            MajorSecond,
            MajorThird,
            PerfectFourth,
            PerfectFifth,
            MinorSixth,
            MajorSixth,
            MajorSeventh
        )
    ),
    MinorSixthDiminished(
        arrayOf(
            Unison,
            MajorSecond,
            MinorThird,
            PerfectFourth,
            PerfectFifth,
            MinorSixth,
            MajorSixth,
            MajorSeventh
        )
    ),
    DominantDiminished(
        arrayOf(
            Unison,
            MajorSecond,
            MajorThird,
            PerfectFourth,
            PerfectFifth,
            MinorSixth,
            MinorSeventh,
            MajorSeventh
        )
    ),
    DominantFlat5Diminished(
        arrayOf(
            Unison,
            MajorSecond,
            MajorThird,
            PerfectFourth,
            DiminishedFifth,
            MinorSixth,
            MinorSeventh,
            MajorSeventh
        )
    ),
    Chromatic(
        arrayOf(
            Unison,
            AugmentedUnison,
            MajorSecond,
            AugmentedSecond,
            MajorThird,
            PerfectFourth,
            AugmentedFourth,
            PerfectFifth,
            AugmentedFifth,
            MajorSixth,
            MinorSeventh,
            MajorSeventh
        )
    );

    fun createScale(root: Pitch): Scale {
        return Scale(this, root)
    }

    fun notes(root: Pitch): Array<Pitch> {
        return pattern
            .map { root.transpose(it) }
            .toTypedArray()
    }
}

enum class ScaleDegree {
    I, II, III, IV, V, VI, VII;

    operator fun plus(increment: Int): ScaleDegree {
        return values()[(this.ordinal + increment) % 7]
    }

    fun above(): ScaleDegree { return values()[(this.ordinal + 1) % 7] }

    fun below(): ScaleDegree { return values()[(abs(this.ordinal - 1)) % 7] }
}
