package com.nichols.dsa.sorting

fun solveCustomComparater(A: IntArray): IntArray {
    return A.sortedWith(object: Comparator<Int?> {
        override fun compare(o1: Int?, o2: Int?): Int {
            return if (o1!! > o2!!) -1 else if(o1 == o2) 0 else 1
        }

    }).toIntArray()
}
fun main() {
   val rv =  solveReversedString("scaler")
    //crulgzfkif gg ombt vemmoxrgf qoddptokkz op xdq hv
    //hv xdq op qoddptokkz vemmoxrgf ombt gg crulgzfkif
    val g = 0
}
fun solveReversedString(A: String): String {

    val arr = A.toCharArray()
    var s = 0
    var e = A.length-1
    while(s < e) {
        val t = arr[e]
        arr[e] = arr[s]
        arr[s] = t
        s++
        e--
    }
    //scaler
    //relacs
    return String(arr)
}
