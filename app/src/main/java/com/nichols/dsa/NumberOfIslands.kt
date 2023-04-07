package com.nichols.dsa

class NumberOfIslands {

    fun solve(A: Array<IntArray>): Int {
        var count = 0
        for(i in A.indices)
            for(j in A[i].indices)
                if(A[i][j] == 1){
                    count += 1
                    DFS(A,i,j, A.size, A[i].size)
                }
        return count
    }

    fun DFS(A: Array<IntArray>, i: Int, j: Int, r: Int, c: Int) {
        if (i < 0 || j < 0 || i > (r - 1) || j > (c - 1) || A[i][j] != 1)
            return

        if (A[i][j] == 1) {
            A[i][j] = 0
            DFS(A, i + 1, j, r,c) // right
            DFS(A, i - 1, j, r, c) // left
            DFS(A, i, j + 1, r, c) // up
            DFS(A, i, j - 1, r, c) // down
            DFS(A, i + 1, j + 1, r, c) // up-right
            DFS(A, i - 1, j - 1, r, c) // down-left
            DFS(A, i + 1, j - 1, r, c) // down-right
            DFS(A, i - 1, j + 1, r, c) // up-left
        }
    }

    fun BFS(A: Array<IntArray>, i: Int, j: Int){
        if(i < 0 || i >= A.size || j < 0 || j >= A[i].size || A[i][j] == 0)
            return

        A[i][j] = 0

        BFS(A,i+1,j)
        BFS(A,i-1,j)
        BFS(A,i,j-1)
        BFS(A,i,j+1)
    }


}