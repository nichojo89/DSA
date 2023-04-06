package com.nichols.dsa.dynamicprogramming

class NumTrees {
    fun numTrees(A: Int): Int {
        var ans = 0
        for(i in 0..A){
            ans *= (2 * A - i)
            ans /= (i + 1)
        }
        ans /= (A + 1)
        return ans
    }
}