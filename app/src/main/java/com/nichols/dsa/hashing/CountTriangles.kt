package com.nichols.dsa.hashing

fun solveCountTriangles(A: IntArray, B: IntArray): Int {
    val x = Array(A.size){ IntArray(2) }
    for(i in A.indices)
        x[i] = intArrayOf(A[i], B[i])

    return RightAngled(x)
}

fun RightAngled(a: Array<IntArray>): Int {
    val xpoints = hashMapOf<Int,Int>()
    val ypoints = hashMapOf<Int,Int>()
    for (i in a.indices) {
        if (xpoints.containsKey(a[i][0])) {
            xpoints[a[i][0]] = xpoints[a[i][0]]!! + 1
        } else {
            xpoints[a[i][0]] = 1
        }
        if (ypoints.containsKey(a[i][1])) {
            ypoints[a[i][1]] = ypoints[a[i][1]]!! + 1
        } else {
            ypoints[a[i][1]] = 1
        }
    }

    var count = 0

    for (i in a.indices) {
        if (xpoints[a[i][0]]!! >= 1 &&
            ypoints[a[i][1]]!! >= 1
        ) {
            count += (xpoints[a[i][0]]!! - 1) *
                    (ypoints[a[i][1]]!! - 1)
        }
    }

    return count
}