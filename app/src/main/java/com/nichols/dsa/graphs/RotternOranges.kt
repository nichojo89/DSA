package com.nichols.dsa.graphs

import java.util.*

fun solve(A: Array<IntArray>, B: IntArray, C: IntArray): Int {
    val visited = Array(A.size) {
        BooleanArray(
            A[0].size
        )
    }
    return if(reach(A, B[0], B[1], C, visited)) 1 else 0
}

private fun reach(A: Array<IntArray>, i: Int, j: Int, dest: IntArray, visited: Array<BooleanArray>): Boolean {
    if (i == dest[0] && j == dest[1]) {
        return true
    }
    if (visited[i][j]) {
        return false
    }
    visited[i][j] = true
    val dirs = Array(4) { IntArray(2) }
    dirs[0] = intArrayOf(0, 1)
    dirs[1] = intArrayOf(1, 0)
    dirs[2] = intArrayOf(0, -1)
    dirs[3] = intArrayOf(-1, 0)
    for (k in dirs.indices) {
        var x = i
        var y = j
        while (x >= 0 && x < A.size && y >= 0 && y < A[0].size && A[x][y] == 0) {
            x += dirs[k][0]
            y += dirs[k][1]
        }
        x -= dirs[k][0]
        y -= dirs[k][1]
        if (!visited[x][y] && reach(A, x, y, dest, visited)) {
            return true
        }
    }
    return false
}

class RotternOranges {
    val R = 3
    val C = 5

    class Point(x:Int, y:Int) {
        var x = 0
        var y = 0

        init {
            this.x = x
            this.y = y
        }
    }

    fun isValid(i: Int, j: Int): Boolean {
        return i >= 0 && (j >= 0) && i < R && j < C
    }

    fun isDelim(temp: Point): Boolean {
        return temp.x == -1 && temp.y == -1
    }

    fun checkAll(arr: Array<IntArray>): Boolean {
        for (i in 0 until R) for (j in 0 until C) if (arr[i][j] == 1) return true
        return false
    }

    fun rotOranges(arr: Array<IntArray>): Int {
        val Q: Queue<Point> = LinkedList()
        var temp: Point
        var ans = 0

        for (i in 0 until R)
            for (j in 0 until C)
                if (arr[i][j] == 2)
                    Q.add(Point(i, j))

        Q.add(Point(-1, -1))

        while (!Q.isEmpty()) {
            var flag = false

            while (!isDelim(Q.peek())) {
                temp = Q.peek()
                if (isValid(temp.x + 1, temp.y)
                    && arr[temp.x + 1][temp.y] == 1) {
                    if (!flag) {
                        ans++
                        flag = true
                    }

                    arr[temp.x + 1][temp.y] = 2

                    temp.x++
                    Q.add(Point(temp.x, temp.y))

                    temp.x--
                }
                if (isValid(temp.x - 1, temp.y)
                    && arr[temp.x - 1][temp.y] == 1) {
                    if (!flag) {
                        ans++
                        flag = true
                    }
                    arr[temp.x - 1][temp.y] = 2
                    temp.x--
                    Q.add(Point(temp.x, temp.y))
                    temp.x++
                }
                if (isValid(temp.x, temp.y + 1)
                    && arr[temp.x][temp.y + 1] == 1) {
                    if (!flag) {
                        ans++
                        flag = true
                    }
                    arr[temp.x][temp.y + 1] = 2
                    temp.y++
                    Q.add(Point(temp.x, temp.y))
                    temp.y--
                }
                if (isValid(temp.x, temp.y - 1)
                    && arr[temp.x][temp.y - 1] == 1) {
                    if (!flag) {
                        ans++
                        flag = true
                    }
                    arr[temp.x][temp.y - 1] = 2
                    temp.y--
                    Q.add(Point(temp.x, temp.y))
                }
                Q.remove()
            }

            Q.remove()

            if (!Q.isEmpty())
                Q.add(Point(-1, -1))
        }

        return if (checkAll(arr)) -1 else ans
    }
}
//class RotternOranges {
//    private val R = 3
//    private val C = 5
//
//    fun solve(A: Array<IntArray>): Int {
//        var Q: Queue<Point> = LinkedList()
//        var temp: Point
//        var ans = 0
//        for(i in 0..R)
//            for(j in 0..C)
//                if(A[i][j] == 2)
//                    Q.add(Point(i,j))
//
//        //seperate orAnges
//        Q.add(Point(-1,-1))
//
//        while(Q.isNotEmpty()){
//            var flag= false
//
//            while(!isDelimeter(Q.peek())){
//                temp = Q.peek()
//
//                if(isValid(temp.x+1,temp.y)
//                    && A[temp.x+1][temp.y]==1){
//                    if(!flag){
//                        ans++
//                        flag=true
//                    }
//
//                    A[temp.x+1][temp.y] =2
//
//                    temp.x++
//                    Q.add(Point(temp.x,temp.y))
//
//                    temp.x--
//                }
//
//                if(isValid(temp.x-1,temp.y)
//                    && A[temp.x-1][temp.y]==1){
//                    if(!flag){
//                        ans++
//                        flag = true
//                    }
//                    A[temp.x-1][temp.y]=2
//                    temp.x--
//                    Q.add(Point(temp.x,temp.y))
//                    temp.x++
//                }
//
//                if (isValid(temp.x, temp.y + 1)
//                    && A[temp.x][temp.y + 1] == 1) {
//                    if (!flag) {
//                        ans++
//                        flag = true
//                    }
//                    A[temp.x][temp.y + 1] = 2
//                    temp.y++
//                    Q.add(Point(temp.x, temp.y))
//                    temp.y--
//                }
//
//                if (isValid(temp.x, temp.y - 1)
//                    && A[temp.x][temp.y - 1] == 1) {
//                    if (!flag) {
//                        ans++
//                        flag = true
//                    }
//                    A[temp.x][temp.y - 1] = 2
//                    temp.y--
//                    Q.add(Point(temp.x, temp.y))
//                }
//                Q.remove()
//            }
//
//            Q.remove()
//
//            if(Q.isNotEmpty())
//                Q.add(Point(-1,-1))
//        }
//
//        return if(checkAll(A)) -1 else ans
//    }
//
//    private fun checkAll(arr: Array<IntArray>): Boolean {
//        for (i in 0 until R)
//            for (j in 0 until C)
//                if (arr[i][j] == 1)
//                    return true
//        return false
//    }
//
//
//    private fun isValid(i:Int, j:Int): Boolean =
//        i>=0&&j>=0&&i<R&&j<C
//
//    /**
//     * Is function delimeter point
//     */
//    fun isDelimeter(A:Point): Boolean =
//        A.x==-1&&A.y==-1
//}