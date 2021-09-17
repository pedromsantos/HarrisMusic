package org.harris.melodicLines

import org.harris.notes.Note

class MelodicPhraseHalfToneApproachFromBelow : MelodicPhrase {
    constructor(melodicPhrase: MelodicPhrase) : super(melodicPhrase.notes) {
        notes = listOf(Note.chromaticNote(notes.first().flat())) + notes
    }
}
