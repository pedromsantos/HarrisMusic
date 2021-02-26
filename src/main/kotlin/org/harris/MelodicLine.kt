package org.harris

import org.harris.notes.Note

data class MelodicFragment(private var notes: List<Note> = listOf()) {
    fun addHalfToneApproach() : MelodicFragment {
        return MelodicFragment(listOf(Note.chromaticNote(notes.first().flat())) + notes)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MelodicFragment

        if (notes != other.notes) return false

        return true
    }

    override fun hashCode(): Int {
        return notes.hashCode()
    }
}

data class MelodicLine(private var fragements : List<MelodicFragment>) {
    fun add(fragment: MelodicFragment) {
        fragements = fragements + fragment
    }

    fun hallToneApproachBellowToFragments() : MelodicLine {
        var line = MelodicLine(emptyList())

        for(fragment in fragements) {
            line.add(fragment.addHalfToneApproach())
        }

        return line
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MelodicLine

        if (fragements != other.fragements) return false

        return true
    }

    override fun hashCode(): Int {
        return fragements.hashCode()
    }
}