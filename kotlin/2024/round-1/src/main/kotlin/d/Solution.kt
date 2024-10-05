package d

fun main() {
    val tt = readln().toInt()
    repeat(tt, ::testCase)
}

fun testCase(tti: Int) {
    val (ee, kkString) = readln().split(' ')
    val kk = kkString.toInt()

    val options = ee.mapIndexedNotNull { i, c ->
        if (c == '?') {
            val right = ee.getOrNull(i + 1)
            i to when (ee.getOrNull(i - 1)) {
                null -> wildCardNumbersWithRight(right, 9)
                '0' -> wildCardNumbersWithRight(right, 9)
                '1' -> wildCardNumbersWithRight(right, 9)
                '2' -> wildCardNumbersWithRight(right, 6)
                '?' -> wildCardNumbersWithRight(right, 6)
                else -> wildCardNumbersWithRight(right, 9)
            }
        } else null
    }

    fun List<Pair<Int, IntRange>>.findKTh(kM1: Int): List<Int> {
        val lastSize = last().second.count()
        return if (isEmpty()) {
            if (kM1 == 0) emptyList()
            else throw IllegalArgumentException()
        } else
            subList(0, lastIndex).findKTh(kM1 / lastSize) + listOf(kM1 % lastSize)
    }

    val wildCardNumbers = options.findKTh(kk - 1)
    //ee.replace()

    val y = TODO()
    println("Case #${tti + 1}: $y")
}

fun wildCardNumbersWithRight(right: Char?, max: Int) =
    when (right) {
        null -> 1..max
        '0' -> 1..2
        '?' -> 1..2 // and right ? 1 - 6 only

        else -> {
            when {
                right <= '6' -> 1..2
                else -> 1..1
            }
            //throw IllegalArgumentException()
        }
    }

// Case starting with 0?