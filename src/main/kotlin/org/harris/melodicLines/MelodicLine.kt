package org.harris.melodicLines

open class MelodicLine(internal var phrases: List<MelodicPhrase> = emptyList()) {
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
