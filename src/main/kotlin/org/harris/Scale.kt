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

    fun thirdsFrom(degree: ScaleDegree) : Array<Note> {
        return notes
            .toList()
            .drop(degree.ordinal)
            .plus(notes.toList())
            .plus(notes.toList())
            .filterIndexed { index, _ -> index % 2 == 0 }
            .take(7)
            .toTypedArray()
    }

    fun thirds() : MelodicLine {
        val line = MelodicLine(emptyList())

        for(scaleDegree in ScaleDegree.values()) {
            line.add(
                MelodicFragment(
                    listOf(
                        thirdsFrom(scaleDegree)[0],
                        thirdsFrom(scaleDegree)[1])))
        }

        return line
    }

    fun triads() : MelodicLine {
        val line = MelodicLine(emptyList())

        for(scaleDegree in ScaleDegree.values()) {
            line.add(
                MelodicFragment(
                    listOf(
                        thirdsFrom(scaleDegree)[0],
                        thirdsFrom(scaleDegree)[1],
                        thirdsFrom(scaleDegree)[2])))
        }

        return line
    }

    fun chords() : MelodicLine {
        val line = MelodicLine(emptyList())

        for(scaleDegree in ScaleDegree.values()) {
            line.add(
                MelodicFragment(
                    listOf(
                        thirdsFrom(scaleDegree)[0],
                        thirdsFrom(scaleDegree)[1],
                        thirdsFrom(scaleDegree)[2],
                        thirdsFrom(scaleDegree)[3])))
        }

        return line
    }
}
