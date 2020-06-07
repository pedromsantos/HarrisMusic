package org.harris

import junit.framework.Assert.assertEquals
import junitparams.JUnitParamsRunner
import junitparams.Parameters
import org.harris.Note.*
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(JUnitParamsRunner::class)
class NoteShould {
    @Test
    @Parameters(method = "sharpingNotesValues")
    fun `transpose note by a half step up when sharped`(note: Note, sharpedNote:Note) {
        val to = note.sharp()

        assertEquals(sharpedNote, to)
    }

    @Test
    @Parameters(method = "flateningNotesValues")
    fun `transpose note by a half step down when flated`(note: Note, flatedNote:Note) {
        val to = note.flat()

        assertEquals(flatedNote, to)
    }

    private fun sharpingNotesValues(): Array<Any>? {
        return arrayOf(
            arrayOf<Any>(C, CSharp),
            arrayOf<Any>(CSharp, D),
            arrayOf<Any>(DFlat, D),
            arrayOf<Any>(D, DSharp),
            arrayOf<Any>(DSharp, E),
            arrayOf<Any>(EFlat, E),
            arrayOf<Any>(E, F),
            arrayOf<Any>(F, FSharp),
            arrayOf<Any>(FSharp, G),
            arrayOf<Any>(GFlat, G),
            arrayOf<Any>(G, GSharp),
            arrayOf<Any>(GSharp, A),
            arrayOf<Any>(AFlat, A),
            arrayOf<Any>(A, ASharp),
            arrayOf<Any>(ASharp, B),
            arrayOf<Any>(BFlat, B),
            arrayOf<Any>(B, C)
        )
    }

    private fun flateningNotesValues(): Array<Any>? {
        return arrayOf(
            arrayOf<Any>(C, B),
            arrayOf<Any>(CSharp, C),
            arrayOf<Any>(DFlat, C),
            arrayOf<Any>(D, DFlat),
            arrayOf<Any>(DSharp, D),
            arrayOf<Any>(EFlat, D),
            arrayOf<Any>(E, EFlat),
            arrayOf<Any>(F, E),
            arrayOf<Any>(FSharp, F),
            arrayOf<Any>(GFlat, F),
            arrayOf<Any>(G, GFlat),
            arrayOf<Any>(GSharp, G),
            arrayOf<Any>(AFlat, G),
            arrayOf<Any>(A, AFlat),
            arrayOf<Any>(ASharp, A),
            arrayOf<Any>(BFlat, A),
            arrayOf<Any>(B, BFlat)
        )
    }
}
