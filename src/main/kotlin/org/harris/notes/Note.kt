package org.harris.notes

import org.harris.scales.ScaleDegree
import org.harris.scales.ScalePattern
import org.harris.notes.NoteDuration.*

data class Note(
    private val pitch: Pitch,
    private val scale: ScaleNote = ScaleNote.chromaticNote(pitch),
    private val duration: NoteDuration = Whole) {

    fun flat(): Note = Note(pitch.flat(), scale, duration)

    fun sharp(): Note = Note(pitch.sharp(), scale, duration)

    companion object {
        fun chromaticNote(note: Note) : Note {
            return Note(note.pitch)
        }
    }
}

data class ScaleNote(val scale: ScalePattern, val root: Pitch, val degree: ScaleDegree) {

    companion object {
        fun chromaticNote(pitch: Pitch) : ScaleNote {
            return ScaleNote(ScalePattern.Chromatic, pitch, ScaleDegree.I)
        }
    }
}
