package org.harris

import org.harris.Note.*

enum class Key(private val root: Note, private val accidentals: Int) {
    AFlatMajor(AFlat, -4),
    AMajor(A, 3),
    BMajor(B, 5),
    BFlatMajor(BFlat, 2),
    CMajor(C, 0),
    DFlatMajor(DFlat, 5),
    DMajor(D, 2),
    EMajor(E, 4),
    EFlatMajor(EFlat, 3),
    FMajor(F, 1),
    FSharpMajor(FSharp, 6),
    GMajor(G, 1),
    GFlatMajor(GFlat, 6),
    AMinor(A, 0),
    BMinor(B, 2),
    BFlatMinor(BFlat, 5),
    CMinor(C, 3),
    CSharpMinor(CSharp, 4),
    DMinor(D, 1),
    EMinor(E, 1),
    FMinor(F, 4),
    FSharpMinor(FSharp, 3),
    GMinor(G, 2),
    GSharpMinor(GSharp, 5),
    EFlatMinor(EFlat, 6);

    private fun flatKey(): Set<Note> {
        return (Companion.fifths
            .asReversed()
            .drop(Math.abs(this.accidentals)))
            .union(
                Companion.fifths
                    .asReversed()
                    .takeLast(Math.abs(this.accidentals))
                    .map { it -> it.flat() })
    }

    private fun sharpKey(): Set<Note> {
        return (Companion.fifths
            .drop(this.accidentals))
            .union(
                Companion.fifths
                    .takeLast(this.accidentals)
                    .map { it -> it.sharp() })
    }

    private fun allNotes(): Set<Note> {
        return when {
            this.accidentals < 0 -> flatKey()
            this.accidentals > 0 -> sharpKey()
            else -> Companion.fifths.toSet()
        }
    }

    fun notes(): Set<Note> {
        val notes = allNotes()
        return notes
            .sortedBy { it.pitch() }
            .dropWhile { it -> it != this.root }
            .union(
                notes
                    .sortedBy { it.pitch() }
                    .takeLastWhile { it -> it != this.root }
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