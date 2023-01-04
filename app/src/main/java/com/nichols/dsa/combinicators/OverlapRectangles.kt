package com.nichols.dsa.combinicators

class OverlapRectangles {
    fun solve(A: Int, B: Int, C: Int, D: Int, E: Int, F: Int, G: Int, H: Int): Int {
        var x = Math.min(G,C) - Math.max(A,E)
        var y = Math.min(D,H) - Math.max(B,F)
        var area = x*y
        if(x<0 || y < 0)
            area = 0

        return area
    }
}