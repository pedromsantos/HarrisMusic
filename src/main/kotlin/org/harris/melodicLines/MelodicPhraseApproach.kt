package org.harris.melodicLines

class MelodicPhraseHalfToneApproachFromBelow : MelodicPhrase {
    constructor(melodicPhrase: MelodicPhrase) : super(melodicPhrase.notes) {
        notes = listOf(notes.first().flat()) + notes
    }
}

class MelodicPhraseHalfToneApproachFromAbove : MelodicPhrase {
    constructor(melodicPhrase: MelodicPhrase) : super(melodicPhrase.notes) {
        notes = listOf(notes.first().sharp()) + notes
    }
}

class MelodicPhraseChromaticEnclosureApproach : MelodicPhrase {
    constructor(melodicPhrase: MelodicPhrase) : super(melodicPhrase.notes) {
        notes = listOf(notes.first().sharp(), notes.first().flat()) + notes
    }
}

class MelodicPhraseDiatonicEnclosureApproach : MelodicPhrase {
    constructor(melodicPhrase: MelodicPhrase) : super(melodicPhrase.notes) {
        notes = listOf(notes.first().above(), notes.first().below()) + notes
    }
}
