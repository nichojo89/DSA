package com.nichols.dsa.graphs

import java.util.*

class IsReachable {
    fun solve(A: Int, B: Array<IntArray>): Int {
        adj = ArrayList(maxn)
        for (i in 0 until maxn) {
            visited[i] = 0
            adj!!.add(ArrayList())
        }
        for (edge in B)
            adj!![edge[0]].add(edge[1])
        return if (isReachable(1, A)) 1 else 0
    }

    companion object {
        var maxn = 100009
        var visited = IntArray(maxn)
        var adj: ArrayList<ArrayList<Int>>? = null
        fun isReachable(s: Int, d: Int): Boolean {
            var s = s
            if (s == d) return true
            val q: Queue<Int> = ArrayDeque()
            q.offer(s)
            visited[s] = 1
            while (q.size > 0) {
                s = q.poll()
                for (v in adj!![s]) {
                    if (v == d) return true
                    if (visited[v] == 0) {
                        visited[v] = 1
                        q.offer(v)
                    }
                }
            }
            return false
        }
    }
}
//class IsReachable(v:Int){
//    var max = 1000009
//    //mark as false
//    var visited = IntArray(max)
//    var adjecency = ArrayList<ArrayList<Int>>(max)
//
//    fun solve(A: Int, B: Array<IntArray>): Int {
//
//        //create the adjacency array
//        for(edge in B)
//            adjecency[edge[0]].add(edge[1])
//
//        return isReachable(1,A)
//    }
//
//    private fun isReachable(source:Int, destination: Int) : Int{
//        val q: Queue<Int> = ArrayDeque()
//
//        //insert source into queue
//        q.offer(source)
//        visited[source] = 1
//        while(q.isNotEmpty()){
//
//        }
//        return 1
//    }
//}


