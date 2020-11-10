package org.harris

data class Note(private val pitch: Pitch, val scale: ScaleNote, private val duration: NoteDuration = NoteDuration.Whole) {
    fun flat(): Note {
        return Note(pitch.flat(), scale, duration)
    }

    fun sharp(): Note {
        return Note(pitch.sharp(), scale, duration)
    }
}

data class ScaleNote(val scale: ScalePattern, val root: Pitch, val degree: ScaleDegree)
