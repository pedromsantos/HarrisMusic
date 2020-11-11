package org.harris

data class Note(private val pitch: Pitch, private val scale: ScaleNote, private val duration: NoteDuration = NoteDuration.Whole) {
    fun flat(): Note = Note(pitch.flat(), scale, duration)

    fun sharp(): Note = Note(pitch.sharp(), scale, duration)

    companion object {
        fun chromaticNote(pitch: Pitch) : Note {
            return Note(pitch, ScaleNote.chromaticScaleNote(pitch))
        }

        fun chromaticNote(note: Note) : Note {
            return Note(note.pitch, ScaleNote.chromaticScaleNote(note.pitch))
        }
    }
}

data class ScaleNote(val scale: ScalePattern, val root: Pitch, val degree: ScaleDegree) {

    companion object {
        fun chromaticScaleNote(pitch: Pitch) : ScaleNote {
            return ScaleNote(ScalePattern.Chromatic, pitch, ScaleDegree.I)
        }
    }
}
