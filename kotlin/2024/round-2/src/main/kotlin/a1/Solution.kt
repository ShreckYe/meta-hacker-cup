package a1

fun main() {
    val tt = readln().toInt()
    repeat(tt, ::testCase)
}

fun testCase(tti: Int) {
    val (aa, bb, mm) = readln().splitToSequence(' ').map { it.toLong() }.toList()

    val y = peaksWithinRange.asSequence()
        .filter { it in aa..bb && it % mm == 0L }
        .count()

    println("Case #${tti + 1}: $y")
}

val peaksWithinRange = (0..8).asSequence().flatMap { k ->
    (1..9).asSequence().map { start ->
        val prefix = (start..9).take(k + 1).joinToString("")
        (prefix + prefix.dropLast(1).reversed()).toLong()
    }
}.distinct().toList()
