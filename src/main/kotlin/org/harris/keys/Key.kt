package org.harris.keys

import org.harris.notes.Pitch
import org.harris.notes.Pitch.*
import kotlin.math.abs

enum class Key(private val root: Pitch, private val accidentals: Int) {
    AFlatMajor(AFlat, -4),
    AMajor(A, 3),
    BMajor(B, 5),
    BFlatMajor(BFlat, -2),
    CMajor(C, 0),
    DFlatMajor(DFlat, -5),
    DMajor(D, 2),
    EMajor(E, 4),
    EFlatMajor(EFlat, -3),
    FMajor(F, -1),
    FSharpMajor(FSharp, 6),
    GMajor(G, 1),
    GFlatMajor(GFlat, -6),
    AMinor(A, 0),
    BMinor(B, 2),
    BFlatMinor(BFlat, -5),
    CMinor(C, -3),
    CSharpMinor(CSharp, 4),
    DMinor(D, -1),
    EMinor(E, 1),
    FMinor(F, -4),
    FSharpMinor(FSharp, 3),
    GMinor(G, -2),
    GSharpMinor(GSharp, 5),
    EFlatMinor(EFlat, -6);

    private fun flatKey(): Set<Pitch> {
        return (fifths
            .asReversed()
            .drop(abs(this.accidentals)))
            .union(
                fifths
                    .asReversed()
                    .take(abs(this.accidentals))
                    .map { it.flat() })
    }

    private fun sharpKey(): Set<Pitch> {
        return (fifths
            .drop(this.accidentals))
            .union(
                fifths
                    .take(this.accidentals)
                    .map { it.sharp() })
    }

    private fun allPitches(): Set<Pitch> {
        return when {
            this.accidentals < 0 -> flatKey()
            this.accidentals > 0 -> sharpKey()
            else -> fifths.toSet()
        }
    }

    fun pitches(): Set<Pitch> {
        val notes = allPitches()
        return notes
            .sortedBy { it.value() }
            .dropWhile { it != this.root }
            .union(
                notes
                    .sortedBy { it.value() }
                    .takeWhile { it != this.root }
            )
    }

    companion object {
        private val fifths = listOf(
            F,
            C,
            G,
            D,
            A,
            E,
            B
        )
    }
}