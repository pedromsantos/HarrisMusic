package org.harris

import junitparams.Parameters
import org.harris.Note.*
import org.junit.Test
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo

class NoteShould {
    @Test
    fun `transpose note by a half step up when sharped`() {
        assertThat(C.sharp(), equalTo(CSharp))
        assertThat(CSharp.sharp(), equalTo(D))
        assertThat(DFlat.sharp(), equalTo(D))
        assertThat(D.sharp(), equalTo(DSharp))
        assertThat(DSharp.sharp(), equalTo(E))
        assertThat(EFlat.sharp(), equalTo(E))
        assertThat(E.sharp(), equalTo(F))
        assertThat(F.sharp(), equalTo(FSharp))
        assertThat(FSharp.sharp(), equalTo(G))
        assertThat(GFlat.sharp(), equalTo(G))
        assertThat(G.sharp(), equalTo(GSharp))
        assertThat(GSharp.sharp(), equalTo(A))
        assertThat(AFlat.sharp(), equalTo(A))
        assertThat(A.sharp(), equalTo(ASharp))
        assertThat(ASharp.sharp(), equalTo(B))
        assertThat(BFlat.sharp(), equalTo(B))
        assertThat(B.sharp(), equalTo(C))
    }

    @Test
    fun `transpose note by a half step down when flated`() {
        assertThat(C.flat(), equalTo(B))
        assertThat(CSharp.flat(), equalTo(C))
        assertThat(DFlat.flat(), equalTo(C))
        assertThat(D.flat(), equalTo(DFlat))
        assertThat(DSharp.flat(), equalTo(D))
        assertThat(EFlat.flat(), equalTo(D))
        assertThat(E.flat(), equalTo(EFlat))
        assertThat(F.flat(), equalTo(E))
        assertThat(FSharp.flat(), equalTo(F))
        assertThat(GFlat.flat(), equalTo(F))
        assertThat(G.flat(), equalTo(GFlat))
        assertThat(GSharp.flat(), equalTo(G))
        assertThat(AFlat.flat(), equalTo(G))
        assertThat(A.flat(), equalTo(AFlat))
        assertThat(ASharp.flat(), equalTo(A))
        assertThat(BFlat.flat(), equalTo(A))
        assertThat(B.flat(), equalTo(BFlat))
    }
}
