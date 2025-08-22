package org.harris.notes

import org.harris.notes.NoteDuration.Whole
import org.harris.scales.Scale
import org.harris.scales.ScaleDegree
import org.harris.scales.ScalePattern

data class Note(
    private val pitch: Pitch,
    private val noteInScale: NoteInScale = NoteInScale.chromaticNote(pitch),
    private val duration: NoteDuration = Whole,
) {
    fun flat(): Note = Note(pitch.flat(), NoteInScale.chromaticNote(pitch), duration)

    fun sharp(): Note = Note(pitch.sharp(), NoteInScale.chromaticNote(pitch), duration)

    fun above(): Note = Note(noteInScale.abovePitch(), noteInScale.above(), duration)

    fun below(): Note = Note(noteInScale.belowPitch(), noteInScale.below(), duration)
}

data class NoteInScale(
    val scalePattern: ScalePattern,
    val root: Pitch,
    val degree: ScaleDegree,
) {
    fun root(): Pitch = root

    fun above(): NoteInScale = NoteInScale(scalePattern, root, degree.above())

    fun below(): NoteInScale = NoteInScale(scalePattern, root, degree.below())

    fun abovePitch(): Pitch = Scale(scalePattern, root).pitch(degree.above())

    fun belowPitch(): Pitch = Scale(scalePattern, root).pitch(degree.below())

    companion object {
        fun chromaticNote(pitch: Pitch): NoteInScale = NoteInScale(ScalePattern.Chromatic, pitch, ScaleDegree.I)
    }
}
