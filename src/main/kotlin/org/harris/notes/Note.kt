package org.harris.notes

import org.harris.notes.NoteDuration.*
import org.harris.scales.ScaleDegree
import org.harris.scales.ScalePattern
import org.harris.scales.Scale

data class Note(
    private val pitch: Pitch,
    private val scaleNote: ScaleNote = ScaleNote.chromaticNote(pitch),
    private val duration: NoteDuration = Whole
) {

    fun flat(): Note = Note(pitch.flat(), scaleNote, duration)

    fun sharp(): Note = Note(pitch.sharp(), scaleNote, duration)

    fun above(): Note = Note(scaleNote.abovePitch(), scaleNote.above(), duration)

    fun below(): Note = Note(scaleNote.belowPitch(), scaleNote.below(), duration)
}

data class ScaleNote(val scalePattern: ScalePattern, val root: Pitch, val degree: ScaleDegree) {

    fun root(): Pitch = root

    fun above(): ScaleNote = ScaleNote(scalePattern, root, degree.above())
    fun below(): ScaleNote = ScaleNote(scalePattern, root, degree.below())

    fun abovePitch(): Pitch =  Scale(scalePattern, root).pitch(degree.above())
    fun belowPitch(): Pitch = Scale(scalePattern, root).pitch(degree.below())

    companion object {
        fun chromaticNote(pitch: Pitch): ScaleNote {
            return ScaleNote(ScalePattern.Chromatic, pitch, ScaleDegree.I)
        }
    }
}
