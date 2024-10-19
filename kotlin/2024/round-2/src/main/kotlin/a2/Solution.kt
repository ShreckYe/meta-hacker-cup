package a2

import kotlin.math.max

fun main() {
    val tt = readln().toInt()
    repeat(tt, ::testCase)
}

fun testCase(tti: Int) {
    val (aa, bb, mm) = readln().splitToSequence(' ').map { it.toLong() }.toList()

    val y = mountains.count { it in aa..bb && it % mm == 0L }

    println("Case #${tti + 1}: $y")
}

val increasings = (1..7).asSequence().scan(
    (1..8 /*9*/).map { it.toString() }
) { dss, _ ->
    dss.flatMap { ds ->
        (ds.last().digitToInt()..8 /*9*/).map { d ->
            ds + d
        }
    }
}
    .flatten()
//.apply { println(toList()) }
//.apply { println(count()) }

/*
val increasingMap = increasings
    .groupBy { it.length to it.last() }
/*.apply {
    println(mapValues { it.value.size })
    println(values.sumOf { it.size })
}*/
*/

/*
val mountains = incresings.map { prefix ->
    (prefix + prefix.dropLast(1).reversed()).toLong()
}.toList()
*/

/*
// "the middle digit is unique"!
val oldMountains = (1L..9L) + increasingMap.values.flatMap {
    //val lastD = it.key.second
    //val increasings = it.value
    val increasings = it
    increasings.asSequence().flatMap { prefix ->
        increasings.asSequence().map { suffixR ->
            (prefix + suffixR.dropLast(1).reversed()).toLong()
        }
    }
}
//.apply { println(size) }
*/

val mountains = ((1L..9L) + increasings.flatMap { prefix ->
    increasings.flatMap { suffixR ->
        (max(prefix.last().digitToInt(), suffixR.last().digitToInt()) + 1..9).map { middleD ->
            (prefix + middleD + suffixR.reversed()).toLong()
        }
    }
})
    /*.apply {
        println(count())
        println(max())
        println(filter { it <= 132 })
        //println(this)
    }*/
    /*.apply {
        println(filter { it in 12345678987654321..12345678987654322 })
    }*/
