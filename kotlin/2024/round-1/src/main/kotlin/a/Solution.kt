package a

import kotlin.math.max
import kotlin.math.min

fun main() {
    val tt = readln().toInt()
    repeat(tt, ::testCase)
}

fun testCase(tti: Int) {
    val nn = readln().toInt()
    val aabbs = List(nn) { readln().splitToSequence(' ').map { it.toInt() }.toList().let { it[0] to it[1] } }

    val speedRanges = aabbs.mapIndexed { iM1, (a, b) ->
        val i = (iM1 + 1).toDouble()
         i / b to  i / a // +inf might occur
    }

    val mergedRange = speedRanges.reduce { acc, range ->
        max(acc.first, range.first) to min(acc.second, range.second)
    }

    val y = with(mergedRange) {
        if (first <= second && first < Double.POSITIVE_INFINITY) first else "-1"
    }

    println("Case #${tti + 1}: $y")
}
