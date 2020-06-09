package org.harris

class Chord {
    private val pattern: ChordPattern

    private val root: Note
    private val notes: Array<Note>

    constructor(pattern: ChordPattern, root: Note) {
        this.pattern = pattern
        this.root = root
        this.notes = pattern.notes(root)
    }

    fun notes(): Array<Note> = notes
}