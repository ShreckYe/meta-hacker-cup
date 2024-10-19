package c

import kotlin.math.max

fun main() {
    val tt = readln().toInt()
    repeat(tt, ::testCase)
}

fun testCase(tti: Int) {
    val (rr, cc, kk) = readln().splitToSequence(' ').map { it.toInt() }.toList()
    val bb = List(rr) { readln().splitToSequence(' ').map { it.toInt() }.toList() }
    println(bb)

    // let rr >= cc
    fun ans(rr: Int, cc: Int, rdBound: Int, transposed: Boolean) = run {
        //println("$rr $cc $rdBound")
        (0 until rdBound).asSequence().flatMap { rd ->
            //println("rd: $rd")
            // TODO treat 0
            (0 until rr - rd).asSequence().flatMap { r1 ->
                //println("r1: $r1")
                val r2 = r1 + rd
                //println("r2: $r2")
                (0..rd).asSequence().flatMap { cd ->
                    //println("cd: $cd")
                    //(0 until cc - cd).asSequence().mapNotNull { c1 ->
                    (0 until cc).asSequence().flatMap { c1 ->
                        //println("c1: $c1")
                        val burrow1 = Burrow(r1, c1)
                        listOfNotNull(
                            run {
                                val c2 = c1 + cd
                                if (c2 < cc) {
                                    //println("c2: $c2")
                                    val burrow2 = Burrow(r2, c2)
                                    if (transposed)
                                        Hop(burrow1.transposed(), burrow2.transposed(), rd)
                                    else
                                        Hop(burrow1, burrow2, rd)
                                } else null
                            },
                            run {
                                val c2e = c1 - cd
                                if (c2e >= 0) {
                                    val burrow2 = Burrow(r2, c2e)
                                    if (transposed)
                                        Hop(burrow1.transposed(), burrow2.transposed(), rd)
                                    else
                                        Hop(burrow1, burrow2, rd)
                                }
                                else null
                            }
                        )

                    }
                }
            }
        }
            .also { println(it.toList()) }
            .filter { bb[it.burrow1] != bb[it.burrow2] }
            .also { println(it.toList()) }
            .elementAt((kk - 1) / 2)
            .score
    }

    val y = if (rr >= cc) ans(rr, cc, rr, false) else ans(cc, rr, cc, true)

    println("Case #${tti + 1}: $y")
}

data class Burrow(val r: Int, val c: Int) {
    fun transposed() = Burrow(c, r)
    override fun toString() = "($r, $c)"
}

data class Hop(val burrow1: Burrow, val burrow2: Burrow, val score: Int) {
    override fun toString() = "$burrow1->$burrow2"
}

operator fun List<List<Int>>.get(burrow: Burrow) =
    this[burrow.r][burrow.c]
