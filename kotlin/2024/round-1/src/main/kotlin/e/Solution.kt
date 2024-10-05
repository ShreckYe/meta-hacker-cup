package e

fun main() {
    val tt = readln().toInt()
    repeat(tt, ::testCase)
}

fun testCase(tti: Int) {
    val nn = readln().toInt()
    val sss = List(nn) { readln() }

    TODO("compute")

    val y = TODO()
    println("Case #${tti + 1}: $y")
}

fun numNodesMod(ss: List<String>): NumMod  {
    val ssGrouped = ss.groupBy { it.firstOrNull() }
    val wildcardGroup = ssGrouped['?']
    val ssGroupedNotWildcard = ssGrouped.filterKeys { it !== '?' }
    ssGroupedNotWildcard.values
    TODO("Complexity seems to increase exponentially")
}

@JvmInline
value class NumMod(val number: Long) {
    operator fun plus(other: NumMod) =
        (number + other.number) % 998244353

    operator fun times(other: NumMod) =
        (number * other.number) % 998244353
}
