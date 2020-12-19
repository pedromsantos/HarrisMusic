package org.harris

fun <T> Array<T>.rotate(n: Int) =
    let { sliceArray(n until size) + sliceArray(0 until n) }

inline fun <reified T> Array<T>.moveElement(fromIndex: Int, toIndex: Int) =
    toMutableList().apply { add(toIndex, removeAt(fromIndex)) }.toTypedArray()
