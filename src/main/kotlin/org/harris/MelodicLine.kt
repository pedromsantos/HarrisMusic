package org.harris

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

open class MelodicLine(internal var phrases : List<MelodicPhrase> = emptyList()) {
    fun add(phrase: MelodicPhrase) {
        phrases = phrases + phrase
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MelodicLine

        if (phrases != other.phrases) return false

        return true
    }

    override fun hashCode(): Int {
        return phrases.hashCode()
    }
}

class MelodicPhraseHalfToneApproach : MelodicPhrase {
    constructor(melodicPhrase: MelodicPhrase) : super(melodicPhrase.notes) {
        notes = listOf(Note.chromaticNote(notes.first().flat())) + notes
    }
}

class MelodicLineHalfToneApproach : MelodicLine {
    constructor(melodicLine: MelodicLine) : super(melodicLine.phrases) {
        for(phrase in phrases) {
            add(MelodicPhraseHalfToneApproach(phrase))
        }
    }
}