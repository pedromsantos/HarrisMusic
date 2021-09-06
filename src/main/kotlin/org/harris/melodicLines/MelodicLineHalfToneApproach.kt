package org.harris.melodicLines

class MelodicLineHalfToneApproach : MelodicLine {
    constructor(melodicLine: MelodicLine) : super(melodicLine.phrases) {
        for(phrase in phrases) {
            add(MelodicPhraseHalfToneApproachFromBelow(phrase))
        }
    }
}