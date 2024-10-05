package b

import kotlin.math.sqrt

fun main() {
    val tt = readln().toInt()

    val primesTo10000000 = primesToWithSoe(10000000)

    repeat(tt) {
        testCase(it, primesTo10000000)
    }
}

fun testCase(tti: Int, primesTo10000000: List<Int>) {
    val nn = readln().toInt()

    val primesToN = primesTo10000000.takeWhile { it <= nn }
    //val twoOrNull = primesToN.firstOrNull()
    val subtractorizationsHasTwo = /*twoOrNull !== null &&*/ nn >=5

    val oddPrimesToN = primesToN.drop(1)
    val oddNSubtractorizations = oddPrimesToN.asSequence().zipWithNext().filter {
        it.second - it.first == 2
    }

    val y = (if (subtractorizationsHasTwo) 1 else 0) + oddNSubtractorizations.count()
    println("Case #${tti + 1}: $y")
}

fun primesToWithSoe(n: Int): List<Int> {
    // BooleanArray is slightly faster than BitSet
    val a = BooleanArray(n + 1) { true }
    for (i in 2..sqrt(n.toDouble()).toInt())
        if (a[i]) {
            var j = i * i
            while (j <= n) {
                a[j] = false
                j += i
            }
        }
    return (2..n).filter { a[it] }
}
