package com.nichols.dsa.binary_search

fun main(){
    solveMinDiffOpt(0,0, arrayOf(
        intArrayOf(8,4),
        intArrayOf(6,8)
    ))
}
fun solveMinDiffOpt(A: Int, B: Int, C: Array<IntArray>): Int {
    //BRUTE FORCE
    var min = Integer.MAX_VALUE;

    for(i in C.indices){

        //sort row
        C[i].sort()
        if(i > 0){
            //for each column in current row
            for(j in C[i].indices){
                var rowMin = Integer.MAX_VALUE
                val one = C[i][j]
                //Compare to each column in second row
                for(k in C[i].indices){
                    val two = C[i-1][k]
                    rowMin = Math.min(rowMin,Math.abs(one-two))
                }
                min = Math.min(min,rowMin)
            }
        }
    }
    return min
}
fun solveMinDiff(A: Int, B: Int, C: Array<IntArray>): Int {
    //BRUTE FORCE
    var min = Integer.MAX_VALUE;

    for(i in 0 until C.size-1){
        var rowMin = Integer.MAX_VALUE
        for(j in C[i].indices){
            val one = C[i][j]
            for(k in C[i].indices) {
                val two = C[i+1][k]
                rowMin = Math.min(rowMin,Math.abs(one-two))
            }
        }
        min = Math.min(min,rowMin)
    }
    return min
}

