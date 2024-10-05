package c

fun main() {
    val tt = readln().toInt()
    repeat(tt, ::testCase)
}

fun testCase(tti: Int) {
    val (ww, gg, ll) = readln().splitToSequence(' ').map { it.toLong() }.toList()

    val oneUnitAvg = 2 * ll + 1
    val y = (ww - gg).toBigInteger() * oneUnitAvg.toBigInteger() % 998244353.toBigInteger()

    println("Case #${tti + 1}: $y")
}
