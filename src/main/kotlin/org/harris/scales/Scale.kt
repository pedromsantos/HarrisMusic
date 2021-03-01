package org.harris.scales

import org.harris.MelodicPhrase
import org.harris.MelodicLine
import org.harris.notes.Note
import org.harris.notes.Pitch
import org.harris.notes.ScaleNote

class Scale {
    private val pattern: ScalePattern
    private val root: Pitch
    private val pitches: Array<Pitch>

    constructor(pattern: ScalePattern, root: Pitch) {
        this.pattern = pattern
        this.root = root
        this.pitches = pattern.notes(root)
    }

    fun pitches(): Array<Pitch> = pitches

    fun note(degree: ScaleDegree): Note = notes()[degree.ordinal]

    fun pitch(degree: ScaleDegree) : Pitch {
        return pitches[degree.ordinal]
    }

    fun thirdsFrom(degree: ScaleDegree) : Array<Pitch> {
        return pitches
            .toList()
            .drop(degree.ordinal)
            .plus(pitches.toList())
            .plus(pitches.toList())
            .filterIndexed { index, _ -> index % 2 == 0 }
            .take(7)
            .toTypedArray()
    }

    fun thirds() : MelodicLine {
        val line = MelodicLine(emptyList())

        for(scaleDegree in ScaleDegree.values()) {
            line.add(
                MelodicPhrase(
                    listOf(
                        Note(thirdsFrom(scaleDegree)[0], ScaleNote(pattern, root, scaleDegree)),
                        Note(thirdsFrom(scaleDegree)[1], ScaleNote(pattern, root, scaleDegree + 2))
                    ))
            )
        }

        return line
    }

    fun triads() : MelodicLine {
        val line = MelodicLine(emptyList())

        for(scaleDegree in ScaleDegree.values()) {
            line.add(
                MelodicPhrase(
                    listOf(
                        Note(thirdsFrom(scaleDegree)[0], ScaleNote(pattern, root, scaleDegree)),
                        Note(thirdsFrom(scaleDegree)[1], ScaleNote(pattern, root, scaleDegree + 2)),
                        Note(thirdsFrom(scaleDegree)[2], ScaleNote(pattern, root, scaleDegree + 4))
                    ))
            )
        }

        return line
    }

    fun chords() : MelodicLine {
        val line = MelodicLine(emptyList())

        for(scaleDegree in ScaleDegree.values()) {
            line.add(
                MelodicPhrase(
                    listOf(
                        Note(thirdsFrom(scaleDegree)[0], ScaleNote(pattern, root, scaleDegree)),
                        Note(thirdsFrom(scaleDegree)[1], ScaleNote(pattern, root, scaleDegree + 2)),
                        Note(thirdsFrom(scaleDegree)[2], ScaleNote(pattern, root, scaleDegree + 4)),
                        Note(thirdsFrom(scaleDegree)[3], ScaleNote(pattern, root, scaleDegree + 6))
                    ))
            )
        }

        return line
    }

    fun pivotChords() : MelodicLine {
        val line = MelodicLine(emptyList())

        for(scaleDegree in ScaleDegree.values()) {
            line.add(
                MelodicPhrase(
                    listOf(
                        Note(thirdsFrom(scaleDegree)[0], ScaleNote(pattern, root, scaleDegree)),
                        Note(thirdsFrom(scaleDegree)[3], ScaleNote(pattern, root, scaleDegree + 6)),
                        Note(thirdsFrom(scaleDegree)[2], ScaleNote(pattern, root, scaleDegree + 4)),
                        Note(thirdsFrom(scaleDegree)[1], ScaleNote(pattern, root, scaleDegree + 2))
                    ))
            )
        }

        return line
    }

    private fun notes(): Array<Note> = pitches
        .mapIndexed { i,p -> Note(p, ScaleNote(pattern, root, ScaleDegree.values()[i])) }
        .toTypedArray()
}
