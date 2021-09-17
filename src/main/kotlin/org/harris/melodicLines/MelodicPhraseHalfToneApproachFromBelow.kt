package org.harris.melodicLines

class MelodicPhraseHalfToneApproachFromBelow : MelodicPhrase {
    constructor(melodicPhrase: MelodicPhrase) : super(melodicPhrase.notes) {
        notes = listOf(notes.first().flat()) + notes
    }
}
