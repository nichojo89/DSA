package com.nichols.dsa.modular_arithmatic

fun solve(A: Int, B: Int, C: Int): Int {
    var ans = 1L
    for(i in 1..B)
        ans = (ans * A) % C

    return (ans % C).toInt()
}