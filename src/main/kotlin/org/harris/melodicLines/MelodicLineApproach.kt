package org.harris.melodicLines

class MelodicLineHalfToneApproachFromBelow : MelodicLine {
    constructor(melodicLine: MelodicLine) : super(melodicLine.phrases) {
        for (phrase in phrases) {
            add(MelodicPhraseHalfToneApproachFromBelow(phrase))
        }
    }
}

class MelodicLineHalfToneApproachFromAbove : MelodicLine {
    constructor(melodicLine: MelodicLine) : super(melodicLine.phrases) {
        for (phrase in phrases) {
            add(MelodicPhraseHalfToneApproachFromAbove(phrase))
        }
    }
}

class MelodicLineChromaticEnclosureApproach : MelodicLine {
    constructor(melodicLine: MelodicLine) : super(melodicLine.phrases) {
        for (phrase in phrases) {
            add(MelodicPhraseChromaticEnclosureApproach(phrase))
        }
    }
}

class MelodicLineDiatonicEnclosureApproach : MelodicLine {
    constructor(melodicLine: MelodicLine) : super(melodicLine.phrases) {
        for (phrase in phrases) {
            add(MelodicPhraseDiatonicEnclosureApproach(phrase))
        }
    }
}
