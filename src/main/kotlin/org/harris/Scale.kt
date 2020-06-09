package org.harris

class Scale {
    private val pattern: ScalePattern
    private val root: Note
    private val notes: Array<Note>

    constructor(pattern: ScalePattern, root: Note) {
        this.pattern = pattern
        this.root = root
        this.notes = pattern.notes(root)
    }

    fun notes(): Array<Note> = notes
}