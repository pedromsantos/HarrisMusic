package org.harris.melodicLines

import org.harris.notes.Note

open class MelodicPhrase(internal var notes: List<Note> = listOf()) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MelodicPhrase

        if (notes != other.notes) return false

        return true
    }

    override fun hashCode(): Int {
        return notes.hashCode()
    }
}
