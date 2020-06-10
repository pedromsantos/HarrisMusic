package org.harris

fun <T> Array<T>.rotate(n: Int) =
    let { sliceArray(n until size) + sliceArray(0 until n) }