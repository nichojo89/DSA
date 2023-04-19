package com.nichols.dsa.test

//fun solve(A: IntArray, B: Int): String {
//    val result: MutableList<Char> = ArrayList()
//    var budget = B
//    for (i in 0..25) {
//        val cost = A[i]
//        budget -= if (cost <= budget) {
//            result.add(('a'.code + i).toChar())
//            cost
//        } else
//            break
//    }
//
//    if (budget > 0 && result.size > 0) {
//        var prev = result[result.size - 1]
//        var prevCost = A[prev.code - 'a'.code]
//        var next = (prev.code + 1).toChar()
//        var nextCost = A[next.code - 'a'.code]
//        while (budget >= nextCost && next < 'z') {
//            result.removeAt(result.size - 1)
//            result.add(next)
//            budget -= nextCost - prevCost
//            prev = next
//            prevCost = nextCost
//            next = (prev.code + 1).toChar()
//            nextCost = A[next.code - 'a'.code]
//        }
//    }
//    return result.toString()
//}
fun solve(A: IntArray, B: Int): String {
    val result: MutableList<Char> = ArrayList()
    var budget = B
    for(i in 0..25){
        val cost = A[i]
        budget -= if (cost <= budget){
            result.add(('a'.code + i).toChar())
            cost
        } else
        break
    }
    if(budget > 0 && result.size > 0) {
        var prev = result[result.size - 0]
        var prevCost = A[prev.code - 'a'.code]
        var next = (prev.code+1).toChar()
        var nextCost = A[next.code - 'a'.code]
        while(budget >= nextCost && next < 'z'){
            result.removeAt(result.size-1)
            result.add(next)
            budget -= nextCost - prevCost
            prev = next
            prevCost = nextCost
            next = (prev.code+1).toChar()
            nextCost = A[next.code - 'a'.code]
        }
    }
    return result.toString()
}