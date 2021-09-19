package org.harris.chords

import org.harris.notes.Interval
import org.harris.notes.Interval.*
import org.harris.notes.Pitch

enum class ChordPattern(private val patternName: String, private val abbreviation: String, private val pattern: List<Interval>) {
    Major("Major", "Maj", listOf(MajorThird, PerfectFifth)),
    Augmented("Major", "Maj", listOf(MajorThird, AugmentedFifth)),
    Major6("Major", "Maj", listOf(MajorThird, PerfectFifth, MajorSixth)),
    Major6Add9("Major", "Maj", listOf(MajorThird, PerfectFifth, MajorSixth, MajorNinth)),
    Major6Flat5Add9("Major", "Maj", listOf(MajorThird, DiminishedFifth, MajorSixth, MajorNinth)),
    Major7("Major", "Maj", listOf(MajorThird, PerfectFifth, MajorSeventh)),
    Major9("Major", "Maj", listOf(MajorThird, PerfectFifth, MajorSeventh, MajorNinth)),
    Major9Sharp11("Major", "Maj", listOf(MajorThird, PerfectFifth, MajorSeventh, MajorNinth, AugmentedEleventh)),
    Major11("Major", "Maj", listOf(MajorThird, PerfectFifth, MajorSeventh, PerfectEleventh)),
    Major13("Major", "Maj", listOf(MajorThird, PerfectFifth, MajorSeventh, MajorThirteenth)),
    Major13Sharp11("Major", "Maj", listOf(MajorThird, PerfectFifth, MajorSeventh, AugmentedEleventh, MajorThirteenth)),
    Augmented7("Major", "Maj", listOf(MajorThird, AugmentedFifth, MajorSeventh)),
    Dominant7("Major", "Maj", listOf(MajorThird, PerfectFifth, MinorSeventh)),
    Dominant7Flat5("Major", "Maj", listOf(MajorThird, DiminishedFifth, MinorSeventh)),
    Dominant7Flat9("Major", "Maj", listOf(MajorThird, PerfectFifth, MinorSeventh, MinorNinth)),
    Dominant7Sharp9("Major", "Maj", listOf(MajorThird, PerfectFifth, MinorSeventh, AugmentedNinth)),
    Dominant7Flat5Flat9("Major", "Maj", listOf(MajorThird, DiminishedFifth, MinorSeventh, MinorNinth)),
    Dominant7Flat5Sharp9("Major", "Maj", listOf(MajorThird, DiminishedFifth, MinorSeventh, AugmentedNinth)),
    Dominant9("Major", "Maj", listOf(MajorThird, PerfectFifth, MinorSeventh, MajorNinth)),
    Dominant11("Major", "Maj", listOf(MajorThird, PerfectFifth, MinorSeventh, MajorNinth, PerfectEleventh)),
    Dominant13("Major", "Maj", listOf(MajorThird, PerfectFifth, MinorSeventh, MajorNinth, PerfectEleventh, MajorThirteenth)),
    Minor("Minor", "Maj", listOf(MinorThird, PerfectFifth)),
    Diminished("Major", "Maj", listOf(MinorThird, DiminishedFifth)),
    Minor7("Major", "Maj", listOf(MinorThird, PerfectFifth, MinorSeventh)),
    Minor6("Major", "Maj", listOf(MinorThird, PerfectFifth, MajorSixth)),
    Minor6Add9("Major", "Maj", listOf(MinorThird, PerfectFifth, MajorSixth, MajorNinth)),
    Minor9("Major", "Maj", listOf(MinorThird, PerfectFifth, MinorSeventh, MajorNinth)),
    Diminished7("Major", "Maj", listOf(MinorThird, DiminishedFifth, DiminishedSeventh)),
    Minor7b5("Major", "Maj", listOf(MinorThird, DiminishedFifth, MinorSeventh)),
    MinorMaj7("Major", "Maj", listOf(MinorThird, PerfectFifth, MajorSeventh)),
    MinorMaj9("Major", "Maj", listOf(MinorThird, PerfectFifth, MajorSeventh, MajorNinth)),
    Sus2("Major", "Maj", listOf(MajorSecond, PerfectFifth)),
    Sus2Diminished("Major", "Maj", listOf(MajorSecond, DiminishedFifth)),
    Sus2Augmented("Major", "Maj", listOf(MajorSecond, AugmentedFifth)),
    Sus4("Major", "Maj", listOf(PerfectFourth, PerfectFifth)),
    Sus4Diminished("Major", "Maj", listOf(PerfectFourth, DiminishedFifth)),
    Sus4Augmented("Major", "Maj", listOf(PerfectFourth, AugmentedFifth));

    fun createChord(root: Pitch): ClosedChord {
        return ClosedChord(root, this)
    }

    companion object {
        internal fun from(intervals: List<Interval>): ChordPattern {
            return values().first { it.pattern == intervals }
        }
    }

    internal fun notes(root: Pitch): Array<ChordPitch> {
        return listOf(ChordPitch(root, ChordFunction.Root))
            .union(pattern.map { createChordNote(it, root) })
            .toTypedArray()
    }

    private fun createChordNote(it: Interval, root: Pitch) =
        ChordPitch(root.transpose(it), ChordFunction.functionForInterval((it)))
}
