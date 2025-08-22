package org.harris

inline fun <T> Array<T>.rotate(n: Int): Array<T> = let { sliceArray(n until size) + sliceArray(0 until n) }

inline fun <reified T> Array<T>.moveElement(
    fromIndex: Int,
    toIndex: Int,
): Array<T> = toMutableList().apply { add(toIndex, removeAt(fromIndex)) }.toTypedArray()
