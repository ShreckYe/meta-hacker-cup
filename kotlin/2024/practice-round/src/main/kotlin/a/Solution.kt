package a

fun main() {
    val tt = readln().toInt()
    repeat(tt, ::testCase)
}

fun testCase(tti: Int) {
    val (nn, kk) = readln().splitToSequence(' ').map { it.toInt() }.toList()
    val ss = List(nn) { readln().toLong() }

    val minS = ss.min()

    val minTime = when {
        nn == 1 -> 1
        nn >= 1 -> (nn - 1) * 2 - 1
        else -> throw IllegalArgumentException()
    } * minS
    val y = minTime <= kk

    println("Case #${tti + 1}: ${if (y) "YES" else "NO"}")
}
