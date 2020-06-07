package org.harris

enum class NoteDuration(private val durationName: String, private val multiplier: Float) {
    Whole("Whole", 1.0F),
    Half("Half", 1.0F / 2.0F),
    Quarter("Quarter", 1.0F / 4.0F);

    fun toBeats(timeSignature: Float): Float {
        return this.multiplier * timeSignature
    }
}