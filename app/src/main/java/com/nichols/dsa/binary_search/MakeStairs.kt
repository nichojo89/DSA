package com.nichols.dsa.binary_search

fun solveMakeStairs(A: Int): Int {
    var blocks = A
    var stairs = 0
    while (blocks != 0)
    {
        if (stairs + 1 <= blocks)
        {
            stairs++
            blocks = blocks - stairs
        }
        else
            break
    }

    return stairs
}