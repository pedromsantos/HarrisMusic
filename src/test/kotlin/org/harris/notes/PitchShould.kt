package org.harris.notes

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.harris.notes.Interval.AugmentedFifth
import org.harris.notes.Interval.AugmentedFourth
import org.harris.notes.Interval.AugmentedNinth
import org.harris.notes.Interval.AugmentedSecond
import org.harris.notes.Interval.DiminishedFifth
import org.harris.notes.Interval.DiminishedSeventh
import org.harris.notes.Interval.MajorSecond
import org.harris.notes.Interval.MajorSeventh
import org.harris.notes.Interval.MajorSixth
import org.harris.notes.Interval.MajorThird
import org.harris.notes.Interval.MinorSecond
import org.harris.notes.Interval.MinorSeventh
import org.harris.notes.Interval.MinorSixth
import org.harris.notes.Interval.MinorThird
import org.harris.notes.Interval.PerfectEleventh
import org.harris.notes.Interval.PerfectFifth
import org.harris.notes.Interval.PerfectFourth
import org.harris.notes.Interval.Unison
import org.harris.notes.Pitch.A
import org.harris.notes.Pitch.AFlat
import org.harris.notes.Pitch.ASharp
import org.harris.notes.Pitch.B
import org.harris.notes.Pitch.BFlat
import org.harris.notes.Pitch.C
import org.harris.notes.Pitch.CSharp
import org.harris.notes.Pitch.D
import org.harris.notes.Pitch.DFlat
import org.harris.notes.Pitch.DSharp
import org.harris.notes.Pitch.E
import org.harris.notes.Pitch.EFlat
import org.harris.notes.Pitch.ESharp
import org.harris.notes.Pitch.F
import org.harris.notes.Pitch.FSharp
import org.harris.notes.Pitch.G
import org.harris.notes.Pitch.GFlat
import org.harris.notes.Pitch.GSharp
import org.junit.Test

class PitchShould {
    @Test
    fun `sharp C to C sharp`() {
        assertThat(C.sharp(), equalTo(C.sharp()))
    }

    @Test
    fun `sharp C sharp to D`() {
        assertThat(CSharp.sharp(), equalTo(D))
    }

    @Test
    fun `sharp D flat to D`() {
        assertThat(DFlat.sharp(), equalTo(D))
    }

    @Test
    fun `sharp D to D sharp`() {
        assertThat(D.sharp(), equalTo(DSharp))
    }

    @Test
    fun `sharp D sharp to E`() {
        assertThat(DSharp.sharp(), equalTo(E))
    }

    @Test
    fun `sharp E flat to E`() {
        assertThat(EFlat.sharp(), equalTo(E))
    }

    @Test
    fun `sharp E to F`() {
        assertThat(E.sharp(), equalTo(F))
    }

    @Test
    fun `sharp F to F sharp`() {
        assertThat(F.sharp(), equalTo(FSharp))
    }

    @Test
    fun `sharp F sharp to G`() {
        assertThat(FSharp.sharp(), equalTo(G))
    }

    @Test
    fun `sharp G flat to G`() {
        assertThat(GFlat.sharp(), equalTo(G))
    }

    @Test
    fun `sharp G to G sharp`() {
        assertThat(G.sharp(), equalTo(GSharp))
    }

    @Test
    fun `sharp G sharp to A`() {
        assertThat(GSharp.sharp(), equalTo(A))
    }

    @Test
    fun `sharp A flat to A`() {
        assertThat(AFlat.sharp(), equalTo(A))
    }

    @Test
    fun `sharp A to A sharp`() {
        assertThat(A.sharp(), equalTo(ASharp))
    }

    @Test
    fun `sharp A sharp to B`() {
        assertThat(ASharp.sharp(), equalTo(B))
    }

    @Test
    fun `sharp B flat to B`() {
        assertThat(BFlat.sharp(), equalTo(B))
    }

    @Test
    fun `sharp B to C`() {
        assertThat(B.sharp(), equalTo(C))
    }

    @Test
    fun `flat C to B`() {
        assertThat(C.flat(), equalTo(B))
    }

    @Test
    fun `flat C sharp to C`() {
        assertThat(CSharp.flat(), equalTo(C))
    }

    @Test
    fun `flat D flat to C`() {
        assertThat(DFlat.flat(), equalTo(C))
    }

    @Test
    fun `flat D to D flat`() {
        assertThat(D.flat(), equalTo(DFlat))
    }

    @Test
    fun `flat D sharp to D`() {
        assertThat(DSharp.flat(), equalTo(D))
    }

    @Test
    fun `flat E flat to D`() {
        assertThat(EFlat.flat(), equalTo(D))
    }

    @Test
    fun `flat E to E Flat`() {
        assertThat(E.flat(), equalTo(EFlat))
    }

    @Test
    fun `flat F to E`() {
        assertThat(F.flat(), equalTo(E))
    }

    @Test
    fun `flat F sharp to F`() {
        assertThat(FSharp.flat(), equalTo(F))
    }

    @Test
    fun `flat G flat to F`() {
        assertThat(GFlat.flat(), equalTo(F))
    }

    @Test
    fun `flat G to G flat`() {
        assertThat(G.flat(), equalTo(GFlat))
    }

    @Test
    fun `flat G sharp to G`() {
        assertThat(GSharp.flat(), equalTo(G))
    }

    @Test
    fun `flat A flat to G`() {
        assertThat(AFlat.flat(), equalTo(G))
    }

    @Test
    fun `flat A to A flat`() {
        assertThat(A.flat(), equalTo(AFlat))
    }

    @Test
    fun `flat A sharp to A`() {
        assertThat(ASharp.flat(), equalTo(A))
    }

    @Test
    fun `flat B flat to A`() {
        assertThat(BFlat.flat(), equalTo(A))
    }

    @Test
    fun `flat B to B flat`() {
        assertThat(B.flat(), equalTo(BFlat))
    }

    @Test
    fun `measure semitones between C and C to zero semitones`() {
        assertThat(C.absoluteDistance(C), equalTo(0))
    }

    @Test
    fun `measure semitones between C and C sharp to one semitone`() {
        assertThat(C.absoluteDistance(CSharp), equalTo(1))
    }

    @Test
    fun `measure semitones between C and D flat to one semitone`() {
        assertThat(C.absoluteDistance(DFlat), equalTo(1))
    }

    @Test
    fun `measure semitones between C and D to two semitones`() {
        assertThat(C.absoluteDistance(D), equalTo(2))
    }

    @Test
    fun `measure semitones between C and D sharp to three semitones`() {
        assertThat(C.absoluteDistance(DSharp), equalTo(3))
    }

    @Test
    fun `measure semitones between C and E flat to three semitones`() {
        assertThat(C.absoluteDistance(EFlat), equalTo(3))
    }

    @Test
    fun `measure semitones between C and E to four semitones`() {
        assertThat(C.absoluteDistance(E), equalTo(4))
    }

    @Test
    fun `measure semitones between C and F to five semitones`() {
        assertThat(C.absoluteDistance(F), equalTo(5))
    }

    @Test
    fun `measure semitones between C and F sharp to six semitones`() {
        assertThat(C.absoluteDistance(FSharp), equalTo(6))
    }

    @Test
    fun `measure semitones between C and G flat to six semitones`() {
        assertThat(C.absoluteDistance(GFlat), equalTo(6))
    }

    @Test
    fun `measure semitones between C and G to seven semitones`() {
        assertThat(C.absoluteDistance(G), equalTo(7))
    }

    @Test
    fun `measure semitones between C and G sharp to eight semitones`() {
        assertThat(C.absoluteDistance(GSharp), equalTo(8))
    }

    @Test
    fun `measure semitones between C and A flat to eight semitones`() {
        assertThat(C.absoluteDistance(AFlat), equalTo(8))
    }

    @Test
    fun `measure semitones between C and A to nine semitones`() {
        assertThat(C.absoluteDistance(A), equalTo(9))
    }

    @Test
    fun `measure semitones between C and A sharp to ten semitones`() {
        assertThat(C.absoluteDistance(ASharp), equalTo(10))
    }

    @Test
    fun `measure semitones between C and B flat to ten semitones`() {
        assertThat(C.absoluteDistance(BFlat), equalTo(10))
    }

    @Test
    fun `measure semitones between C and B to eleven semitones`() {
        assertThat(C.absoluteDistance(B), equalTo(11))
    }

    @Test
    fun `measure interval between C and C as Unison`() {
        assertThat(C.intervalTo(C), equalTo(Unison))
    }

    @Test
    fun `measure interval between C and D flat as MinorSecond`() {
        assertThat(C.intervalTo(DFlat), equalTo(MinorSecond))
    }

    @Test
    fun `measure interval between C and D as MajorSecond`() {
        assertThat(C.intervalTo(D), equalTo(MajorSecond))
    }

    @Test
    fun `measure interval between C and E flat as MinorThird`() {
        assertThat(C.intervalTo(EFlat), equalTo(MinorThird))
    }

    @Test
    fun `measure interval between C and E as MajorThird`() {
        assertThat(C.intervalTo(E), equalTo(MajorThird))
    }

    @Test
    fun `measure interval between C and F as PerfectFourth`() {
        assertThat(C.intervalTo(F), equalTo(PerfectFourth))
    }

    @Test
    fun `measure interval between C and F sharp as AugmentedFourth`() {
        assertThat(C.intervalTo(FSharp), equalTo(AugmentedFourth))
    }

    @Test
    fun `measure interval between C and G flat as DiminishedFifth`() {
        assertThat(C.intervalTo(GFlat), equalTo(DiminishedFifth))
    }

    @Test
    fun `measure interval between C and G as PerfectFifth`() {
        assertThat(C.intervalTo(G), equalTo(PerfectFifth))
    }

    @Test
    fun `measure interval between C and G sharp as AugmentedFifth`() {
        assertThat(C.intervalTo(GSharp), equalTo(AugmentedFifth))
    }

    @Test
    fun `measure interval between C and A flat as MinorSixth`() {
        assertThat(C.intervalTo(AFlat), equalTo(MinorSixth))
    }

    @Test
    fun `measure interval between C and A as MajorSixth`() {
        assertThat(C.intervalTo(A), equalTo(MajorSixth))
    }

    @Test
    fun `measure interval between C and B flat as MinorSeventh`() {
        assertThat(C.intervalTo(BFlat), equalTo(MinorSeventh))
    }

    @Test
    fun `measure interval between C and B as MajorSeventh`() {
        assertThat(C.intervalTo(B), equalTo(MajorSeventh))
    }

    @Test
    fun `measure interval between D and F as MinorThird`() {
        assertThat(D.intervalTo(F), equalTo(MinorThird))
    }

    @Test
    fun `transpose using a Unison from C to C`() {
        assertThat(C.transpose(Unison), equalTo(C))
    }

    @Test
    fun `transpose using a Unison from C# to C#`() {
        assertThat(CSharp.transpose(Unison), equalTo(CSharp))
    }

    @Test
    fun `transpose using a MinorSecond from C to D flat`() {
        assertThat(C.transpose(MinorSecond), equalTo(DFlat))
    }

    @Test
    fun `transpose using a MajorSecond from C to D`() {
        assertThat(C.transpose(MajorSecond), equalTo(D))
    }

    @Test
    fun `transpose using a AugmentedSecond from C to D sharp`() {
        assertThat(C.transpose(AugmentedSecond), equalTo(DSharp))
    }

    @Test
    fun `transpose using a MinorThird from C to E flat`() {
        assertThat(C.transpose(MinorThird), equalTo(EFlat))
    }

    @Test
    fun `transpose using a MajorThird from C to E`() {
        assertThat(C.transpose(MajorThird), equalTo(E))
    }

    @Test
    fun `transpose using a PerfectFourth from C to F`() {
        assertThat(C.transpose(PerfectFourth), equalTo(F))
    }

    @Test
    fun `transpose using a AugmentedFourth from C to F sharp`() {
        assertThat(C.transpose(AugmentedFourth), equalTo(FSharp))
    }

    @Test
    fun `transpose using a DiminishedFifth from C to G flat`() {
        assertThat(C.transpose(DiminishedFifth), equalTo(GFlat))
    }

    @Test
    fun `transpose using a PerfectFifth from C to G`() {
        assertThat(C.transpose(PerfectFifth), equalTo(G))
    }

    @Test
    fun `transpose using a PerfectFifth from D to A`() {
        assertThat(D.transpose(PerfectFifth), equalTo(A))
    }

    @Test
    fun `transpose using a AugmentedFifth from C to G sharp`() {
        assertThat(C.transpose(AugmentedFifth), equalTo(GSharp))
    }

    @Test
    fun `transpose using a MinorSixth from C to A flat`() {
        assertThat(C.transpose(MinorSixth), equalTo(AFlat))
    }

    @Test
    fun `transpose using a MajorSixth from C to A`() {
        assertThat(C.transpose(MajorSixth), equalTo(A))
    }

    @Test
    fun `transpose using a diminished seventh from C to B flat flat`() {
        assertThat(C.transpose(DiminishedSeventh), equalTo(A))
    }

    @Test
    fun `transpose using a diminished seventh from G to E`() {
        assertThat(G.transpose(DiminishedSeventh), equalTo(E))
    }

    @Test
    fun `transpose using a minor seventh from C to B flat`() {
        assertThat(C.transpose(MinorSeventh), equalTo(BFlat))
    }

    @Test
    fun `transpose using a MajorSeventh from C to B`() {
        assertThat(C.transpose(MajorSeventh), equalTo(B))
    }

    @Test
    fun `transpose using a augmented ninth from G to A#`() {
        assertThat(G.transpose(AugmentedNinth), equalTo(ASharp))
    }

    @Test
    fun `transpose using a perfect eleventh from G to C`() {
        assertThat(G.transpose(PerfectEleventh), equalTo(C))
    }

    @Test
    fun `transpose using a augmented second from D to E#`() {
        assertThat(D.transpose(AugmentedSecond), equalTo(ESharp))
    }

    @Test
    fun `transpose using a minor third from G to Bb`() {
        assertThat(G.transpose(MinorThird), equalTo(BFlat))
    }

    @Test
    fun `transpose using a major third from G to B`() {
        assertThat(G.transpose(MajorThird), equalTo(B))
    }
}
