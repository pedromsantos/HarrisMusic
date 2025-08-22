package org.harris.notes

enum class Octave(
    private val octaveName: String,
    private val value: Int,
    private val midiBaseValue: Int,
) {
    SubContra("Sub contra", -16, 0),
    Contra("Contra", -8, 12),
    Great("Great", -4, 24),
    Small("Small", -2, 36),
    OneLine("One line", 1, 48),
    TwoLine("Two line", 2, 60),
    Threeline("Three line", 4, 72),
    FourLine("Four line", 8, 84),
    FiveLine("Five line", 16, 96),
    SixLine("Six line", 32, 108),
    SevenLine("Seven line", 64, 120),
}
