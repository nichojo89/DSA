package com.nichols.dsa.heaps

import java.util.*

fun solve(A: ArrayList<Int>, B: Int): ArrayList<Int>? {
    var K = B
    val q = PriorityQueue<Pair<Double, Pair<Int, Int>>>(
        object : Comparator<Pair<Double?, Pair<Int?, Int?>?>?> {
            fun compare(
                a: Pair<Double?, Pair<Int?, Int?>?>,
                b: Pair<Double?, Pair<Int?, Int?>?>
            ): Int {
                return java.lang.Double.compare(a.getFirst(), b.getFirst())
            }
        }
    )
    val nxt = HashMap<Int, Int>()
    for (i in A.size - 1 downTo 1) nxt[A[i]] = A[i - 1]
    val last = A[A.size - 1].toDouble()
    var d: Double
    nxt[1] = 0
    for (i in A.indices) {
        d = A[i].toDouble() / last
        q.add(Pair(d, Pair(A[i], last.toInt())))
    }
    while (q.size > 0 && K > 0) {
        K--
        if (K == 0) break
        val p = q.poll()
        if (nxt[p..getSecond()] != 0) {
            val y = nxt[p.getSecond().getSecond()]!!
            d = p.getFirst() as Double / y.toDouble()
            q.add(Pair<Double, Pair<Int, Int>>(d, Pair<Int, Int>(p.getSecond().getFirst(), y)))
        }
    }
    val ret = ArrayList<Int>()
    ret.add(q.peek().getSecond().getFirst())
    ret.add(q.peek().getSecond().getSecond())
    return ret
}
fun solveConnectRopes(A: IntArray): Int {
    var res = 0
    val Q = PriorityQueue<Int>()

    for (i in A)
        Q.add(i)

    while (Q.size > 1) {
        val first = Q.poll()!!
        val second = Q.poll()!!

        res += first + second
        Q.add(first + second)
    }
    return res
}