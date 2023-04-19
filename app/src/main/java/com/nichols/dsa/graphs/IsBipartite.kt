package com.nichols.dsa.graphs

class IsBipartite {
    val V = 4

    fun colorGraph(
        G: Array<IntArray>,
        color: IntArray,
        pos: Int, c: Int
    ): Boolean {
        if (color[pos] != -1 &&
            color[pos] != c
        ) return false

        // color this pos as c and
        // all its neighbours as 1-c
        color[pos] = c
        var ans = true
        for (i in 0 until V) {
            if (G[pos][i] == 1) {
                if (color[i] == -1) ans = ans and colorGraph(G, color, i, 1 - c)
                if (color[i] != -1 && color[i] != 1 - c) return false
            }
            if (!ans) return false
        }
        return true
    }

    fun isBipartite(G: Array<IntArray>): Boolean {
        val color = IntArray(V)
        for (i in 0 until V) color[i] = -1

        // start is vertex 0;
        val pos = 0

        // two colors 1 and 0
        return colorGraph(G, color, pos, 1)
    }
}