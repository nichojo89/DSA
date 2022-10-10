package com.nichols.dsa.collections

/**
 * Traverse in an anti-diagonal pattern and add 0 to make the 2D array horizontally even
 */
fun antiDiagonals(A: Array<IntArray>): Array<IntArray>{

    //largest array size
    val m = A.maxOf { it.size }
    val result = arrayListOf<IntArray>()

    for(j in 0 until m){
        var r = 0
        var c = j
        val arr = ArrayList<Int>(m)

        //traverse anti diagonally
        while(r < m){
            if(r < A.size && c >= 0){
                print(A[r][c])
                arr.add(A[r][c])
            } else {
                arr.add(0)
            }

            r++
            c--
        }
        result.add(arr.toIntArray())
    }

    for(i in 0 until A.size-1){
        var r = i+1
        var c = m-1
        val arr = ArrayList<Int>(m)

        for(i in 0 until m){
            if(r < A.size && c >= 0){
                print(A[r][c])
                arr.add(A[r][c])
            } else {
                arr.add(0)
            }

            r++
            c--
        }
        result.add(arr.toIntArray())
    }


    return result.toTypedArray()
}
fun diagonal(A: Array<IntArray>) {
    val n = A.size
    val N = 2 * n - 1
    val result: Array<IntArray> = Array(5){_ -> IntArray(3)}

    // Push each element in the result vector
    for (i in 0 until n)
        for (j in 0 until A[i].size) {
            val index = i + j
            val row = result[index]
            row[row.size] = A[i][j]
//            1
//            2 4
//            3 5 7
//            6 8
//            9
        }


    // Print the diagonals
    for (i in 0 until result.size) {
        println()
        for (j in 0 until result[i].size)
            print(result[i][j].toString() + " ")
    }
}

fun diagonals(A: Array<IntArray>): Array<IntArray>{
    val n = A.size
    val N = 2 * n - 1
    val result: ArrayList<ArrayList<Int>> = ArrayList()
    for (i in 0 until N)
        result.add(ArrayList())

    var maxIndex = 0
    // Push each element in the result vector
    for (i in 0 until n){
        for (j in 0 until n){
            val x = A[i][j]
            val index = i + j

            result[index].add(x)

            if(j > maxIndex)
                maxIndex = j
        }
    }

    //add zeros
    for(arr in result){
        //needs zeros
        if(arr.size-1 != maxIndex){

            for(i in 0..maxIndex){
                if(i > arr.size-1){
                    arr.add(0)
                }
            }
        }
    }

    val test =0
    return A
}