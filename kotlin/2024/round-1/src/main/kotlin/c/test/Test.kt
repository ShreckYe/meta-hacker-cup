package c.test

fun main() {
    var p = 2
    var  n  = 1L
    var i = 0
    do {
        n = n * 2 % 998244353
        i++
    } while (n != 1L)
    println(i)
}
